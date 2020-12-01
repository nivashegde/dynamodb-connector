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

Steps:

1. Run base memcached image 

docker pull memcached
docker run --name my-memcache -d -p 11211:11211 memcached

2. Pull memcached-cache-manager

docker push nivashegde01/memcached-cache-manager:tagname

3. Run memcached-cache-manager

docker run -d -e SERVER_PORT=48002 -e CACHE_HOST=${CACHE_HOST} -p 48002:48002/tcp ${IMAGE_ID}

Use docker.for.mac.host.internal for local cache host