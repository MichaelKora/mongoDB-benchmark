# mongoDB-benchmark
You can locally test the benchmark by running the containers on your machine

 
	Start the Server by building and running the image within the the Server(SUT) directory

		sudo docker build -t mongo-server .
		sudo docker run -d -p 27017:27017 mongo-server

	Once the Server is up and running, start the client
		sudo docker build -t mongo-client .
		sudo docker run -v $(pwd):/app --network="host" mongo-client


