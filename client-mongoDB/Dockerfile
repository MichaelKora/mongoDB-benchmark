# syntax=docker/dockerfile:1
ARG IP_ADDR=localhost

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
COPY run.sh ./run.sh
RUN chmod +x ./run.sh
RUN chmod 777 ./run.sh
COPY src/main/java/DataWriter.java ./DataWriter.java
COPY src/main/java/DbConnection.java ./DbConnection.java

#RUN mkdir -p /app/csvFile
#RUN touch /app/csvFile/output.csv

#CMD [ "./mvnw", "spring-boot:run", "-Dspring-boot.run.arguments=$IPADDR"]
#CMD ["sh","-c", "./mvnw", "spring-boot:run", "-Dspring-boot.run.arguments=$IPADDR"]
ENTRYPOINT ["./run.sh"]

#, "-Dspring-boot.run.arguments=$IPADDR"
#--build-arg IP_ADDR=