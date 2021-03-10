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
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactService contactService = new ContactServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			String fName = request.getParameter("firstName");
			String lName = request.getParameter("lastName");
			Date date = Date.valueOf(request.getParameter("birthDate"));
			String sex = request.getParameter("sex");
			int gen = 0;
			if(sex == "Male")
				gen = 1;
			String phoneNumber = request.getParameter("phoneNumber");
			String des = request.getParameter("description");
			ContactDTO contact = new ContactDTO(id, fName, lName, date, gen, phoneNumber, des);
			this.contactService.updateContact(contact);
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
