Spring Cloud dependency management
-----------------------------------
* Spring Cloud uses BOM (bill of materials), the reason for this is the Spring cloud project has many sub projects and each one of them can have different versions. The BOM packs all the correct version of spring cloud sub projects. The spring cloud release is termed as a release train which packs all the correct versions of spring cloud sub projects into one BOM.
* The spring cloud BOM is nothing but a pom, which consists of properties defining the supported sub project versions and a section of dependency management which holds all the spring sub project dependencies.
* For example, one of the entries in dependency management section is spring-cloud-config-dependencies, this is again a pom which consists of all the dependencies related to spring cloud config and their versions.
* One main thing to understand is that the dependencies put in dependency management are not downloaded always. We have explicitly put the dependency in the dependencies section in the child pom to get any dependency in the project. Dependency management are only used to group common dependencies in one place specifying their versions, exclusions, scope etc. If we use a dependency mentioned in the dependency management then no need to mention the version again while using it in the child pom.

Spring Cloud config server
--------------------------
This is a project to test the config server part

The config can be pulled from either the local git repo or from the remote git repo

In this case local git repo is used. Need to have a separate git repo and all the properties files should be committed only then the spring config server will read.

The properties files in the repo can be of these formats

	{application name}-{profile}.properties
	application.properties
	application-{profile}.properties
	
Generally in the microservices, each microservice will have a unique name. So any consumer for this config server will have a name and that is what we refer to {application name} here. The application name for the consumer can be set in the consumer side using 'spring.application.name' property.

For example, the git server can have the files like these

		application-dev.properties
		application-prod.properties
		application.properties
		my-test-service-dev.properties
		my-test-service-prod.properties
		my-test-service.properties

Where my-test-service is consumer application specific configuration files and application-{profile}.properties files are global files which are common to any consumer. 

1. Retrieving properties file based on application name
		http://localhost:9090/{application-name}/{env}
		http://localhost:9090/{application-name}-{env}.properties