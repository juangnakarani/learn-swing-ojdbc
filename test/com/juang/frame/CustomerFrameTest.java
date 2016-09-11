package com.juang.frame;

import java.sql.SQLException;

import com.juang.entity.Customer;
import com.juang.service.CustomerService;
import com.juang.service.impl.CustomerServiceImpl;
import com.juang.utils.DataSourceManager;

import oracle.jdbc.pool.OracleDataSource;

public class CustomerFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OracleDataSource dataSource = DataSourceManager.getDataSource();
			CustomerService customerService = new CustomerServiceImpl();
			customerService.setDataSource(dataSource);
			
			Customer c = new Customer();
			c.setName("oke");
			c.setAddress("kediri");
			System.out.println("hallo iki aku...");
			customerService.save(c);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
