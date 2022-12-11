This is the config client test project.

The spring config service url and the consumer application name should be kept in 
bootstrap.properties and not in application.properties. The spring boot applicaiton will load
bootstrap.properties before application.properties file.

The properties loaded from the config service can be referred using @Value.

Spring config client will automatically access the config server using the url patterns like
	
	http://localhost:8080/application name/profile
	
For example,
	
	http://localhost:9090/my-test-service/default
			my-test-service.properties
			application.properties
			
	http://localhost:9090/my-test-service/dev
			my-test-service-dev.properties
			application-dev.properties
			
The environment that we pass to this application actually decides the environment that gets passed to the config server to get the env based properties file.

Whenever a configuration changes on the git repo, we can refresh the configuration on the consumer side without having to restart the application. 

For this we need to use the @RefreshScope on the class which is holding the props through @Value usage. 

After this we need to use an actuator API to refresh the consumer to load the latest changes from the spring config server. The API is /refresh which is a POST, so we need to pass an empty post body
		
		curl -d{} http://localhost:8080/refresh 
		
If there are more services running or if there are many instances of the service running, then it may be difficult to call the /refresh API on all the running instances. 
So to solve this spring cloud stream provides a way in which all the running nodes will be connected through a message queue. We have to use 'spring-cloud-starter-bus-amqp' starter dependency. With this setup, whenever we need to refresh, we do not have to call /refresh on all the nodes, instead we can call /bus/refresh (different API if MQ is used) on any one node, that node will add a queue into the message queue and it will refresh all the other connected nodes.

The dependency required to use message queue
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>













  