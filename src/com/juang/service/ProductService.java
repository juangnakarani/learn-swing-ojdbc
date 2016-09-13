package com.juang.service;

import javax.sql.DataSource;

import com.juang.entity.Product;

public interface ProductService {
	void setDataSource(DataSource dataSource);

	Product save(Product p);
}
