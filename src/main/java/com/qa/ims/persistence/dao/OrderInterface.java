package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistence.domain.Item;

public interface OrderInterface <Order>{

	com.qa.ims.persistence.domain.Order modelOrder(ResultSet resultSet) throws SQLException;

}
