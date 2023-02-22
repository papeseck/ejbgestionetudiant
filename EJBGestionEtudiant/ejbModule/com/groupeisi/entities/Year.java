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
@Table(name="year")
public class Year implements Serializable {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name= "name", length = 30)
	  private String name;
	  
	  @OneToMany(mappedBy="year")
	  List<Inscription> inscriptions = new ArrayList<Inscription>();

	  public Year() {
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

	  public List<Inscription> getInscriptions() {
	    return inscriptions;
	  }

	  public void setInscriptions(List<Inscription> inscriptions) {
	    this.inscriptions = inscriptions;
	  }

	  @Override
	  public String toString() {
	    return "Year [id=" + id + ", name=" + name + ", inscriptions=" + inscriptions + "]";
	  }

}
