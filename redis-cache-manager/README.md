# Redis Cache Manager

Build package using: ./mvn clean package spring-boot:repackage

Endpoints - 

1. Insert data into redis

Method - PUT
Mapping - /redis-cache-manager/put/{key}
Request Body - JSON Value

2. Fetch data from redis

Method - GET
Mapping - Mapping - /redis-cache-manager/get/{key}