package com.juang.service;

import javax.sql.DataSource;

import com.juang.entity.Customer;

public interface CustomerService {
	void setDataSource(DataSource dataSource);
	Customer save(Customer c);
}
