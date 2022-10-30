# springdoc-microservices-k8s

## Description 

Port of  [springdoc-microservices](https://github.com/jbprek/springdoc-microservices)  to K8S

Originally based on microservices examples from [SpringDoc](https://github.com/springdoc/springdoc-openapi-maven-plugin)

1. Removed config, discovery and gateway
2. Adapted Feign to work without discovery 

## Build and run

### Local

- Build and run locally as normal 
- Use the included Postman collection and the 'K8S-LocalRun' env
- Use the included Postman collection and the 'K8S-LocalRun' env


### Docker

- Build  docker images

#### Build docker images
``
mvn -pl department-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/department-service:1.0.0

mvn -pl organization-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/organization-service:1.0.0

mvn -pl employee-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/employee-service:1.0.0

``

#### Push docker images to Docker Hub
``
mvn -pl department-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/department-service:1.0.0

mvn -pl organization-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/organization-service:1.0.0

mvn -pl employee-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=jbprek/employee-service:1.0.0

``

- Use the included Postman collection and the 'K8S-LocalRun' env
