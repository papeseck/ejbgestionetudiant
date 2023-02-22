package com.groupeisi.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Year;


@Stateless
public class YearDao implements IYear {
	 @PersistenceContext(unitName = "EJBGestionEtudiant")
	  private EntityManager em;

	  @Override
	  public Year addYear(Year y) {
	    try {
	      //em.getTransaction().begin();
	      em.persist(y);
	      //em.getTransaction().commit();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return y;
	  }

	  @Override
	  public Year getYearByID(int id) {
	    return em.find(Year.class, id);
	  }

	  @Override
	  public Year updateYear(Year y) {
	    try {
	      //em.getTransaction().begin();
	      em.merge(y);
	      //em.getTransaction().commit();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return y;
	  }

	  @Override
	  public int removeYear(int id) {
	    int ok = 0;
	    try {
	      //em.getTransaction().begin();
	      Year y = em.find(Year.class, id);
	      em.remove(y);
	      //em.getTransaction().commit();
	      ok = 1;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return ok;
	  }

	  @SuppressWarnings("unchecked")
	  @Override
	  public List<Year> getAllYears() {
	    List<Year> listeYears = em.createQuery("select y from Year y").getResultList();
	    return listeYears;
	  }
}

