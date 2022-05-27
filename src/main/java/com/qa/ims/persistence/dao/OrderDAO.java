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

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>,OrderInterface{

	
	public static final Logger LOGGER = LogManager.getLogger();


	@Override
	public Order modelOrder(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long customer_id = resultSet.getLong("customer_id");
		return new Order(order_id,customer_id);
	}
	@Override
	public List<Order> readAll(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			
			
			List<Order> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelOrder(resultSet));
			}
			
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
public Order read(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelOrder(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
}
	@Override 
	public int delete(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1,order_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
		}

@Override
public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement preStmt = connection
						.prepareStatement("UPDATE orders SET customer_id = ? WHERE order_id = ?");) {
			preStmt.setLong(1, order.getCustomer_ID());
			preStmt.setLong(2, order.getOrder_ID());
			preStmt.executeUpdate();
			return read(order.getOrder_ID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


@Override
public Order create(Order order) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement Stmt = connection
					.prepareStatement("Insert into Orders(Customer_ID) VALUES (?);");) {
		Stmt.setLong(1, order.getCustomer_ID());
		Stmt.executeUpdate();
		return read();
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;

}


public Order read() {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
		resultSet.next();
		return modelOrder(resultSet);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;


}
}