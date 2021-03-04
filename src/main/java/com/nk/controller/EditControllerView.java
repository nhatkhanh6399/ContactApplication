package com.nk.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nk.dto.ContactDTO;
import com.nk.service.ContactService;
import com.nk.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class EditControllerView
 */
@WebServlet("/EditControllerView")
public class EditControllerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ContactService contactService = new ContactServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditControllerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			ContactDTO existingContact = this.contactService.getContactById(id);
			request.setAttribute("contact", existingContact);
			RequestDispatcher rd = request.getRequestDispatcher("editContact.jsp");
			rd.forward(request, response);
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
