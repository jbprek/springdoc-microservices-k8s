# springdoc-microservices-k8s

## Description 

Port of  [springdoc-microservices](https://github.com/jbprek/springdoc-microservices)  to K8S

Originally based on microservices examples from [SpringDoc](https://github.com/springdoc/springdoc-openapi-maven-plugin)

1. Removed config, discovery and gateway
2. Adapted Feign to work without discovery 
3. Consolidated organization-service and department-service into one 

## Build and run

### Local

- Build and run locally as normal spring applications
- Use the included Postman collection and the 'K8S-LocalRun' env


### Docker

#### Build docker images
````
mvn -pl employee-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=employee-service:1.0.0
mvn -pl organization-service -am clean spring-boot:build-image -Dspring-boot.build-image.imageName=organization-service:1.0.0
````

#### Push docker images to Registry
````
docker tag employee-service:1.0.0 localhost:5000/employee-service:1.0.0
docker push localhost:5000/employee-service:1.0.0

docker tag organization-service:1.0.0 localhost:5000/organization-service:1.0.0
docker push localhost:5000/organization-service:1.0.0
````

#### Run Locally Using Docker
````
docker run -p 8092:8092 --name  employee-service  localhost:5000/employee-service:1.0.0
docker run -p 8091:8091 --name  organization-service localhost:5000/organization-service:1.0.0

# Clean Up 
docker rm -f employee-service 
docker rm -f organization-service 

# Use the included Postman collection and the 'K8S-LocalRun' env

````

#### Deploy and run in K8s
````
kubectl apply -k ./kustomize/base
kubectl port-forward -n dev service/employee-service 8092:80 --address=0.0.0.0 &
kubectl port-forward -n dev service/organization-service 8091:80 --address=0.0.0.0 &
# Clean Up
kubectl delete -k ./kustomize/base
# Kill background port-forward 

````

