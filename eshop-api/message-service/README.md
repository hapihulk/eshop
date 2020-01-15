# Message Service
Produce messages to kafka topic.


## Start Spring Boot application:
```
./mvnw spring-boot:run
```

## Publish a message
To publish a message, access the endpoint `http://localhost:8080/publish` passing a `message` query parameter with your content.  

Example: `http://localhost:8080/api/v1/publish?message=sample_message`
