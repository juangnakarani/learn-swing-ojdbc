package com.juang.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.juang.entity.Product;

public class ProductRepository {
	public static ProductRepository getInstance(){
		return new ProductRepository();
		
	}
	private Connection connection;
	private PreparedStatement insertStatement;
	private final String insertQuery = "INSERT INTO M_PRODUCT(DESCRIPTION, PRICE) VALUES(?,?)";

	public void setConnection(Connection connection) throws SQLException {
		this.connection = connection;
		insertStatement = this.connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

	}

	public Product save(Product p) throws SQLException {
		if (p.getId() == null) {
			this.insertStatement.setString(1, p.getDescription());
			this.insertStatement.setBigDecimal(2, p.getPrice());
			this.insertStatement.executeUpdate();
		}
		return p;
	}

}
