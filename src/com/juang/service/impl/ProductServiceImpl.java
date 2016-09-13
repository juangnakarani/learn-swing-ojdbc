package com.juang.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.juang.entity.Product;
import com.juang.repository.CustomerRepository;
import com.juang.repository.ProductRepository;
import com.juang.service.ProductService;

public class ProductServiceImpl implements ProductService{
private Connection connection;
private ProductRepository productRepository;

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		try {
			connection = dataSource.getConnection();
			productRepository = new ProductRepository();
			productRepository.setConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		
		try {
			return productRepository.save(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
