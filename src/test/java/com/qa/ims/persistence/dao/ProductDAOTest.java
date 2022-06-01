package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.DBUtils;

public class ProductDAOTest {

	private final ProductDAO proDAO = new ProductDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Product created = new Product(2L,2.45,"wifi");
		assertEquals(created, proDAO.create(created));
	}


	@Test
	public void testReadAll() {
		List<Product> expected = new ArrayList<>();
		expected.add(new Product(1L,2.45,"wifi"));
		assertEquals(expected, proDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Product(1L,2.45,"wifi"), proDAO.read());
	}

	@Test
	public void testRead() {
		final long PRODUCT_ID = 1L;
		assertEquals(new Product(PRODUCT_ID,2.45,"wifi"), proDAO.read(PRODUCT_ID));
	}

	@Test
	public void testUpdate() {
		final Product updated = new Product (1L,2.45,"wifi");
		assertEquals(updated, proDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, proDAO.delete(1));
	}
	
	
}
