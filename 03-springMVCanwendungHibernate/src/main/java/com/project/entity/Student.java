package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

@Entity
@Indexed
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    @Field(termVector = TermVector.YES)
	private String vorname;
	
	@Field(termVector = TermVector.YES)
	private String nachname;
	
	@Field(termVector = TermVector.YES)
	private String email;
	
    @Field(termVector = TermVector.YES)
	@Column(name="prog_sprache")
	private String  progSprache;
	
    @Field(termVector = TermVector.YES)
	@Column(name="geburts_datum")
	private String geburtsDatum;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public Student(String vorname, String nachname, String email, String progSprache, String geburtsDatum) {
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.progSprache = progSprache;
		this.geburtsDatum = geburtsDatum;
	}

	public Student(Integer id, String vorname, String nachname, String email, String progSprache, String geburtsDatum) {
		
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.progSprache = progSprache;
		this.geburtsDatum = geburtsDatum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgSprache() {
		return progSprache;
	}

	public void setProgSprache(String progSprache) {
		this.progSprache = progSprache;
	}

	public String getGeburtsDatum() {
		return geburtsDatum;
	}

	public void setGeburtsDatum(String geburtsDatum) {
		this.geburtsDatum = geburtsDatum;
	}
	
	

}
