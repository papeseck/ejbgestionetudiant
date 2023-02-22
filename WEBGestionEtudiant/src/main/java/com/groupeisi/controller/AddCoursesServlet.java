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
import com.groupeisi.entities.Courses;






@WebServlet("/courses/add")
public class AddCoursesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICours coursesmetier;
       
    public AddCoursesServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/courses/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String program = request.getParameter("program");
		
		Courses c = new Courses();
		c.setName(name);
		c.setPrograms(program);
		coursesmetier.addCourses(c);
		response.sendRedirect(request.getContextPath()+"/courses/list");
	}

}

