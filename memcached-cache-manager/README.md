# Memcached Cache Manager

Build package using: ./mvn clean package spring-boot:repackage

Endpoints - 

1. Insert data into memcached

Method - PUT
Mapping - /memcached-cache-manager/put/{key}
Request Body - JSON Value

2. Fetch data from memcached

Method - GET
Mapping - Mapping - /memcached-cache-manager/get/{key}