package com.groupeisi.dao;


import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Inscription;



@Local
public interface IIsnscription {
	public Inscription addInscription(Inscription i);
	public Inscription getInscriptionByID(int id);
	public Inscription updateInscription(Inscription i);
	public int removeInscription(int id);
	public List<Inscription> getAllInscriptions();

}
