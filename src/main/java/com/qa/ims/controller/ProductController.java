package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

public class ProductController implements CrudController<Product> {
	public static final Logger LOGGER = LogManager.getLogger();

	private ProductDAO proDAO;
	private Utils utils;

	// Constructor using productDAO and utils

	public ProductController(ProductDAO proDAO, Utils utils) {
		super();
		this.proDAO = proDAO;
		this.utils = utils;

	}
	@Override
	public List<Product> readAll() {
		List<Product> product = proDAO.readAll();
		for (Product pro : product) {
			LOGGER.info(pro);
		}
		return product;
	}


	

	// create product controller price and  addons can be added to database id is auto-increment 
	@Override
	public Product create() {
		LOGGER.info("Please enter your product price");
		double cost = utils.getDouble();
		LOGGER.info("Please enter your product addons");
		String addOns = utils.getString();
		Product product = proDAO.create(new Product(cost, addOns));
		LOGGER.info("Item request found");
		return product;
	}

//update product controller
	@Override
	public Product update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the new price");
		double cost = utils.getDouble();
		LOGGER.info("Please enter the new addOns");
		String addOns = utils.getString();
		Product product = proDAO.update(new Product(id, cost, addOns));
		LOGGER.info("Item Updated");
		return product;
	}

	// delete product controller
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long id = utils.getLong();
		return proDAO.delete(id);
	}



}


