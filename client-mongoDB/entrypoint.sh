#!/bin/bash
#mvn spring-boot:run $1
./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.addr=$1