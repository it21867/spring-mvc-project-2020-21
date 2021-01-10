package gr.hua.dit.ds.project.dao;

import java.util.List;

import gr.hua.dit.ds.project.entity.Teacher;

public interface TeacherDAO {
	
	public Teacher getTeacher(int id);
	
	public List <Teacher> getTeachers();
	
	public void saveTeacher(Teacher t);
	
	public void deleteTeacher(int id);
	
	public void updateTeacher(Teacher teacher);
	
	

}
