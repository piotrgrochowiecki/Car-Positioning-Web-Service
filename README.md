# Car Positioning Web Service for E-RideRent application
RESTful web service that provides positioning information about cars owned by rental company.

## Used technologies:
* Java 17
* MySQL
* Spring Boot
* Hibernate
* Spring Data
* Maven
* Docker

## About the app
<p>
This RESTful web application provides geolocation information (date, time, longitude and latitude) for given 
car.
</p>
<p>
It communicates with E-RideRent application via REST API.
</p>

## Set up a database using Docker
<p>
This part assumes that you have Docker engine already installed and running.
To set up a database, use terminal and navigate to main directory of the project. If opened in IntelliJ, you can use "Terminal"
card there.
</p>
<p>
Run following commands in order:
</p>

````
docker run --name=CarPositioningServiceDB -p 3310:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=1 -e MYSQL_DATABASE=car_positioning_service_db -d mysql:latest
````