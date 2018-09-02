# Bitcoin Statistics Application

This application provides users some published API for getting AVERAGE, MEDIAN, HIGHEST bitcoin price for last X minutes.
There are thre APIs present in the application:
1) "/average/{time}" -> this api gives average of bitcoin price for last X minutes
2) "/median/{time}"  -> this api gives median of bitcoin price for last X minutes
3) "/highest/{time}" -> this api gives highest price or peek price value in last X minutes


Application Design:

This application is created by following Microservice Architecture.To create various microservices used Spring-Cloud, Spring-Boot, Eureka, Netflix ZUUL, etc.
This app contains three microservices:
1) Discovery microservice: This is the book-keeper of other microservices. This is an Eureka Server.
2) Gateway microservice: This is a proxy provider, or in other words it is the Gateway to the REST APIs.
3) BitCoin Microservice: This is the microservice which provides REST APIs to clients.

The above microservices are running in different different ports. 
To access the bitcoin microservice, user need to go through the gateway.

How to run this APP?

1) First build the DISCOVERY project and then use "mvn spring-boot:run" to start the Discovery microservice. To have high availability of the application user can start this microservice in multiple ports with command "mvn spring-boot:run -Drun.arguments=--server.port=<port_no>".

2) Start the Gateway microservice as above.

3) Start the BitCoin microservice same as above.

To access the api user need to use :
1) "/api/bitcoin/average/{time}"
2) "/api/bitcoin/median/{time}"
3) "/api/bitcoin/highest/{time}"
