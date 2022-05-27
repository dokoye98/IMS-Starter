package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderdao;
	private Utils utils;

	

	public OrderController(OrderDAO orderdao, Utils utils) {
		super();
		this.orderdao = orderdao;
		this.utils = utils;
	}


	

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderdao.readAll();
		for (Order order : orders) {
			LOGGER.info(orders);
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer_id");
		long customer_id = utils.getLong();
		Order order = orderdao.create(new Order(customer_id));
		LOGGER.info("Customer created");
		return order;
	}

	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a customer_id");
		long customer_id = utils.getLong();
		Order order = orderdao.update(new Order(order_id,customer_id));
		LOGGER.info("Customer created");
		return order;
	}


	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return orderdao.delete(id);
	}

	
}
