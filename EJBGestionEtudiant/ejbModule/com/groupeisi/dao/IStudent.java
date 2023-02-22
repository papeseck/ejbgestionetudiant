package com.groupeisi.dao;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Student;



@Local
public interface IStudent {
	public Student addStuden(Student s);
	public Student getStudentByID(int id);
	public Student updateStudent(Student s);
	public int removeStudent(int id);
	public List<Student> getAllStudents();

}

