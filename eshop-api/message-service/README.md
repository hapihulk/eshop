# Message Service
Produce messages to kafka topic.


## Start Spring Boot application:
```
mvn spring-boot:run
./mvnw spring-boot:run
```

## Publish a message
Access the endpoint `http://localhost:8080/api/v1/publish` passing a `message` query parameter with your content.  

Example: `http://localhost:8080/api/v1/publish?message=Hello`
