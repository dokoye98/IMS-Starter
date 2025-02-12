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

import com.qa.ims.controller.ClientController;
import com.qa.ims.persistence.dao.ClientDAO;
import com.qa.ims.persistence.domain.Client;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ClientDAO dao;

	@InjectMocks
	private ClientController controller;

	@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott", U_name = "username", pass = "pass";
		boolean mem=false;
		final Client created = new Client(F_NAME, L_NAME,U_name,pass, false);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME,U_name,pass);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(4)).getString();
		Mockito.verify(utils,Mockito.times(1)).getboolean();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Client> clients = new ArrayList<>();
		clients.add(new Client(1L, "jordan", "harrison","username","password", false));

		Mockito.when(dao.readAll()).thenReturn(clients);

		assertEquals(clients, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Client updated = new Client(1L, "chris", "perrins","username","pass", false);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getFirstName(), updated.getSurname(),updated.getUsername(),updated.getPassword());
		Mockito.when(this.utils.getboolean()).thenReturn(updated.isDeluxeMember());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(4)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getboolean();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
