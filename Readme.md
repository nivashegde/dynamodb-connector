#Caching Mechanisms


###Run Dynamodb-Connector without caching mechanisms

######Pulling & running dynamodb-connector image:

docker pull nivashegde01/dynamodb-connector:1

docker run -d \
--name db-connector-no-cache \
-e SERVER_PORT=48001 \
-e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} \
-e AWS_SECRET_KEY=${AWS_SECRET_KEY} \
-p 48001:48001/tcp \
${dynamo-db-connector-image-id}



###Run Dynamodb-Connector with Memcached

######Pulling & running memcached base image:

docker pull memcached

docker run --name my-memcache -d -p 11211:11211 memcached

######Pulling & running memcached-cache-manager image:

docker pull nivashegde01/memcached-cache-manager:1

sudo docker run -d \
--network="host" \
--name memcached-cache-manager \
-e SERVER_PORT=49002 \
-p 49002:49002/tcp \
${memcached-cache-manager-image-id}

######Running dynamodb-connector image:

sudo docker run -d \
--network="host" \
--name db-connector-memcached \
-e SERVER_PORT=48002 \
-e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} \
-e AWS_SECRET_KEY=${AWS_SECRET_KEY} \
-e USE_CACHE=TRUE \
-e CACHE_PORT=49002 \
-e CACHE_SERVICE=MEMCACHED \
-p 48002:48002/tcp \
${dynamo-db-connector-image-id}



###Run Dynamodb-Connector with Redis

######Pulling & running redis base image:

docker pull redis

sudo docker run --name my-redis -d -p 6379:6379 redis

######Pulling & running redis-cache-manager image:

ddocker pull nivashegde01/redis-cache-manager:1

sudo docker run -d \
--network="host" \
--name redis-cache-manager \
-e SERVER_PORT=49003 \
-p 49003:49003/tcp \
${redis-cache-manager-image-id}

######Running dynamodb-connector image:

sudo docker run -d \
--network="host" \
--name db-connector-redis \
-e SERVER_PORT=48003 \
-e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} \
-e AWS_SECRET_KEY=${AWS_SECRET_KEY} \
-e USE_CACHE=TRUE \
-e CACHE_PORT=49003 \
-e CACHE_SERVICE=REDIS \
-p 48003:48003/tcp \
${dynamo-db-connector-image-id}