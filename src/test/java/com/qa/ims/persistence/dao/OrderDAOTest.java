package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO odao = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(1l);
		assertEquals(created, odao.create(created));
	}


	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1l));
		assertEquals(expected, odao.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L), odao.read());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(1l), odao.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order (1L);
		assertEquals(updated, odao.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, odao.delete(1));
	}

}
