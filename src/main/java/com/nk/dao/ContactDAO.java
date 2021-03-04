package com.nk.dao;

import java.sql.SQLException;
import java.util.List;

import com.nk.dto.ContactDTO;

public interface ContactDAO {
	List<ContactDTO> getAllContacts() throws SQLException;
	boolean addNewContact(ContactDTO newContact) throws SQLException;
	boolean updateContact(ContactDTO contact) throws SQLException;
	boolean deleteContact(ContactDTO contact) throws SQLException;
	ContactDTO getContactById(int id) throws SQLException;
	
}
