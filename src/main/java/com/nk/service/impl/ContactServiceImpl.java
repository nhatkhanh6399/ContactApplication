package com.nk.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.nk.dao.ContactDAO;
import com.nk.dao.impl.ContactDAOImpl;
import com.nk.dto.ContactDTO;
import com.nk.service.ContactService;

public class ContactServiceImpl implements ContactService {
	
	private ContactDAO contactDAO;
	
	public ContactServiceImpl() {
		this.contactDAO = new ContactDAOImpl();
	}
	@Override
	public List<ContactDTO> getAllContacts() throws SQLException {
		return this.contactDAO.getAllContacts();
	}

	@Override
	public boolean addNewContact(ContactDTO newContact) throws SQLException {
		return this.contactDAO.addNewContact(newContact);
	}

	@Override
	public boolean updateContact(ContactDTO contact) throws SQLException {
		return this.contactDAO.updateContact(contact);
	}

	@Override
	public boolean deleteContact(int id) throws SQLException {
		return this.contactDAO.deleteContact(id);
	}

	@Override
	public ContactDTO getContactById(int id) throws SQLException {
		return this.contactDAO.getContactById(id);
	}
	
	@Override
	public List<ContactDTO> findContact(String key) throws SQLException {
		return this.contactDAO.findContact(key);
	}
//	public static void main(String[] args) throws SQLException {
//		ContactServiceImpl cn = new ContactServiceImpl();
//		List<ContactDTO> list = cn.getAllContacts();
//		for(ContactDTO o: list) {
//			System.out.println(o.getFirstName() + "  ||  " + o.getLastName() + " || " + o.getDescription());
//		}
//	}

}
