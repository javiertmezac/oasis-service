# oasis-service
Oasis Service

## My Batis Generator
https://mybatis.org/generator/quickstart.html
` java -jar mybatis-generator-core-x.x.x.jar -configfile /resources/mgb.xml -overwrite`
### generate Java Classes
`cd oasis-service-impl`

`mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate`

`mvn -Dmybatis.generator.tableNames=Contactos mybatis-generator:generate`

-Dmybatis.generator.overwrite=true

## docker sql_server
```
docker run -d --name sql_server \
-e 'ACCEPT_EULA=Y' \
-e 'SA_PASSWORD=Password123!' \
-e TZ='America/Tijuana' \
-e 'MSSQL_DATA_DIR=/var/opt/mssql/oasis-data' \
-v ~/localhost/mystuff/oasis/github/oasis-service/oasis-db:/var/opt/mssql/oasis-data \
-p 1433:1433 mcr.microsoft.com/mssql/server:2019-latest
```
> Note: consider reading the backup from volume but restoring to another folder, something owned by mssql user
``` sql 
USE [master]
RESTORE DATABASE [DB_9B1BAC_dbOasis] 
FROM  DISK = N'/var/opt/mssql/oasis-data/SqlDb-OasisServiceV2_dbOasis-20211231-13-1-10.bak' 
WITH  FILE = 1,  MOVE N'SGG_Oasis' TO N'/var/opt/mssql/data/DB_9B1BAC_dbOasis_DATA.mdf',  
MOVE N'SGG_Oasis_log' TO N'/var/opt/mssql/data/DB_9B1BAC_dbOasis_log.ldf',  NOUNLOAD,  STATS = 5
```

### Oasis Service DB
- from version 0.6.1-beta DB was `DBCC CHECKIDENT ('Table_Name', RESEED, 0);`
- bak name: SqlDb-OasisServiceV2_0.6.1-beta.bak
- bak date: Nov 15, 2021

### Store Procedures
For deployment: consider oasis-service-scripts folder...
StoreProcedure NotesList and View_Abono are required for /api/v1/notes

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
