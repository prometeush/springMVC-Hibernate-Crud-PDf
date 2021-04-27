package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Student> studentList(){
		Query<Student> sql=getSession().createQuery("from Student");
		List<Student> list=sql.list();
		return list;
	}
	
	public void studentSave(Student student) {
		this.getSession().save(student);
	}
	public void studentDelete(Integer id) {
		Student student=this.getSession().get(Student.class, id);
		this.getSession().delete(student);
	}
	
	public void studentUpdate(Student student) {
		this.getSession().update(student);
	}
	
	public Student studentFindById(Integer id) {
		Student student=this.getSession().get(Student.class, id);
		return student;
	}
	
	public List<Student> studentSearch(String keyword) throws InterruptedException{
		FullTextEntityManager fullTextEntityManager=Search.getFullTextEntityManager(getSession());
		fullTextEntityManager.createIndexer().startAndWait();
		
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory() 
				  .buildQueryBuilder()
				  .forEntity(Student.class)
				  .get();
		
		org.apache.lucene.search.Query query = queryBuilder
				  .keyword()
				  .onFields("vorname","nachname")
				  .matching(keyword)
				  .createQuery();
		
		
		
		FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Student.class);
		List<Student> results = jpaQuery.getResultList();
		return results;
	}
}
