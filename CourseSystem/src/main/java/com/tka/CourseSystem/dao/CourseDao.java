package com.tka.CourseSystem.dao;

import java.util.List;






import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.CourseSystem.entity.Course;

@Repository
public class CourseDao {

	@Autowired
	SessionFactory factory;
	public String AddCourseData(Course c) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.beginTransaction();
		//persist method is used to add data in database
		session.persist(c);
		session.getTransaction().commit();
		session.close();
		return "Data added successfully";
		
		
		
	}
	
	public String UpdateCourse(int id, Course c) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.beginTransaction();
		Course coursedata=session.get(Course.class, id);
	     coursedata.setDescription(c.getDescription());
	     coursedata.setDuration(c.getDuration());
	     session.merge(coursedata);
	     session.getTransaction().commit();
	     session.close();
		return "data is updated successfully";
	}

	public String DeleteCourse(int id) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.beginTransaction();
		Course c = session.get(Course.class, id);
		session.remove(c);
		session.getTransaction().commit();
	     session.close();
		return "Data deleted successfully";
	}

	

	public List<Course> getAllData() {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.beginTransaction();
		
		String hqlQuery="from Course";
		
		Query<Course> query=session.createQuery(hqlQuery,Course.class);
		
		List<Course> list=query.list();
		session.getTransaction().commit();
		session.close();
		
		
		return list;
		
	}

	public Course getperticularcourseById(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		Course c=session.get(Course.class, id);
		session.getTransaction().commit();
		session.close();
		return c;
	}

	
	

}
