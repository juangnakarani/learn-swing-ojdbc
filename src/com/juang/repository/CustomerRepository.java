package com.juang.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.juang.entity.Customer;

public class CustomerRepository {
	private static final CustomerRepository INSTANCE = new CustomerRepository();
	private Connection connection;
	private PreparedStatement insertStatement;
	private final String insertQuery = "insert into m_customer(name, address) values (?,?)";

	public static CustomerRepository getInstance() {
		return INSTANCE;
	}

	public void setConnection(Connection connection) throws SQLException {

		this.connection = connection;
		insertStatement = this.connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

	}

	public Customer save(Customer c) throws SQLException {
		if (c.getId() == null) {
			System.out.println("+-------------------------+");
			System.out.println("id :" + c.getId());
			System.out.println("name :" + c.getName());
			System.out.println("address :" + c.getAddress());
			System.out.println("+-------------------------+");
			insertStatement.setString(1, c.getName());
			insertStatement.setString(2, c.getAddress());
			//System.out.println("check query: " + ((OraclePreparedStatementWrapper) insertStatement).getOriginalSql());
			insertStatement.executeQuery();
			
			System.out.println("customer executed");
		}
		System.out.println("customer saved");
		return c;
	}
}
