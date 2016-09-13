package com.juang.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.juang.entity.Sales;

public class SalesRepository {
	private Connection connection;
	private PreparedStatement insertStatement;
	private final String insertQuery = "INSERT INTO T_SALES(TRANSDATE, PRODUCT_ID, PRICE) VALUES(?,?,?)";

	public void setConnection(Connection connection) throws SQLException{
		this.connection = connection;
		this.insertStatement = this.connection.prepareStatement(insertQuery);
	}
	
	public Sales save(Sales s) throws SQLException{
		if(s.getId()==null){
		this.insertStatement.setDate(1, new Date(s.getTransDate().getMillis()));
		this.insertStatement.setInt(2, s.getProducts().get(0).getId());
		this.insertStatement.setBigDecimal(3, s.getPrice());
		this.insertStatement.executeUpdate();
		}
		return s;
		
	}
}
