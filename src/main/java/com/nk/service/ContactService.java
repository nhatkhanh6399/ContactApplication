package com.nk.service;

import java.sql.SQLException;
import java.util.List;

import com.nk.dto.ContactDTO;

public interface ContactService {
	List<ContactDTO> getAllContacts() throws SQLException;
	boolean addNewContact(ContactDTO newContact) throws SQLException;
	boolean updateContact(ContactDTO contact) throws SQLException;
	boolean deleteContact(int id) throws SQLException;
	ContactDTO getContactById(int id) throws SQLException;
	List<ContactDTO> findContact(String key) throws SQLException;
}
