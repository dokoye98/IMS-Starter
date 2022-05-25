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

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item>,ItemsInterface {

	public static final Logger LOGGER = LogManager.getLogger();

	
	//model
	@Override
	public Item modelitems(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		double cost = resultSet.getDouble("cost");
		String name = resultSet.getString("name");
		return new Item(id,cost,name);
	}
	@Override
	public List<Item> readAll(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item");) {
			
			//items data type into array list
			List<Item> item = new ArrayList<>();
			while (resultSet.next()) {
				item.add(modelitems(resultSet));
			}
			//return of the array list
			return item;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
public Item read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelitems(resultSet);
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
public Item update(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement preStmt = connection
						.prepareStatement("UPDATE customers SET first_name = ?, surname = ? WHERE id = ?");) {
			System.out.println("item has been connected");
			preStmt.setFloat(1, item.getId());
			preStmt.setDouble(2, item.getCost());
			preStmt.setString(3, item.getName());
			preStmt.executeUpdate();
			return readLatestitem(item.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
		
	
		

	
	}

}
@Override
public Item create(Item t) {
	// TODO Auto-generated method stub
	return null;
}


}


@Override
public Item read() {
	// TODO Auto-generated method stub
	return null;
}

	




}