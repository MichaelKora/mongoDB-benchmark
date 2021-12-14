# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app
# while running the app dont forget to mount volume
# docker build -t client-mg --build-arg IP_ADDR=127.0.0.1 .
# docker run -v $(pwd):/app -e IP_ADRR=test client-mg
# docker run -p 9000:9000  -e CLUSTER=0 -d me/app

#  Set Up the Maven Wrapper
#mvn -N io.takari:maven:wrapper -Dmaven=3.5.2
ENV IP_ADRR localhost
COPY .mvn/ .mvn

COPY mvnw pom.xml ./

COPY mvnw client-mongoDB.iml ./

RUN ./mvnw dependency:go-offline

#RUN curl localhost:27017
COPY src ./src

#RUN mkdir -p /app/csvFile
#RUN touch /app/csvFile/output.csv

CMD ["sh","-c", "./mvnw", "spring-boot:run", "-Dspring-boot.run.arguments=${IPADDR}"]

#, "-Dspring-boot.run.arguments=$IPADDR"
#--build-arg IP_ADDR=