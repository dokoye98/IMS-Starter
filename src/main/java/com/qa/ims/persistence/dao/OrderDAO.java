package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>,OrderInterface{


	@Override
	public Order modelOrder(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		double cost = resultSet.getDouble("cost");
		String name = resultSet.getString("name");
		return new Order(id);
	}
	@Override
	public List<Order> readAll(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item");) {
			
			
			List<Order> item = new ArrayList<>();
			while (resultSet.next()) {
				item.add(modelOrder(resultSet));
			}
			
			return item;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelOrder(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
}
	@Override 
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE id = ?");) {
			statement.setLong(1, id);
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
						.prepareStatement("UPDATE item SET customer_id = ? WHERE id = ?");) {
			System.out.println("item has been connected");
			preStmt.setLong(1, order.getCustomer_ID());
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
		resultSet.next();
		return modelOrder(resultSet);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;


}
}