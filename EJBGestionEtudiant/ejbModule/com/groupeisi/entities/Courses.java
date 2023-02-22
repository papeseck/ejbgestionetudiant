package com.groupeisi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="courses")
public class Courses implements Serializable {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name= "name", length = 30)
	  private String name;
	  
	  @Column(name= "programs", length = 30)
	  private String programs;
	  
	  @OneToMany(mappedBy="course")
	  List<Inscription> inscriptions = new ArrayList<Inscription>();

	  public Courses() {
	    super();
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getPrograms() {
	    return programs;
	  }

	  public void setPrograms(String programs) {
	    this.programs = programs;
	  }

	  public List<Inscription> getInscriptions() {
	    return inscriptions;
	  }

	  public void setInscriptions(List<Inscription> inscriptions) {
	    this.inscriptions = inscriptions;
	  }
	  
	  @Override
	  public String toString() {
	    return "Courses [id=" + id + ", name=" + name + ", programs=" + programs + ", inscriptions=" + inscriptions
	        + "]";
	  }

}
