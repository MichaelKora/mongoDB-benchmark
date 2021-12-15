# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app
# while running the app dont forget to mount volume
# docker run -v $(pwd):/app client-mg

#  Set Up the Maven Wrapper
#mvn -N io.takari:maven:wrapper -Dmaven=3.5.2

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

COPY mvnw client-mongoDB.iml ./

RUN ./mvnw dependency:go-offline

#RUN curl localhost:27017
COPY src ./src

#RUN mkdir -p /app/csvFile
#RUN touch /app/csvFile/output.csv
COPY entrypoint.sh ./
RUN chmod +x ./entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
#CMD ["./mvnw", "spring-boot:run"]

#CMD ["./mvnw", "spring-boot:run", "-Drun.arguments=$ipaddresse"]
# docker run -v $(pwd):/app --network="host" -e ipaddresse='Hello' client-mdb