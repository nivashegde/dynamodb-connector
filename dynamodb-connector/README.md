# Dynamodb connector

Build package using: ./mvn clean package spring-boot:repackage

Build docker image using: sudo docker build -t nivashegde01/dynamodb-connector:tagname

Pull image using: docker push nivashegde01/dynamodb-connector:tagname

Running dynamodb-connector without caching mechanisms:

docker run -e SERVER_PORT=48001 -e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -e AWS_SECRET_KEY=${AWS_SECRET_KEY} -e AWS_SESSION_TOKEN=${AWS_SESSION_TOKEN} -p 48001:48001/tcp ${IMAGE_ID}


Running dynamodb-connector with memcached caching mechanism:

docker run -e SERVER_PORT=48001 -e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -e AWS_SECRET_KEY=${AWS_SECRET_KEY} -e AWS_SESSION_TOKEN=${AWS_SESSION_TOKEN} -e USE_CACHE=TRUE -e CACHE_PORT=48002 -e CACHE_SERVICE=MEMCACHED -e CACHE_HOST=${CACHE_HOST} -p 48001:48001/tcp ${IMAGE_ID}


Running dynamodb-connector with redis caching mechanism:

docker run -e SERVER_PORT=48001 -e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -e AWS_SECRET_KEY=${AWS_SECRET_KEY} -e AWS_SESSION_TOKEN=${AWS_SESSION_TOKEN} -e USE_CACHE=TRUE -e CACHE_PORT=48003 -e CACHE_SERVICE=REDIS -e CACHE_HOST=${CACHE_HOST} -p 48001:48001/tcp ${IMAGE_ID}


For local cache server use host as docker.for.mac.host.internal