package com.groupeisi.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Inscription;


@Stateless
public class InscriptionDao implements IIsnscription {
	@PersistenceContext(unitName = "EJBGestionEtudiant")
	  private EntityManager em;

	@Override
	  public Inscription addInscription(Inscription i) {
	    try {
	      //em.getTransaction().begin();
	      em.persist(i);
	      //em.getTransaction().commit();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return i;
	  }

	@Override
	  public Inscription getInscriptionByID(int id) {
	    return em.find(Inscription.class, id);
	  }

	@Override
	  public Inscription updateInscription(Inscription i) {
	    try {
	      //em.getTransaction().begin();
	      em.merge(i);
	      //em.getTransaction().commit();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return i;
	  }

	@Override
	  public int removeInscription(int id) {
	    int ok = 0;
	    try {
	      //em.getTransaction().begin();
	      Inscription i = em.find(Inscription.class, id);
	      em.remove(i);
	      //em.getTransaction().commit();
	      ok = 1;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return ok;
	  }

	@Override
	  public List<Inscription> getAllInscriptions() {
	    
	    @SuppressWarnings("unchecked")
	    List<Inscription> listesInscriptions = em.createQuery("SELECT i FROM Inscription i").getResultList();
	    return listesInscriptions;
	  }
}

