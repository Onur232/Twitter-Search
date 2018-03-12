# Twitter Search

A project for making search at twitter and show them in browser as table. 

## Getting Started

The jar files created by this projects is used to make search for keyword at twitter and show the search results at browser.

### Prerequisites

JAVA JRE 8 must be installed on system.
Browser is needed to communicate with software.
Must to be connected to internet in order to communicate with Twitter API. 
Executed Jar file will listen for requests on localhost offline.
All dependencies will be inserted in jar file automatically.


### Installing

Just execute jar file and go to URIs stated in "Running the tests" part of this document. 

## Running the tests 

There is a jar file created by maven build called "twittersearchapp-0.0.1-SNAPSHOT.jar" in \TwitterApi\target location. This file must be executed for testing. But due to constraints by github, it's not allowed to upload a jar file bigger then 25MB. So I tried to upload zipped file of this JAR file but that file was also bigger than 25MB. So in order to use this project, source codes must be copied and imported in Eclipse or other IDE and must be ran individually. 

To use this software after executing ;

http://localhost:8080/

A welcome page is created by Thymeleaf will welcome the user and a query string must be inserted just right of "Write text here!" part in the web page. After hitting "submit" button
Search will be made by using Twitter official API , index web page will be redirected to showtweets.html page and results of query will be shown at browser. "Created at" is the date
of created tweet and "Text" is the tweet text. For example purposes, only searching by a keyword is shown at this project. But there are lots of other query types including by user
or date etc. at Twitter API. More controller classes and Entity classes would be written. Tweet info's called "access Level", "geoLocation", "retweet count", "favorite count" are 
also taken from twitter and saved in POJO and database but due to small size of web site, only "created at" and "text" are shown at web page.

An embedded H2 database is used to save the search results in database using JPA. By using;

http://localhost:8080/h2-console/ URI, it is possible to see the table created for tweets. Query also can be made by logging in this console. 

For searching twitter,Twitter's official API dependency called "twitter4j-core" has used. Other details can be understood from source codes.


## Deployment

The output of software has created as JAR by Maven build. It can be built as WAR also. No need to deployment. It's just enough to execute JAR file and go to URI's that stated at 
"Running the tests" section of this document.

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Contributing



## Versioning

No versioning.

## Authors

* **Onur Tas** - *Initial work* - (https://github.com/Onur232)



## License

This project has no license.

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
