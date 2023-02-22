package com.groupeisi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.IYear;
import com.groupeisi.entities.Year;



@WebServlet("/year/add")
public class AddYearServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IYear yearmetier;

    public AddYearServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/year/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		Year y = new Year();
		y.setName(name);
		
		yearmetier.addYear(y);
		
		request.getRequestDispatcher("/WEB-INF/views/year/list.jsp").forward(request, response);
	}


}

