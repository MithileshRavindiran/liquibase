### Liquibase Application ###

Spring boot application to integrate with liquibase to modify the database tables using liquibase change logs

Technology/Library Used

     -Spring Boot
     -Liquibase
     -Postgresql
     -Lombok
     -Hibernate
     -Spring JPA

##Postgressql##

     I had used a docker postgresql image to connect to the application.
     Command to run the postgres sql image on docker

     docker run --name customName -p 5432:5432 -e POSTGRES_DB=customdbname -e POSTGRES_PASSWORD=custompassword -d customUserName

     This runs a docker image of postgresql on your localhost on port 5432

     These properties will be added as our database properties in our application properties

     spring.datasource.url=jdbc:postgresql://localhost:5432/customdbname
     spring.datasource.username=customUserName
     spring.datasource.password=customPassword
     spring.datasource.driver-class-name=org.postgresql.Driver

##Liquibase##
  To manage the database structure of our application and to keep it synced with the entities that compose our system, we will use Liquibase.
  What is great about this tool is that it supports a wide variety of languages to manage the schema.
  For example, we can define and refactor the database by using XML, YAML, JSON, and SQL formats.
  Furthermore, Spring Boot provides a great support for Liquibase as we will see in this section.

  we can work on the Liquibase configuration. This will be an easy task, we are simply going to tell Liquibase to apply all the changesets available in a specific folder.
  To do that let's create a master Liquibase file called db.changelog-master.yaml

  Note that the path value provided is relative to src/main/resources, and therefore we will need to create a folder called changes inside src/main/resources/db/changelog/.
  In this new folder we are going to create a new file called v0001.sql and v002.sql
  This SQL file will contain the commands to create the tables and modify the tables that will support the entities of our application


##Execution##
  Run the application from IDE from the entry class LiquibaseApplication.java or from the console using mvn springboot:run

  Once you start the application we can see folowing on the logs this will create the database with the tables:

  Successfully acquired change log lock
  Creating database history table with name: public.databasechangelog
  Reading from public.databasechangelog
  classpath:/db/changelog/db.changelog-master.yaml: db/changelog/changes/v0001.sql::raw::includeAll: Custom SQL executed
  classpath:/db/changelog/db.changelog-master.yaml: db/changelog/changes/v0001.sql::raw::includeAll: ChangeSet db/changelog/changes/v0001.sql
  classpath:/db/changelog/db.changelog-master.yaml: db/changelog/changes/v0002.sql::raw::includeAll: Custom SQL executed
  classpath:/db/changelog/db.changelog-master.yaml: db/changelog/changes/v0002.sql::raw::includeAll: ChangeSet db/changelog/changes/v0002.sql

