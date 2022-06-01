package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ClientDAO;
import com.qa.ims.persistence.domain.Client;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class ClientController implements CrudController<Client> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ClientDAO clientDAO;
	private Utils utils;

	public ClientController(ClientDAO clientDAO, Utils utils) {
		super();
		this.clientDAO = clientDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Client> readAll() {
		List<Client> clients = clientDAO.readAll();
		for (Client client : clients) {
			LOGGER.info(client);
		}
		return clients;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Client create() {
		LOGGER.info("Please enter a first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = utils.getString();
		LOGGER.info("Please enter a username");
		String username = utils.getString();
		LOGGER.info("Please enter a password");
		String password = utils.getString();
		LOGGER.info("are you a member");
		boolean membership = utils.getboolean();
		Client client = clientDAO.create(new Client(firstName, surname,username,password,membership));
		LOGGER.info("Customer created");
		return client;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Client update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = utils.getString();
		LOGGER.info("Please enter a  username");
		String username = utils.getString();
		LOGGER.info("Please enter a password");
		String password = utils.getString();
		LOGGER.info("are you a member");
		boolean membership = utils.getboolean();
		Client client = clientDAO.create(new Client(firstName, surname,username,password,membership));
		LOGGER.info("Customer Updated");
		return client;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return clientDAO.delete(id);
	}

}
