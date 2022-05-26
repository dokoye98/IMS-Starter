package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {



	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemdao;
	private Utils utils;

	//Constructor using itemdao and utils

	public ItemController(ItemDAO itemdao, Utils utils) {
		super();
		this.itemdao = itemdao;
		this.utils = utils;
	}


	@Override
	public List<Item> readAll() {
		List<Item> items = itemdao.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter your items price");
		double cost = utils.getDouble();
		LOGGER.info("Please enter your items name");
		String name = utils.getString();
		Item items = itemdao.create(new Item(cost, name));
		LOGGER.info("Item request found");
		return items;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the new price");
		double cost = utils.getDouble();
		LOGGER.info("Please enter the new name");
		String name = utils.getString();
		Item items = itemdao.update(new Item(id, cost,name ));
		LOGGER.info("Item Updated");
		return items;
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
		return customerDAO.delete(id);
	}





}
