## SUMMARY
This project demonstrates the ideas of [Mapped Diagnostic Context] using [Spring Boot]
and [Logback]

## WHERE TO START

### Prerequisites
- [Gradle](https://gradle.org/install)
- JDK
- NodeJS
- Gulp
- Bower

### Libraries
- Spring Boot
- Logback
- SASS

## HOW TO RUN

![alt How To Run](docs/how-to-run.jpg?raw=true)

You should have 4 windows running. One is to start the server with `gradle bootRun`. One is to continuously tracking/compiling changes with `gradle -t classes`. The next one is to see the log file with `tail -F logs/app.log`. The final one is optional and it enables continuous SASS compiling.

## DESIGN

![alt MDC Web Design](docs/mdc-web-design.jpg?raw=true)

The whole idea is to use a filter before serving any request. The filter injects MDC information on a thread-based level. When the control goes into the services/controllers, the injected information will be used.


<!---
	Links used in this README.md
-->
[Mapped Diagnostic Context]: https://logback.qos.ch/manual/mdc.html
[Spring Boot]: https://projects.spring.io/spring-boot/
[Logback]: https://logback.qos.ch/