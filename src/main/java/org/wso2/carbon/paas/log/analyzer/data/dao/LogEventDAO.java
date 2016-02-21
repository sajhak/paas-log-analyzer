package org.wso2.carbon.paas.log.analyzer.data.dao;

import java.util.List;

import org.wso2.carbon.paas.log.analyzer.data.LogEvent;

public interface LogEventDAO {

	public List<LogEvent> getAllLogEvents();
	public List<LogEvent> getAllLogEvents(int tenantId) throws Exception;
	// TODO add more operations
	
	
}
