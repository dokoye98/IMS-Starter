package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Client;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ClientDAO implements Dao<Client>,ClientInterface {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Client modelClient(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstName = resultSet.getString("firstname");
		String surname = resultSet.getString("surname");
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		boolean deluxeMember = resultSet.getBoolean("membership");
		return new Client(id, firstName, surname,username,password,deluxeMember);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Client> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");) {
			List<Client> clients = new ArrayList<>();
			while (resultSet.next()) {
				clients.add(modelClient(resultSet));
			}
			return clients;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
	public Client read() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelClient(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a client in the database
	 * 
	 * @param client - takes in a customer object. id will be ignored
	 */
	@Override
	public Client create(Client client) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement Stmt = connection
						.prepareStatement("INSERT INTO customers(firstname, surname,username,password,membership) VALUES (?, ?,?,?,?)");) {
			Stmt.setString(1, client.getFirstName());
			Stmt.setString(2, client.getSurname());
			Stmt.setString(3, client.getUsername());
			Stmt.setString(4, client.getPassword());
			Stmt.setBoolean(5, client.isDeluxeMember());
			Stmt.executeUpdate();
			return read();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
@Override
	public Client read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelClient(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param client - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
//edited query 
@Override
	public Client update(Client client) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE customers SET firstname = ?, surname = ? , username =?, password =?, membership = ? WHERE id = ?");) {
			statement.setString(1, client.getFirstName());
			statement.setString(2, client.getSurname());
			statement.setString(3, client.getUsername());
			statement.setString(4, client.getPassword());
			statement.setBoolean(5, client.isDeluxeMember());
			statement.setLong(6, client.getId());
			statement.executeUpdate();
			return read(client.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	}


	

