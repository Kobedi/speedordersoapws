## SpeedOrder SOAP Service

This is an AWS SpeedOrder monolith example of how the Order Management Services 
the Order Fulfilment confirmDelivery exposed endpoint. 

1. You have to run the mvn compile to create the necessary java classes spawned
2. from the speedorder.xsd
3. Then you can create the maven executable $mvn clean install.
4. Have now added Dockerfile, making it easy to create a docker container.
5. Buid the docker image $docker build -t speedorder and then run it. $docker run -p 8081:8080 speedorder
6. You should still be able to access the monolith soap endpoint on port on your local: http://localhost:8081/ws/speedorder.wsdl
### Relevant articles:
    
