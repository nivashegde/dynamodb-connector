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

Steps:

1. Run base redis image 

docker pull redis
docker run --name my-redis -d -p 6379:6379 redis

2. Pull redis-cache-manager

docker push nivashegde01/redis-cache-manager:tagname

3. Run redis-cache-manager

docker run -d -e SERVER_PORT=48003 -e CACHE_HOST=${CACHE_HOST} -p 48003:48003/tcp ${IMAGE_ID}

Use docker.for.mac.host.internal for local cache host