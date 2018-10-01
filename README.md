# slick-update-returning-example

The example project that adds "updateReturning" method to Query and demonstrates how to use it.

## Prerequisites

PostgreSQL should be available on port 5421, database "postgres", user "postgres", password "secret".

If you have docker, you can run this command to start postgres in docker container:

```
docker run --name some-postgres -e POSTGRES_PASSWORD=secret -p 5421:5432/tcp -d postgres:9.5
```

## How to run

You can run the program with the command:
```
sbt "runMain com.example.updateReturning.Main"
```
