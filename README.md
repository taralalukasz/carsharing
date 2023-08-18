# carsharing

how to run the project
1) create network  
   docker network create mynetwork
2) how to rabbit
   docker run -it --rm --name rabbitmq --net mynetwork -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
3) how to run application 
   docker run --name api  -p 8080:8080 --net mynetwork carsharing-api
4) access api using localhost:8080/welcome