package gr.hua.dit.ds.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.ds.project.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	
	@Autowired
	private SessionFactory sessionfactory; 
	
	@Override
	@Transactional
	public Student getStudent(int id) {
		Session currentSession =sessionfactory.getCurrentSession();
		Query<Student>query = currentSession.createQuery("from student Where id="+id,Student.class);
		Student student=query.getSingleResult();
		return student;
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		Session currentSession =sessionfactory.getCurrentSession();
		Query<Student>query = currentSession.createQuery("from student", Student.class);
		List<Student> students=query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student s) {
		Session currentSession =sessionfactory.getCurrentSession();
		 currentSession.save(s);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		Session currentSession =sessionfactory.getCurrentSession();
		Student s=getStudent(id);
		currentSession.delete(s);
	}

	@Override
	@Transactional
	public void updateStudent(Student s) {
		Session currentSession =sessionfactory.getCurrentSession();
		currentSession.update(s);
		

	}

}
