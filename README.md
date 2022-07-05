This project is about measuring the performance of mongo db under some artificial worload. Both of the workload and simulation as well as the measuring are part of this project

# mongoDB-benchmark
You can locally/manually try the benchmark by running the containers on your machine

 
	Start the Server by building and running the image within the the Server(SUT) directory

		sudo docker build -t mongo-server .
		sudo docker run -d -p 27017:27017 mongo-server

	Once the Server is up and running, start the client
		sudo docker build -t mongo-client .
		sudo docker run -v $(pwd):/app --network="host" mongo-client

		If the Server and the Client are not running on the same host than pass the IP address while running the client container:
                        sudo docker run -v $(pwd):/app --network="host" mongo-client <ip-address>               
                
                if for some reasons the the server is not running on the default mongo DB port(27017) then pass the new port number after the IP-Address
                        sudo docker run -v $(pwd):/app --network="host" mongo-client <ip-address> <port>

