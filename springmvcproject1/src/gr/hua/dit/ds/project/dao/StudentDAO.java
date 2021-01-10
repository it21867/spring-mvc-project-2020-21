package gr.hua.dit.ds.project.dao;

import java.util.List;

import gr.hua.dit.ds.project.entity.Student;

public interface StudentDAO {
	
	public Student getStudent(int id);
	
	public List<Student> getStudents();
	
	public void saveStudent(Student s);
	
	public void deleteStudent(int id);
	
	public void updateStudent(Student s);

}
