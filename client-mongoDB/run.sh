#!/bin/bash

ipAddr=127.0.0.1
portNr=27017

if [ $# -ge 1]
then
  ipAddr=$1
  if [ $# -eq 2 ]
  then
    portNr=$2
  fi
fi

echo compiling...
javac ./DbConnection.java

java ./DbConnection.java $ipAddr $portNr
