#!/bin/sh

ipAddr=127.0.0.1
portNr=27017
ls -al ./src/main/java/

if [ $# -ge 1]
then
  ipAddr=$1
  if [ $# -eq 2 ]
  then
    portNr=$2
  fi
fi

echo compiling...
#javac ./src/main/java/DbConnection.java

#java ./src/main/java/DbConnection.java $ipAddr $portNr
#java ./src/main/java/DbConnection.java 

#./mvnw spring-boot:run -Dspring-boot.run.arguments="Michael"
./mvnw spring-boot:run -Drun.arguments="Michael"
#./mvnw spring-boot:run -Dexec.args="Michael"
#./mvnw spring-boot:run

