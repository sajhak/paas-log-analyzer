package org.wso2.carbon.paas.log.analyzer.data;

import java.sql.Connection;
import java.sql.DriverManager;

import org.wso2.carbon.paas.log.analyzer.data.dao.LogEventDAO;
import org.wso2.carbon.paas.log.analyzer.data.dao.MySQLLogEventDAO;

public class MySQLDAOFactory extends DAOFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/logdb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
	

    public static Connection createConnection() throws Exception {
      // TODO connection pool implementation
    	Class.forName(DRIVER);
    	return DriverManager.getConnection(DBURL, USERNAME, PASSWORD);    	
    }
    
	@Override
	public LogEventDAO getLogEventDAO() {
		return new MySQLLogEventDAO();
	}

}
