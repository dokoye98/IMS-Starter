package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistence.domain.Client;

public  interface ClientInterface <Client> {

	com.qa.ims.persistence.domain.Client modelClient(ResultSet resultSet) throws SQLException;
	

	

}
