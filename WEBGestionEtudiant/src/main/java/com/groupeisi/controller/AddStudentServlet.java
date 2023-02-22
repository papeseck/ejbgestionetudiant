package com.groupeisi.controller;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.IStudent;
import com.groupeisi.entities.Student;




@WebServlet(value="/student/add", name="AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IStudent studentmetier;
       
    public AddStudentServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println(studentmetier.Salut());
		request.getRequestDispatcher("/WEB-INF/views/student/add.jsp").forward(request, response);
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