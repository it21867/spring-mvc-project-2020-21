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

import gr.hua.dit.ds.project.dao.TeacherDAO;
import gr.hua.dit.ds.project.entity.Teacher;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherDAO teacherDAO;
	
	@RequestMapping("/list")
	public String listTeachers(Model model) {
		List<Teacher> teachers=teacherDAO.getTeachers();
		model.addAttribute("teachers", teachers);
		return "teacher-list";
	}
	
	@RequestMapping("/teacher/{teacherId}")
	public String getTeacher(@PathVariable int id,Model model) {
		Teacher teacher=teacherDAO.getTeacher(id);
		if(teacher==null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "teacher not found");   
		}
		model.addAttribute("teacher", teacher);
		return "teacher";
	}
	
	@RequestMapping("/saveTeacher")
	public String addTeacher(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,@RequestParam String course,Model model) {
		Teacher newTeacher=new Teacher();
		newTeacher.setFirstname(firstname);
		newTeacher.setLastname(lastname);
		newTeacher.setEmail(email);
		newTeacher.setCourse(course);
		teacherDAO.saveTeacher(newTeacher);
		
		model.addAttribute("teacher",newTeacher);
		return  "redirect:/teachers/list";
	}
	
	@RequestMapping("/updateTeacher/{teacherId}")
	public String updateTeacher(@PathVariable int id,@PathVariable String firstname,@PathVariable String lastname,@PathVariable String email,@PathVariable String course,Model model) {
		Teacher teacher=teacherDAO.getTeacher(id);
		if(teacher==null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "teacher not found");   
		}
		teacher.setFirstname(firstname);
		teacher.setLastname(lastname);
		teacher.setEmail(email);
		teacher.setCourse(course);
		teacherDAO.saveTeacher(teacher);
		
		model.addAttribute("teacher",teacher);
		return "redirect:/teachers/list";
	}
	
	@RequestMapping("/deleteTeacher/{teacherId}")
	public String deleteTeacher(@PathVariable int id) {
		Teacher teacher=teacherDAO.getTeacher(id);
		if(teacher==null) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "teacher not found");   
		}
		teacherDAO.deleteTeacher(id);
		return "redirect:/teachers/list";
	}
	


}
