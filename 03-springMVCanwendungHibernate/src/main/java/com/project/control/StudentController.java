package com.project.control;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.DocumentException;
import com.project.dao.StudentRepository;
import com.project.entity.PdfExport;
import com.project.entity.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository repository;
	
	@RequestMapping("/")
	public String indexPage() {
		return "home";
	}
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	@RequestMapping("/studentform")
	public String studentForm(Model model) {
		model.addAttribute("studentmodel", new Student());
		List<String>list1=Arrays.asList("Java","JavaFX","Spring Boot","Spring MVC","Angular 10","Javascript",
				"jQuery","JSP","JSF","Thymeleaf");
		model.addAttribute("proglist", list1);
		return "student-form";
	}
	
	@RequestMapping("/studentSave")
	public String studentSave(@ModelAttribute("studentmodel")Student student) {
		if(student.getId()!=null) {
			this.repository.studentUpdate(student);
		}else {
			this.repository.studentSave(student);
		}
		return "redirect:/studentlist";
	}
	
	@RequestMapping("studentlist")
	public String studentList(Model model) {
		List<Student> list=this.repository.studentList();
		model.addAttribute("studentlist1", list);
		return "student-list";
	}
	
	@RequestMapping("/delete")
	public String studentDelete(@RequestParam("id") Integer id) {
     this.repository.studentDelete(id);
     return "redirect:/studentlist";
	}
	
	@RequestMapping("/update")
	public String studentUpdate(@RequestParam("id") Integer id,Model model) {
        Student student=this.repository.studentFindById(id);
        model.addAttribute("studentmodel", student);
        List<String>list1=Arrays.asList("Java","JavaFX","Spring Boot","Spring MVC","Angular 10","Javascript",
				"jQuery","JSP","JSF","Thymeleaf");
		model.addAttribute("proglist", list1);
     return "student-form";
	}
	
	@RequestMapping("/studentsearch")
	public String studentSearch(@RequestParam("keyword")String keyword,Model model) throws InterruptedException {
		List<Student>list4=this.repository.studentSearch(keyword);
		model.addAttribute("searchlist", list4);
		return "student-search";
		
	}
	
	@RequestMapping("/exportpdf")
	public void exportPDF(HttpServletResponse response) throws DocumentException, IOException {
		
        response.setContentType("application/pdf");
		
		//DateFormat format=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		//String currentDate=format.format(new Date());
		
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename=student_"+".pdf";
		response.setHeader(headerKey, headerValue);
		
		List<Student> list5=this.repository.studentList();
		PdfExport export=new PdfExport(list5);
		export.exportData(response);
		
	}
}
