package com.groupeisi.dao;
import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Courses;



@Local
public interface ICours {
	public Courses addCourses(Courses c);
	public Courses getCoursesByID(int id);
	public Courses updateCourses(Courses c);
	public int removeCourses(int id);
	public List<Courses> getAllCourses();
}
