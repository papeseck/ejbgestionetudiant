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
@Table(name="student")
public class Student implements Serializable {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name= "firstname", length = 30)
	  private String firstname;
	  
	  @Column(name= "lastname", length = 30)
	  private String lastname;
	  
	  @Column(name= "birthday", length = 30)
	  private String birthday;
	  
	  @Column(name= "phone", length = 13)
	  private String phone;
	  
	  @OneToMany(mappedBy="student")
	  List<Inscription> inscriptions = new ArrayList<Inscription>();

	  public Student() {
	    super();
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getFirstname() {
	    return firstname;
	  }

	  public void setFirstname(String firstname) {
	    this.firstname = firstname;
	  }

	  public String getLastname() {
	    return lastname;
	  }

	  public void setLastname(String lastname) {
	    this.lastname = lastname;
	  }

	  public String getBirthday() {
	    return birthday;
	  }

	  public void setBirthday(String birthday) {
	    this.birthday = birthday;
	  }

	  public String getPhone() {
	    return phone;
	  }

	  public void setPhone(String phone) {
	    this.phone = phone;
	  }

	  public List<Inscription> getInscriptions() {
	    return inscriptions;
	  }

	  public void setInscriptions(List<Inscription> inscriptions) {
	    this.inscriptions = inscriptions;
	  }

	  @Override
	  public String toString() {
	    return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthday=" + birthday
	        + ", phone=" + phone + ", inscriptions=" + inscriptions + "]";
	  }
}
