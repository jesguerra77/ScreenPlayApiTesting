FROM openjdk:8
EXPOSE 8080
ADD target/ApiTesting-1.0-SNAPSHOP.jar ApiTesting-1.0-SNAPSHOP.jar
ENTRYPOINT["java","-jar","/ApiTesting-1.0-SNAPSHOP.jar"]