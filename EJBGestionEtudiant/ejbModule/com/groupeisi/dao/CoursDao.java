package com.groupeisi.dao;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Courses;


@Stateless
public class CoursDao implements ICours{

	@PersistenceContext(unitName = "EJBGestionEtudiant")
	private EntityManager em;

	@Override
	public Courses addCourses(Courses c) {
		try {
			//em.getTransaction().begin();
			em.persist(c);
			//em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Courses getCoursesByID(int id) {
		return em.find(Courses.class, id);
	}

	@Override
	public Courses updateCourses(Courses c) {
		try {
			//em.getTransaction().begin();
			em.merge(c);
			//em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int removeCourses(int id) {
		int ok = 0;
		try {
			//em.getTransaction().begin();
			Courses c = em.find(Courses.class, id);
			em.remove(c);
			//em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<Courses> getAllCourses() {
		@SuppressWarnings("unchecked")
		List<Courses> listesCourses = em.createQuery("SELECT c FROM Courses c").getResultList();
		
		return listesCourses;
	}
	
}

