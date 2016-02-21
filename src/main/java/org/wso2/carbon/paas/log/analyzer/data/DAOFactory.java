package org.wso2.carbon.paas.log.analyzer.data;

import org.wso2.carbon.paas.log.analyzer.data.dao.LogEventDAO;

public abstract class DAOFactory {

	public static final int ORACLE = 1;
	public static final int MYSQL = 2;
	
	public abstract LogEventDAO getLogEventDAO();
	
	public static DAOFactory getDAOFactory(int type) {
		switch (type) {
		case MYSQL:
			return new MySQLDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		default:
			return null;
		}
	}
}
