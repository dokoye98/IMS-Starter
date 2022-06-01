package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistence.domain.Order;

//adding an interface class specifically for each class for the modelset method
public interface ProductInterface <Product> {

	com.qa.ims.persistence.domain.Product modelProduct(ResultSet resultSet) throws SQLException;

}
