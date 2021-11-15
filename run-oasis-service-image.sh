docker run -it --name oasis-service -p 8080:8080 \
  -e JDBC_SCHEMA="DB_9B1BAC_dbOasis" \
  -e JDBC_HOST=host.docker.internal \
  -e JDBC_PASSWORD=Password123! \
  -e JDBC_USER=sa \
  -e JDBC_PORT=1433 \
  -e key=HP31F7CL8tfsQG_VfMzu_gDsEy9gqrS8TZSgU75NiwY oasis-service-image:0.4.0-beta