package com.qa.ims.persistence.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.CrudController;
import com.qa.ims.persistence.domain.Item;
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

	

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderdao.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	//create item controller
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer_id");
		long customer_id = utils.getLong();
		Order order = orderdao.create(new Order(customer_id));
		LOGGER.info("Item request found");
		return order;
	}

//update item controller
	@Override
	public Order update() {
		LOGGER.info("Please enter the order_id of the item you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter the new price");
		Long customer_id = utils.getLong();
		Order order = orderdao.update(new Order(order_id,customer_id ));
		LOGGER.info("Order Updated");
		return order;
	}

	//delete item controller
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return orderdao.delete(id);
	}

	
}
