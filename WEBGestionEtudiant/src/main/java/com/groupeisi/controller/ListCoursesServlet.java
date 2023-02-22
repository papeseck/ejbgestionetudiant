package com.groupeisi.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.ICours;
import com.groupeisi.entities.Courses;




@WebServlet("/courses/list")
public class ListCoursesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ICours coursesmetier;
	
    public ListCoursesServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Courses> courses = coursesmetier.getAllCourses();
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/WEB-INF/views/courses/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}

