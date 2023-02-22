package com.groupeisi.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Student;


@Stateless
public class StudentDao implements IStudent {
	 @PersistenceContext(unitName = "EJBGestionEtudiant")
	
	  private EntityManager em;
	  @Override
	  public Student addStuden(Student s) {
	    try {
	      //em.getTransaction().begin();
	      em.persist(s);
	      //em.getTransaction().commit();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return s;
	  }

	  @Override
	  public Student getStudentByID(int id) {
	    return em.find(Student.class, id);
	  }

	  @Override
	  public Student updateStudent(Student s) {
	    try {
	      //em.getTransaction().begin();
	      em.merge(s);
	      //em.getTransaction().commit();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return s;
	  }

	  @Override
	  public int removeStudent(int id) {
	    int ok = 0;
	    try {
	      //em.getTransaction().begin();
	      Student s = em.find(Student.class, id);
	      em.remove(s);
	      //em.getTransaction().commit();
	      ok = 1;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return ok;
	  }

	  @SuppressWarnings("unchecked")
	  @Override
	  public List<Student> getAllStudents() {
	    
	    return em.createQuery("SELECT s FROM Student s order by s.id").getResultList();
	  }

}


