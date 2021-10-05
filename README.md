# oasis-service
Oasis Service

## My Batis Generator
https://mybatis.org/generator/quickstart.html
` java -jar mybatis-generator-core-x.x.x.jar -configfile /resources/mgb.xml -overwrite`

## docker sql_server
`docker run -d --name sql_server -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Password123!' -p 1433:1433 mcr.microsoft.com/mssql/server:2019-latest`