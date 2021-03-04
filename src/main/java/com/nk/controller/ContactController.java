package com.nk.controller;

import java.io.IOException;
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
		try {
			this.getListContact(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		for(ContactDTO o: listEmp) {
			if(o.isSex() == true)
				System.out.println("Male");
			else {
				System.out.println("Female");
			}
		}
		request.setAttribute("listContact", listEmp);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
