FROM openjdk:17

EXPOSE 9001

ADD /target/g2-spring-api-gateway-service.jar g2-spring-api-gateway-service.jar

ENTRYPOINT [ "java","-jar","/g2-spring-api-gateway-service.jar"]