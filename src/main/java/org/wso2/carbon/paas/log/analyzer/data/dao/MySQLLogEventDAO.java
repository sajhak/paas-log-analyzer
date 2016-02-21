package org.wso2.carbon.paas.log.analyzer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.paas.log.analyzer.data.LogEvent;
import org.wso2.carbon.paas.log.analyzer.data.MySQLDAOFactory;

public class MySQLLogEventDAO implements LogEventDAO{

	private static final Log logger = LogFactory.getLog(MySQLLogEventDAO.class);

	
	public MySQLLogEventDAO() {
		
	}
	
	@Override
	public List<LogEvent> getAllLogEvents() {
		PreparedStatement ps = null;
	    ResultSet rs = null;
	    Connection conn = null;
	    List<LogEvent> logEvents = new ArrayList<>();
	    
		try {
	    conn = MySQLDAOFactory.createConnection();
		String sql = "SELECT * FROM LOGEVENT";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			LogEvent logEvent = new LogEvent();
			logEvent.setAppName(rs.getString("application_name"));
			logEvent.setIp(rs.getString("ip"));
			logEvent.setLogTime(rs.getString("log_time"));
			logEvent.setMessage(rs.getString("log_message"));
			logEvents.add(logEvent);
		}
		
		} catch(Exception e) {
			logger.error(e);			
		} finally {
			DbUtils.closeQuietly(conn, ps, rs);			
		}
		
		return logEvents;
	}

	@Override
	public List<LogEvent> getAllLogEvents(int tenantId) {
		// TODO Auto-generated method stub
		return null;
	}

}
