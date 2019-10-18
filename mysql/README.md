### Pull image if not found in local repository and start a new mysql container in detached mode. 

```bash
docker run --name mysqleshop -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:5.7
```

### Start one or more stopped containers
docker container start <container_id>

### Check container running:
```bash
docker ps
```

### Create books database 

```bash
mysql -h 127.0.0.1 -P 3306 -u root -p
Enter password: my-secret-pw

CREATE USER 'eshop' IDENTIFIED BY 'eshop13';
grant all on *.* to 'eshop'@'%' identified by 'eshop13';
FLUSH PRIVILEGES;

CREATE DATABASE books CHARACTER SET utf8 COLLATE utf8_general_ci;

show databases;
```

### Create a database automatically 
```bash
docker run --name mysqleshop -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=my-secret-pw \
-e MYSQL_USER=eshop \
-e MYSQL_PASSWORD=eshop13 \
-e MYSQL_DATABASE=books \
-d mysql:5.7
```
























