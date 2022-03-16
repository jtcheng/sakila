This is a [spring boot][1] personal study project base on the [sakila][2] sample database.

I will continuous improvement this project when I'm free.

## Tools and Frameworks

- Spring Tools 4
- MySQL 8
- Java 17
- Gradle 7
- Spring boot 2.6
- Springdoc 1.6 and Swagger 3
- JUnit 5
- Lombok 1.8
- Docker Compose 3

## Play with the Project

1) Get the source code

```shell
$ git clone git@github.com:jtcheng/sakila.git
```

2) Startup the database

```shell
$ docker-compose -f compose.yaml up -d
# or (need new version of docker)
$ docker compose -f compose.yaml up -d
```

3) Build and run the JUnit5 tests

```shell
$ ./gradlew clean build
```

4) Startup the application

```shell
$ ./gradlew bootRun
```

5) Access the Swagger UI (check the APIs)

```
http://localhost:8080/sakila/swagger/ui.html
```

6) Stop the database (if need)

```shell
$ docker-compose -f compose.yaml down
# or (need new version of docker)
$ docker compose -f compose.yaml down
```


[1]: https://spring.io
[2]: https://dev.mysql.com/doc/sakila/en

