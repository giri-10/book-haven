# book-haven

System Design:

![architecture](https://github.com/user-attachments/assets/41ccf70c-d04d-4663-a0b3-0f9dd5f1c3b6)


Commands for running the application:

To install the dependencies, <br>
mvn clean install (cd Desktop/book-haven)

Spotless apply:<br>
mvn spotless:apply (cd Desktop/book-haven)

To run the application, use the following command:<br>
mvn spring-boot:run (cd Desktop/book-haven)

to build the catalog-service docker image: <br>
mvn -pl catalog-service spring-boot:build-image -DskipTests
(Run in docker terminal, cd Desktop/book-haven)

To run all services in docker compose:<br>
docker-compose -f deployment/docker-compose/infra.yml -f deployment/docker-compose/apps.yml up -d