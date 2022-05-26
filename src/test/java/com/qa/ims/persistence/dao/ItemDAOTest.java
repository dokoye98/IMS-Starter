package com.qa.ims.persistence.dao;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO itemdao = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(2.45,"percy");
		assertEquals(created, itemdao.create(created));
	}


	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(2.45,"percy"));
		assertEquals(expected, itemdao.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(2.45,"percy"), itemdao.read());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(2.45,"percy"), itemdao.read(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item (2.45,"percy");
		assertEquals(updated, itemdao.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, itemdao.delete(1));
	}
}


