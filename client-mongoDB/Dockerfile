# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app
#while running the app dont forget to mount volume
#docker run --volume=/tmp/csvFile:/app/csvFile client-mdb
COPY .mvn/ .mvn

#  Set Up the Maven Wrapper
#mvn -N io.takari:maven:wrapper -Dmaven=3.5.2

COPY mvnw pom.xml ./

COPY mvnw client-mongoDB.iml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

#RUN mkdir -p /app/csvFile
#RUN touch /app/csvFile/output.csv

CMD ["./mvnw", "spring-boot:run"]