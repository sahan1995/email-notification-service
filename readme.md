# Spring Boot Email Notification Service

## Purpose

The purpose of this service is for sending emails with dynamic values and keep templates
 under database, So when need to change template static data no need to do the
  deployment, just change the template in DB.
  
<div align="center">
  <sub>Built by <a href="https://www.facebook.com/sahan.rajakaruna.7/">Sahan Rajakaruna </a>  </sub>
</div>

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.6](https://maven.apache.org)

### Prerequisites

For this service [Apache FreeMarker](https://freemarker.apache.org/) is used. That is a template engine which is add dynamic values to the template. So you have to learn how to create templates with dymanic values by using this [link](https://freemarker.apache.org/docs/dgui_template_overallstructure.html) . <br>




### Configuration
In order to run this service you have to provide the following settings :



```
spring.datasource.username=mysqlUserName
spring.datasource.password=mysqlUserPassword

spring.mail.username=sendingEmailAddress
spring.mail.password=sendingEmailPassword
```
The configuration is located in `src/resources/application.properties`.

You have to change your sending email setting, <br>

<ol>

<li>Login to the gmail account you are sending mail from</li>
<li>Go to Manage your Google Account -> Security -> Less secure app access -> Turn on access (not recommended)
    or
    Access the URL:
    https://www.google.com/settings/security/lesssecureapps</li>
<li>Turn "Allow less secure apps: OFF" to "Allow less secure apps: ON"</li>

</ol>

<b> ** Please not if you are not change this setting you can't send emails ** </b>

### Build an executable JAR
You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```

*Instead of `mvn` you can also use the maven-wrapper `./mvnw` to ensure you have everything necessary to run the Maven build.*

### Database Configuration

After you successfully run the service go to the `src/resources/sql/data.sql` and run the sql script.

### Send Emails

After you successfully run you can access swagger UI by [http://localhost:8080/swagger.html](http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config) <br>

There is one API, you have to execute that to send emails. <br>

```
to : To whoom you want to send (email addess)
subject: Subject of email
templateNumber: Which template you want to send (template_number in DB)
values : Values need to show on email

{
  "to": "example@gmail.com",
  "subject": "Email by Spring Boot",
  "templateNumber": 1,
  "values": {
    "name": "Name",
    "location": "Location",
  }
}

** Please note values key need to be same on the template dynamic variables  **
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

