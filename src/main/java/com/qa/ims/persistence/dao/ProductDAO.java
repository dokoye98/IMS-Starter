package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.DBUtils;

public class ProductDAO implements Dao<Product>, ProductInterface {
	
	
	public static final Logger LOGGER = LogManager.getLogger();


	@Override
	public Product modelProduct(ResultSet resultSet) throws SQLException {
		Long product_id = resultSet.getLong("product_id");
		double cost = resultSet.getDouble("cost");
		String addOns = resultSet.getString("addOns");
		return new Product(product_id,cost,addOns);
	}
	@Override
	public List<Product> readAll(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");) {
			
			
			List<Product> product = new ArrayList<>();
			while (resultSet.next()) {
				product.add(modelProduct(resultSet));
			}
			
			return product;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
public Product read(Long product_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM product ORDER BY product_id DESC LIMIT 1");) {
			resultSet.next();
			return modelProduct(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
}
	@Override 
	public int delete(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE product_id = ?");) {
			statement.setLong(1,order_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
		}

@Override
public Product update(Product product) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement preStmt = connection
						.prepareStatement("UPDATE product SET cost = ?,addons = ? WHERE product_id = ?");) {
		preStmt.setDouble(1, product.getCost());
			preStmt.setString(2, product.getAddOns());
			preStmt.setLong(3, product.getProductId());
			preStmt.executeUpdate();
			return read(product.getProductId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
}


@Override
public Product create(Product product) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement Stmt = connection
					.prepareStatement("Insert into Product(cost,addons) VALUES (?,?);");) {
		Stmt.setDouble(1, product.getCost());
		Stmt.setString(2, product.getAddOns());
		Stmt.executeUpdate();
		return read();
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;

}


public Product read() {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM product ORDER BY product_id DESC LIMIT 1");) {
		resultSet.next();
		return modelProduct(resultSet);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;

	
}
}
