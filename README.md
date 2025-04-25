# book-haven

System Design:

![architecture](https://github.com/user-attachments/assets/41ccf70c-d04d-4663-a0b3-0f9dd5f1c3b6)


Commands for running the application:

To install the dependencies, 
mvn clean install (cd Desktop/book-haven)

Spotless apply
mvn spotless:apply (cd Desktop/book-haven)

To run the application, use the following command:
mvn spring-boot:run (cd Desktop/book-haven)

to build the catalog-service docker image
mvn -pl catalog-service spring-boot:build-image -DskipTests
(Run in docker terminal, cd Desktop/book-haven)

To 