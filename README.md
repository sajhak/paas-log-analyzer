# paas-log-analyzer

Build the project, copy log-analyzer.war into \<DAS_HOME\>/repository/deployment/webapps

Copy mysql java connector jar accordingly.

curl -X GET -H "Content-Type: application/json" -k -u admin:admin https://localhost:9443/log-analyzer/logs
