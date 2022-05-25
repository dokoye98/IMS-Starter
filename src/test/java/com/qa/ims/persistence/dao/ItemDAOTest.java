package com.qa.ims.persistence.dao;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAOTest idao = new ItemDAOTest();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "chris", "perrins","username","pass");
		assertEquals(created, idao.create(created));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Item(1L, "jordan", "harrison","username","pass"));
		assertEquals(expected, idao.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(1L, "jordan", "harrison","username","pass"), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Customer(ID, "jordan", "harrison","username","pass"), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "chris", "perrins","username","pass");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
}