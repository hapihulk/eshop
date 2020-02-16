# document-service

## Build
```bash
mvn clean install
mvn spring-boot:run
```

## Run
```bash
java -jar target/document-service.jar
```

## Test
Open with postman
### Verify access token
Step-1:  
POST http://localhost:8081/oauth/token  
```
	- Authorization  
		- TYPE=Basic Auth  
		- Username=John  
		- Password=123456  
		
	- Body  
		- x-www-form-urlencoded  
		- KEY=grant_type and VALUE=client_credentials  
```		
Step-2: 
 
GET http://localhost:8081/api/v1/users/current  
```
	- Authorization  
		- TYPE=Bearer Token  
		- Token=<access_token_from_step-1>  
```
GET http://localhost:8081/api/v1/users/me  
```
	- Authorization  
		- TYPE=Bearer Token  
		- Token=<access_token_from_step-1>  
```
		
