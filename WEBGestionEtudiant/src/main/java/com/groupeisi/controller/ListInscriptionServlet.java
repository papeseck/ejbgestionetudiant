package com.groupeisi.controller;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.IIsnscription;





@WebServlet("/inscription/list")
public class ListInscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@EJB
	private IIsnscription inscriptionmetier;
	
    public ListInscriptionServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("inscriptions", inscriptionmetier.getAllInscriptions());
		request.getServletContext().getRequestDispatcher("/WEB-INF/views/inscription/list.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
