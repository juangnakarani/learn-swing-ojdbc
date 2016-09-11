package com.juang.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.juang.entity.Customer;
import com.juang.repository.CustomerRepository;
import com.juang.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private Connection connection;
	private CustomerRepository customerRepository;
	private static CustomerServiceImpl INSTANCE = new CustomerServiceImpl();
	
	private CustomerServiceImpl getInstance(){
		return INSTANCE;
	}
	
	@Override
	public void setDataSource(DataSource dataSource) {
		try {
			connection = dataSource.getConnection();
			customerRepository = new CustomerRepository();
			customerRepository.setConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer save(Customer c) {
		// TODO Auto-generated method stub
		try {
			return customerRepository.save(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
