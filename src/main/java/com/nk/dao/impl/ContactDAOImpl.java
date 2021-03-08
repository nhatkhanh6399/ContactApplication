package com.nk.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nk.dao.ContactDAO;
import com.nk.dto.ContactDTO;
import com.nk.jdbc.JDBC;

public class ContactDAOImpl implements ContactDAO {

	JDBC database;
	
	public ContactDAOImpl() {
		database = new JDBC();
	}
	
	@Override
	public List<ContactDTO> getAllContacts() throws SQLException {
		try {
			List<ContactDTO> listContact = new ArrayList<ContactDTO>();
			database.connect();
			String sql = "SELECT * FROM Employees";
			PreparedStatement statement = database.jdbcConnection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("Id");
				String firstName = resultSet.getString("FirstName");
				String lastName = resultSet.getString("LastName");
				Date birthdate = resultSet.getDate("Birthday");
				boolean sex = resultSet.getBoolean("Sex");
				String phoneNumber = resultSet.getString("Phone");
				String description = resultSet.getNString("About");
				ContactDTO contact = new ContactDTO(id, firstName, lastName, birthdate, sex, phoneNumber, description);
				listContact.add(contact);
			}
			resultSet.close();
			statement.close();
			return listContact;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addNewContact(ContactDTO newContact) throws SQLException {
		database.connect();
		String sql = "INSERT INTO Employees(FirstName, LastName, Birthday, Sex, Phone, About) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = database.jdbcConnection.prepareStatement(sql);
		statement.setString(1, newContact.getFirstName());
		statement.setString(2, newContact.getLastName());
		statement.setDate(3, newContact.getBirthdate());
		statement.setBoolean(4, newContact.isSex());
		statement.setString(5, newContact.getPhoneNumber());
		statement.setString(6, newContact.getDescription());
		
		if(statement.executeUpdate() > 0) return true;
		statement.close();
		return false;
	}

	@Override
	public boolean updateContact(ContactDTO contact) throws SQLException {
		database.connect();
		String sql = "UPDATE Employees SET FirstName = ?, LastName = ?, Birthday = ?, Sex = ?, Phone = ?, About = ? WHERE ID = ?";
		PreparedStatement statement = database.jdbcConnection.prepareStatement(sql);
		statement.setString(1, contact.getFirstName());
		statement.setString(2, contact.getLastName());
		statement.setDate(3, contact.getBirthdate());
		statement.setBoolean(4, contact.isSex());
		statement.setString(5, contact.getPhoneNumber());
		statement.setString(6, contact.getDescription());
		statement.setInt(7, contact.getId());
		
		if(statement.executeUpdate() > 0) return true;
		statement.close();
		return false;
	}

	@Override
	public boolean deleteContact(int id) throws SQLException {
		database.connect();
		String sql = "DELETE FROM Employees WHERE ID = ?";
		PreparedStatement statement = database.jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		if(statement.executeUpdate() > 0) return true;
		statement.close();
		return false;
	}

	@Override
	public ContactDTO getContactById(int id) throws SQLException {
		ContactDTO contact = null;
		database.connect();
		String sql = "SELECT * FROM Employees WHERE ID = ?";
		PreparedStatement statement = database.jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			String firstName = resultSet.getString("FirstName");
			String lastName = resultSet.getString("LastName");
			Date birthdate = resultSet.getDate("Birthday");
			boolean sex = resultSet.getBoolean("Sex");
			String phoneNumber = resultSet.getString("Phone");
			String description = resultSet.getNString("About");
			contact = new ContactDTO(id, firstName, lastName, birthdate, sex, phoneNumber, description);
		}
		resultSet.close();
		statement.close();
		return contact;
	}
	
	public static void main(String[] args) throws SQLException {
//		ContactDAOImpl dao = new ContactDAOImpl();
//		String str="1999-06-22";  
//		Date date=Date.valueOf(str);;
//		
//		ContactDTO add = new ContactDTO(8, "Elizabeth", "Taylor", date, false, "0112223366", "Hi");
//		dao.updateContact(add);
//		dao.addNewContact(add);
//		List<ContactDTO> list = dao.getAllContacts();
//		for(ContactDTO o: list) {
//			System.out.println(o.getFirstName() + "  ||  " + o.getLastName() + " || " + o.getDescription() + " || " + o.isSex());
//		}
		
//		ContactDTO test = dao.getContactById(2);
//		System.out.println(test);
		
	}
	
}
