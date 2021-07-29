# DamcoAssessment
Damco Assessment CRUD, Junit, mockito, Eureka, and Zuul proxy

This application is created using Java, Spring Boot as a micro service and used to perform CRUD operation on USER entity.
Following points are taken care while creating these microservice: 
1. This microservice is developed using in memory mongodb.
2. Once the service is up and running we can use MongoDb Compass to see our in memory database: => http://localhost:27017
3. Rest end points are created for CRUD operation.
4. Spring boot Junit test cases are written for CRUD operation.
5. Application's build tool is maven.
6. Default in memory server tomcat is used.
7. Eureka server is used to monitor microservices.
8. Zuul proxy is also used to chanelling the request through api gateway.
9. Swagger ui can also be view on following URL:
  http://localhost:9393/user-service/swagger-ui.html (through api-gateway)
  or,
  http://localhost:8181/swagger-ui.html

Following microservices are created for the assessment:
1. DamcoAssessment: Main application where Rest end points are defined.
2. eureka-discovery-server: To configure eureka-server to view and monitor microservices
3. api-gateway: To Channell and delegate requests from one micro service to another micro service.

To Run the application please follow following steps:
1. Run eureak-discovery-server microservice (port: 8761)----> to open eureka server on browser hit: http://localhost:8761
2. Run api-gateway microservice(port: 9393)
3. Run DamcoAssessment microservice(port: 8181)

End points without api-gateway:
1. http://localhost:8181/createuser (this end point is used to save as well as for update)
2. http://localhost:8181/getusers
3. http://localhost:8181/deleteuser

End points with api-gateway:
1. http://localhost:9393/user-service/createuser
2. http://localhost:9393/user-service/getusers
3. http://localhost:9393/user-service/deleteuser
4. http://localhost:9393/user-service/swagger-ui.html

