package gr.hua.dit.ds.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.ds.project.dao.StudentDAO;
import gr.hua.dit.ds.project.entity.Student;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List <Student> students=studentDAO.getStudents();
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int id){
		Student student=studentDAO.getStudent(id);
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		studentDAO.saveStudent(student);
		return student;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int id) {
		Student aStudent=studentDAO.getStudent(id);
		if(aStudent==null) {
		    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");   
		}
		studentDAO.deleteStudent(id);
		return "Deleted student with id "+id;	
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentDAO.updateStudent(student);
		return student;
	}
	
	

}
