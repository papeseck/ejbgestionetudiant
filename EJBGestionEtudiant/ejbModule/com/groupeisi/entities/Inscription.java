package com.groupeisi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="inscription")
public class Inscription implements Serializable {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name= "details", length = 80)
	  private String details;
	  
	  @ManyToOne
	  @JoinColumn(name="student_id")
	  private Student student;
	  
	  @ManyToOne
	  @JoinColumn(name="courses_id")
	  private Courses course;
	  
	  @ManyToOne
	  @JoinColumn(name="year_id")
	  private Year year;

	  public Inscription() {
	    super();
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getDetails() {
	    return details;
	  }

	  public void setDetails(String details) {
	    this.details = details;
	  }
	  
	  public Student getStudent() {
	    return student;
	  }

	  public void setStudent(Student student) {
	    this.student = student;
	  }
	  
	  public Year getYear() {
	    return year;
	  }

	  public void setYear(Year year) {
	    this.year = year;
	  }

	  public Courses getCourse() {
	    return course;
	  }

	  public void setCourse(Courses course) {
	    this.course = course;
	  }

	  @Override
	  public String toString() {
	    return "Inscription [id=" + id + ", details=" + details + ", student=" + student + ", course=" + course
	        + ", year=" + year + "]";
	  }


}
