# README #


### What is this repository for? ###

* The purpose of this appliction is to return five day weather forecast for a given location based on post code input.


### How do I get set up? ###

* This project is using Java version 1.8.0_221

* In order to locally run the application follow those steps:
	1. clone the repository and checkout master branch
	2. run the main method in FivedayforecastApplication class
	

* To perform Tests, navigate to main project directory and run "mvn test"

* When application is runnig locally, send request to http://localhost:8080/api/v1/weather/fivedayforecast/{post-code} to get response with weather forecast.

* Actual weather forecast data can be found in response body.

* In order to check number of requests to external weather api, simply send request to http://localhost:8080/api/v1/metrics/requests

### Performance ###
* Performance was checked using jMeter and Concurency Thread Group (to make sure that app can handle 25 RPS)

### Who do I talk to? ###

* pawel.glowacki2@gmail.com
