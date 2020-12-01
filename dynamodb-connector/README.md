# Dynamodb connector

Build package using: ./mvn clean package spring-boot:repackage

Run docker file using: docker run --rm -d -e SERVER_PORT=48003 -e AWS_ACCESS_KEY=${AWS_ACCESS_KEY} -e AWS_SECRET_KEY=${AWS_SECRET_KEY} -e AWS_SESSION_TOKEN=${AWS_SESSION_TOKEN} -p 48003:48003/tcp ${IMAGE_ID}