package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.ClientController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.ProductController;
import com.qa.ims.persistence.dao.ClientDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final ClientController client;
	private final ItemController items;
	private final OrderController order;
	private final ProductController product;
	private final Utils utils;

	public IMS() {
		this.utils = new Utils();
		final ClientDAO custDAO = new ClientDAO();
		this.client = new ClientController(custDAO, utils);
		final OrderDAO orDAO = new OrderDAO();
		this.order = new OrderController(orDAO, utils);
		final ItemDAO itDAO = new ItemDAO();
		this.items = new ItemController(itDAO, utils);
		final ProductDAO proDAO = new ProductDAO();
		this.product = new ProductController(proDAO,utils);
	}

	public void imsSystem() {
		LOGGER.info("Welcome to the Inventory Management System!");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CLIENT:
				active = this.client;
				break;
			case ITEM:
				active = this.items;
				break;
			case ORDER:
				active = this.order;
				break;
			case PRODUCT:
				active = this.product;
				break;
			case STOP:
				return;
			default:
				break;
			}

			LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction(utils);

			if (action == Action.RETURN) {
				changeDomain = true;
			} else {
				doAction(active, action);
			}
		} while (!changeDomain);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}
