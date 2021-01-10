package gr.hua.dit.ds.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.ds.project.entity.Teacher;


@Repository
public class TeacherDAOImpl implements TeacherDAO {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	@Transactional
	public Teacher getTeacher(int id) {
		Session currentSession =sessionfactory.getCurrentSession();
		Query<Teacher>query = currentSession.createQuery("from teacher Where id="+id,Teacher.class);
		Teacher teacher=query.getSingleResult();
		return teacher;
	}

	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		Session currentSession =sessionfactory.getCurrentSession();
		Query<Teacher>query = currentSession.createQuery("from teacher", Teacher.class);
		List<Teacher> teachers=query.getResultList();
		return teachers;
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher t) {
		Session currentSession =sessionfactory.getCurrentSession();
		currentSession.save(t);
	}

	@Override
	@Transactional
	public void deleteTeacher(int id) {
		Session currentSession =sessionfactory.getCurrentSession();
		Teacher t=getTeacher(id);
		currentSession.delete(t);

	}

	@Override
	@Transactional
	public void updateTeacher(Teacher t) {
		Session currentSession =sessionfactory.getCurrentSession();
		currentSession.update(t);
		

	}

}
