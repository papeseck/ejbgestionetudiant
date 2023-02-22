package com.groupeisi.controller;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.ICours;
import com.groupeisi.dao.IIsnscription;
import com.groupeisi.dao.IStudent;
import com.groupeisi.dao.IYear;
import com.groupeisi.entities.Student;




/**
 * Servlet implementation class AddInscrriptionServlet
 */
@WebServlet("/inscription/add")
public class AddInscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IIsnscription inscriptionmetier;
	
	@EJB
	private IStudent studentmetier;
	
	@EJB
	private ICours coursesmetier;
	
	@EJB
	private IYear yearmetier;

    public AddInscriptionServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("students", studentmetier.getAllStudents());
		request.setAttribute("courses", coursesmetier.getAllCourses());
		request.setAttribute("years", yearmetier.getAllYears());
		
		request.getRequestDispatcher("/WEB-INF/views/inscription/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		
		Student s = new Student();
		s.setFirstname(firstname);
		s.setLastname(lastname);
		s.setBirthday(birthday);
		s.setPhone(phone);
		
		studentmetier.addStuden(s);
		
		
		response.sendRedirect(request.getContextPath()+"/student/list");
	}


}
