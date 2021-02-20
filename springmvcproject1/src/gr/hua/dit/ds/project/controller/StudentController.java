package gr.hua.dit.ds.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.ds.project.dao.StudentDAO;
import gr.hua.dit.ds.project.entity.Student;
import gr.hua.dit.ds.project.entity.Teacher;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students=studentDAO.getStudents();
		model.addAttribute("students", students);
		return "list-students";
	}
	
	@RequestMapping("/student")
	public String getStudent(@RequestParam int id,Model model) {
		Student student=studentDAO.getStudent(id);
		if(student==null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");   
		}
		model.addAttribute("student", student);
		return "student";
	}
	
	@RequestMapping("/saveStudent")
	public String addStudent(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,@RequestParam int points,Model model ) {
		Student newStudent=new Student();
		newStudent.setFirstname(firstname);
		newStudent.setLastname(lastname);
		newStudent.setEmail(email);
		newStudent.setPoints(points);
		studentDAO.saveStudent(newStudent);
		
		model.addAttribute("student", newStudent);
		return "redirect:/students/list";
		
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,@RequestParam int points,Model model) {
		Student student=studentDAO.getStudent(id);
		if(student==null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");   
		}
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setEmail(email);
		student.setPoints(points);
		studentDAO.updateStudent(student);
		
		model.addAttribute("student",student);
		return "redirect:/students/list";	
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int id) {
		Student student=studentDAO.getStudent(id);
		if(student==null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");   
		}
		studentDAO.deleteStudent(id);
		return "redirect:/students/list";	
	}
	

}
