# HDB

Spring App with connection in HANA using JPA

* [Pre requisites](#pre-requisites)
* [Running the application](#running-the-application)
  * [Locally](#locally)
  * [Remotely](#remotely) 
  * [Containers](#containers)

#

### Pre requisites

To run the application on cloud, follow steps described on SAP Developer in order to create your own HANA 
instance.

* [Mission: Get Started with SAP HANA Cloud](https://developers.sap.com/mission.hana-cloud-get-started.html)
  * [Deploy SAP HANA Cloud Trial](https://developers.sap.com/tutorials/hana-cloud-deploying.html)

Otherwise, you can also run the application locally, start from [**here**](#locally).

<a href="#"><i><p align="right"><small>back to the top</small></p></i></a>

#

### Running the application

Bear in mind the available profiles before running the application, each has its own behavior and purpose that you have
to taken in account before any action.

Available profiles:
* test (H2)
* dev (Postgres)
* cf (HANA)

<a href="#"><i><p align="right"><small>back to the top</small></p></i></a>

#

#### Locally

Replace the statement below with the profile you wish to run. The execution will the application running at `localhost`
scope. 

```shell
./mvnw spring-boot:run -P <test|cf>   
```

#

#### Remotely

In case you wish to build the application to run in a container or in Cloud Foundry, you have to build the application
first by using maven. Just like described below:

```shell
mvn clean install -P <profile>
```

#### Containers

The main purpose of running applications using containers is to reproduce a productive environment before deployment. 

Available profiles on project to running on containers are `dev` and `cf`. It's not possible to run using profile 
`test` or H2 Database.

Run the statement below to start containers. Make sure you've done the proper application build 
before starting the docker-compose.

Build the application with Maven.

```shell
mvn clean install -P <dev|cf>
```

Then start containers.

```shell
docker-compose up --build
```

<a href="#"><i><p align="right"><small>back to the top</small></p></i></a>
