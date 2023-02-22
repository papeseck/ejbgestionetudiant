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

@WebServlet("/year/list")
public class ListYearServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IYear yearmetier;

    public ListYearServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("years", yearmetier.getAllYears());
		request.getRequestDispatcher("/WEB-INF/views/year/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}

