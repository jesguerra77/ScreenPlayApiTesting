FROM openjdk:8
EXPOSE 61906
ADD target/ApiTesting-1.0-SNAPSHOP.jar ApiTesting-1.0-SNAPSHOP.jar
WORKDIR ApiTesting
ENTRYPOINT["java","-jar","/ApiTesting-1.0-SNAPSHOP.jar"]