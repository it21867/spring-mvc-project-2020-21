package gr.hua.dit.ds.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.ds.project.dao.TeacherDAO;
import gr.hua.dit.ds.project.entity.Teacher;

@RestController
@RequestMapping("/api")
public class TeacherRestContoller {
	@Autowired
	private TeacherDAO teacherDAO;
	
	@GetMapping("/teachers")
	public List<Teacher> getTeachers(){
		List<Teacher> teachers=teacherDAO.getTeachers();
		return teachers;
	}
	
	@GetMapping("/teachers/{teacherId}")
	public Teacher getTeacher(@PathVariable int id) {
		Teacher teacher=teacherDAO.getTeacher(id);
		return teacher;
	}
	
	@PostMapping("/teachers")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		teacher.setId(0);
		teacherDAO.saveTeacher(teacher);
		return teacher;
	}
	
	@DeleteMapping("/teachers/{teacherId}")
	public String deleteStudent(@PathVariable int id) {
		Teacher theTeacher=teacherDAO.getTeacher(id);
		if(theTeacher==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "teacher not found");   
		}
		teacherDAO.deleteTeacher(id);
		return "Deleted teacher with id "+id;
	}
	
	public Teacher updateTeachert(@RequestBody Teacher teacher) {
		teacherDAO.updateTeacher(teacher);
		return teacher;
		
	}
	
	

}
