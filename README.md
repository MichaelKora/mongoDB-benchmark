# mongoDB-benchmark
You can locally test the benchmark by running the containers on your machine

 
	Start the Server by building and running the image within the the Server(SUT) directory

		docker build -t mongoServer .
		docker run -d -p 27017:27017 mongoServer

	Once the Server is up and running, start the client
		docker build -t mongoClient .
		docker run -v $(pwd):/app --network="host" mongoClient


