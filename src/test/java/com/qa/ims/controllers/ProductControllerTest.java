package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.qa.ims.controller.ProductController;

import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	

	@Mock
	private Utils utils;

	@Mock
	private ProductDAO dao;

	@InjectMocks
	private ProductController controller;
//test create for product 
	@Test
	public void testCreate() {
		
		final double cost = 12.5;
		final String addOns = "wifi";
		
		Product created = new Product(cost, addOns);
	Mockito.when(utils.getDouble()).thenReturn(cost);
	Mockito.when(utils.getString()).thenReturn(addOns);
	Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());
		//these test how many times that data type was used in the above code
		Mockito.verify(utils,Mockito.times(1)).getDouble();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Product> product = new ArrayList<>();
		product.add(new Product(12.5, "wifi"));

		Mockito.when(dao.readAll()).thenReturn(product);

		assertEquals(product, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Product updated = new Product(1l,12.5, "wifi");

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getProductId());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
		Mockito.when(this.utils.getString()).thenReturn(updated.getAddOns());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

	Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils,Mockito.times(1)).getDouble();
	Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 12L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}


	


}
