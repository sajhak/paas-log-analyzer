/**
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.paas.log.analyzer.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.paas.log.analyzer.beans.LogEventBean;
import org.wso2.carbon.paas.log.analyzer.data.DBUtil;
import org.wso2.carbon.paas.log.analyzer.restapi.Constants;

import com.google.gson.Gson;

@Path(Constants.ResourcePath.ROOT_CONTEXT)
public class LogEventResource extends AbstractResource {

    private static final int DEFAULT_START_INDEX = 0;
	private static final int DEFAULT_INFINITY_INDEX = -1;
    private static final long DEFAULT_FROM_TIME = Long.MIN_VALUE;
    private static final long DEFAULT_TO_TIME = Long.MAX_VALUE;
    private static final Gson gson = new Gson();
	private static final Log logger = LogFactory.getLog(LogEventResource.class);
    private static final String STR_JSON_ARRAY_OPEN_SQUARE_BRACKET = "[";
    private static final String STR_JSON_COMMA = ",";
    private static final String STR_JSON_ARRAY_CLOSING_SQUARE_BRACKET = "]";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String DEFAULT_CHARSET = "UTF-8";

    

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/logs")
	public Response getAllLogEvents() throws Exception {
        	        
        return Response.ok(gson.toJson(DBUtil.getAllLogEvents())).build();
	}
    
    
}
