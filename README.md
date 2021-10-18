# oasis-service
Oasis Service

## My Batis Generator
https://mybatis.org/generator/quickstart.html
` java -jar mybatis-generator-core-x.x.x.jar -configfile /resources/mgb.xml -overwrite`
### generate Java Classes
`cd oasis-service-impl`

`mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate`

`mvn -Dmybatis.generator.tableNames=Contactos mybatis-generator:generate`

## docker sql_server
`docker run -d --name sql_server -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Password123!' -p 1433:1433 mcr.microsoft.com/mssql/server:2019-latest`

## Build Command
1. `mvn clean package`

2. `docker build -t oasis-service-image .`

3.  run the application
```shell
docker run -it --name oasis-service -p 8080:8080 \
-e JDBC_HOST="host.docker.internal" \
-e JDBC_PORt=1433 \
-e JDBC_SCHEMA="<db_name>" \
-e JDBC_USER=sa \
-e JDBC_PASSWORD=Password1 oasis-service-image
```
