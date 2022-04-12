# Spring Boot Payroll app

## Purpose of this app

This application is not a payroll application but an API to get a list of employees for example. It can be used for other purposes.
Basically, you can make several requests to this API like:

- Listing all records
- Add a new record
- Update an existing record
- Delete a record

## Spring Boot

**What is Spring Boot?**

Spring Boot is a powerful framework to create Web applications or API. It work as a standalone app and it can use several components of the famous Spring Framework.

**Why Spring Boot?**

Historically, we worked on powerful servers with J2EE and then appeared "Spring" which is lighter than his old brother. Then, it became mandatory to separate the backend from the frontend to build more resilient and maintainable applications. Also, with the increasing popularity of Cloud services, "Spring Boot" appeared.
You can even have a local server that you can launch with the cli.

Spring Boot can compete with other frameworks like NodeJS or Symfony whereas Symfony can cover more needs than Spring Boot. 
Therefore, the main purpose of Spring Boot is to build secured APIs that are receiving many requests from applications and for different purposes.

## How to use the Spring Boot Payroll app?

There are two ways to use this application. I recommend the use of Maven. You can also use Graddle but I'll show you how to use Maven.
If you do not have Maven installed on your system, you can read the [documentation][1].

**First:**

    mvn package

This command created a subdirectory "target" that contains a .jar file. Then, call the Java binary to run this .jar file.

    java -jar path/to/MyJarFile.jar

**Second:**

It can be quicker with this command:

    mvn clean spring-boot:run

Here is a screenshot of the starting process...

![Launching Spring Boot](https://raw.githubusercontent.com/christi4n/springboot-payroll/master/assets/spring-boot-run.png)

### Requests to the API

You can make the following requests:

Get a list of records:

    curl -v localhost:8080/employees

Get a specific record id:

    curl -v localhost:8080/employees/3

Check the 404 status:

    curl -v localhost:8080/employees/99

Create a new record:

    curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Sam Fisher", "role": "Agent", "department": "Security"}'

Update an existing record:

    curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name": "Daniel Fisher", "role": "Agent", "department": "Security"}'

Delete a record:

    curl -X DELETE localhost:8080/employees/4

[1]: https://maven.apache.org/install.html