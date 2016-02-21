package org.wso2.carbon.paas.log.analyzer.data;

import java.util.List;

public class DBUtil {

	
	public static List<LogEvent> getAllLogEvents() {		
		return DAOFactory.getDAOFactory(DAOFactory.MYSQL).getLogEventDAO().getAllLogEvents();
	}
 
	
}
