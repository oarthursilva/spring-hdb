# HDB

Spring App with connection in HANA using JPA

### Running the application

Bear in mind the available profiles before running the application, each has its own behavior and purpose that you have
to taken in account before any action.

Available profiles:
* test
* dev
* cf

#### Locally

Replace the statement below with the profile you wish to run. The execution will the application running at `localhost`
scope. 

```shell
./mvnw spring-boot:run -P <profile>   
```

### Remotely

In case you wish to build the application to run in a container or in Cloud Foundry, you have to build the application
first by using maven. Just like described below:

```shell
mvn clean install -P <profile>
```
