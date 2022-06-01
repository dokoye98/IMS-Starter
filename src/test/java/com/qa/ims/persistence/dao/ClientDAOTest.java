package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Client;
import com.qa.ims.utils.DBUtils;

public class ClientDAOTest {

	private final ClientDAO DAO = new ClientDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Client created = new Client(2L, "chris", "perrins","username","pass", false);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Client> expected = new ArrayList<>();
		expected.add(new Client(1L, "jordan", "harrison","username","password", false));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Client(1L, "jordan", "harrison","username","password", false), DAO.read());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Client(ID, "jordan", "harrison","username","password", false), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Client updated = new Client(1L, "chris", "perrins","username","pass", false);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
