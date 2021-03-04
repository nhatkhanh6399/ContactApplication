package com.nk.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nk.dto.ContactDTO;
import com.nk.service.ContactService;
import com.nk.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ContactService contactService = new ContactServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String fName = request.getParameter("firstName");
			String lName = request.getParameter("lastName");
			Date date = Date.valueOf(request.getParameter("birthDate"));
			String sex = request.getParameter("sex");
			boolean gen = false;
			if(sex == "Male")
				gen = true;
			String phoneNumber = request.getParameter("phoneNumber");
			String des = request.getParameter("description");
			ContactDTO newContact = new ContactDTO(fName, lName, date, gen, phoneNumber, des);
			
			this.contactService.addNewContact(newContact);
			response.sendRedirect("ContactController");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
