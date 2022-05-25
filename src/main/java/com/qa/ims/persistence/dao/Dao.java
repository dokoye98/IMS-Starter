package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

public interface Dao<T> {

	
	


	

	Item readLatestitem(long id);

	int deleteItem(long id);

	Item updateitem(Item item);

	List<Item> readallitem();

	Item modelitems(ResultSet resultSet) throws SQLException;
	
	//specifying the class has stopped the errors 
	Customer readLatest();
Customer modelCustomer(ResultSet resultSet) throws SQLException;
	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	List<Customer> readAll();

	Customer readallCustomer(Long id);

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	Customer create(Customer customer);

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	int delete(long id);

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	Customer createCustomer(Customer customer);

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	Customer updateCustomer(Customer customer);
}
