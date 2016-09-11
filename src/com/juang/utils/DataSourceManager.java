package com.juang.utils;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DataSourceManager {
	private static final String DATABASE = "xe";
	private static final String DRIVERTYPE = "thin";
	private static final String SERVERNAME = "localhost";
	private static final int PORT = 1521;
	private static final String USERNAME = "oxedba";
	private static final String PASSWORD = "oxepwd";

	public static OracleDataSource getDataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setDatabaseName(DATABASE);
		dataSource.setDriverType(DRIVERTYPE);
		dataSource.setServerName(SERVERNAME);
		dataSource.setUser(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setPortNumber(PORT);
		System.out.println(dataSource);
		return dataSource;
	}

}
