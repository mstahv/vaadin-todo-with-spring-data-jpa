# Vaadin TODO example with PostgreSQL

A trivial TODO example app with Spring Boot, Vaadin UI and PostgreSQL for production databases.

To run/deploy, you'll need Java 17, Maven and Docker installed. The first build might feel it takes ages as I wanted to get rid of "cache files for the frontend build" for simplicity.

## Development setup

For local development, the project contains embedded H2 database, so you can simply open the project in your favourite IDE, launch the main method in TodoExampleApplication and see your app in http://localhost:8080/

## Deploying with docker-compose

The project contains a ready-made `Dockerfile` and a `docker-compose.yml` that fires a standard postgres image next to the app (and passes connection string to the Spring Boot application).

First, build the Spring Boot application with `production` Maven profile, then simply run/deploy with Docker.

    mvn clean install -Pproduction
    docker-compose up
