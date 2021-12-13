# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app
#while running the app dont forget to mount volume
# docker run -v $(pwd):/app client-mg
#RUN mvn install
COPY .mvn/ .mvn

#  Set Up the Maven Wrapper
#mvn -N io.takari:maven:wrapper -Dmaven=3.5.2

COPY mvnw pom.xml ./

COPY mvnw client-mongoDB.iml ./

RUN ./mvnw dependency:go-offline

#RUN curl localhost:27017
COPY src ./src

#RUN mkdir -p /app/csvFile
#RUN touch /app/csvFile/output.csv

CMD ["./mvnw", "spring-boot:run"]