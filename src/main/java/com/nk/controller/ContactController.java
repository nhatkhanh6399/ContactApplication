package com.nk.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nk.dto.ContactDTO;
import com.nk.service.ContactService;
import com.nk.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class ContactController
 */
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContactService contactService = new ContactServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		
		try {
			switch (action) {
			case "new":
				RequestDispatcher rd = request.getRequestDispatcher("newContact.jsp");
				rd.forward(request, response);
				break;
			case "insert":
				this.addContact(request, response);
				break;
			case "update":
				this.updateContact(request, response);
				break;
			case "delete":
				this.deleteContact(request, response);
				break;
			case "getInfo":
				this.getInfo(request, response);
				break;
			default:
				this.getListContact(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	private void getListContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<ContactDTO> listEmp = contactService.getAllContacts();
		String key = request.getParameter("txtSearch");
		if(key != null)
			listEmp = contactService.findContact(key);
		request.setAttribute("listContact", listEmp);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
	
	private void addContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		Date date = Date.valueOf(request.getParameter("birthDate"));
		int check = 0;
		String gender = request.getParameter("gender");
		if (gender.equalsIgnoreCase("male")) {
			check = 1;
		} else if(gender.equalsIgnoreCase("baloon")) {
			check = 2;
		}
		String phoneNumber = request.getParameter("phoneNumber");
		String des = request.getParameter("description");
		ContactDTO newContact = new ContactDTO(fName, lName, date, check, phoneNumber, des);
		this.contactService.addNewContact(newContact);
		response.sendRedirect("contact");
	}
	
	private void updateContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		Date date = Date.valueOf(request.getParameter("birthDate"));
		int check = 0;
		String gender = request.getParameter("gender");
		if (gender.equalsIgnoreCase("male")) {
			check = 1;
		} else if(gender.equalsIgnoreCase("baloon")) {
			check = 2;
		}
		String phoneNumber = request.getParameter("phoneNumber");
		String des = request.getParameter("description");
		System.out.println(des);
		ContactDTO contact = new ContactDTO(id, fName, lName, date, check, phoneNumber, des);
		this.contactService.updateContact(contact);
		response.sendRedirect("contact");
	}
	
	private void getInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ContactDTO existingContact = this.contactService.getContactById(id);
		request.setAttribute("contact", existingContact);
		RequestDispatcher rd = request.getRequestDispatcher("newContact.jsp");
		rd.forward(request, response);
	}
	
	private void deleteContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		this.contactService.deleteContact(id);
		response.sendRedirect("contact");
	}

}
