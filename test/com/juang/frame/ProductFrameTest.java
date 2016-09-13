package com.juang.frame;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.juang.entity.Customer;
import com.juang.entity.Product;
import com.juang.service.CustomerService;
import com.juang.service.ProductService;
import com.juang.service.impl.CustomerServiceImpl;
import com.juang.service.impl.ProductServiceImpl;
import com.juang.utils.DataSourceManager;

import oracle.jdbc.pool.OracleDataSource;

public class ProductFrameTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OracleDataSource dataSource = DataSourceManager.getDataSource();
			ProductService productService = new ProductServiceImpl();
			productService.setDataSource(dataSource);
			
			Product p = new Product();
			p.setDescription("Laptop Acer");
			p.setPrice(new BigDecimal(2000000.45));
			System.out.println("hallo iki aku...");
			productService.save(p);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
