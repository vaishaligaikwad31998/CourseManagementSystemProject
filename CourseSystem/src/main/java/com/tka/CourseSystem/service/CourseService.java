package com.tka.CourseSystem.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.CourseSystem.dao.CourseDao;
import com.tka.CourseSystem.entity.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDao dao;
	
	public String AddCourseData( Course c) {
	String msg=	dao.AddCourseData(c);
		return msg;
	}

	public String UpdateCourse(int id, Course c) {
		// TODO Auto-generated method stub
	String msg=	dao.UpdateCourse(id,c);
		return msg;
	}

	

	public String DeleteCourse(int id) {
		// TODO Auto-generated method stub
		String msg=	dao.DeleteCourse(id);
		return msg;
		
	}

	

	

	public List<Course> getAllData() {
		// TODO Auto-generated method stub
		List<Course> list=	dao.getAllData();
		return list;
	}

	
	

	public Course getperticularcourseById(int id) {
		 Course c=dao. getperticularcourseById(id);
			return c;
	}
	

}
