package gr.hua.dit.ds.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/studentsearchForm")
	public String showStudentsearchForm() {
		return "studentsearchform";
	}
	
	@RequestMapping("/studentaddForm")
	public String showStudentaddForm() {
		return "studentaddform";
	}
	
	@RequestMapping("/studentupdateForm")
	public String showStudentupdateForm() {
		return "studentupdateform";
	}
	
	@RequestMapping("/studentdeleteForm")
	public String showdeleteForm() {
		return "studentdeleteform"; 
	}
	
	@RequestMapping("/teachersearchForm")
	public String showTeachersearchForm() {
		return "teachersearchform";
	}
	
	@RequestMapping("/teacheraddForm")
	public String showTeacheraddForm() {
		return "teacheraddform";
	}
	
	@RequestMapping("/teacherupdateForm")
	public String showTeacherupdateForm() {
		return "teacherupdateform";
	}
	
	@RequestMapping("/teacherdeleteForm")
	public String showTeacherdeleteForm() {
		return "teacherdeleteform";
	}

}
