FROM amazoncorretto:17.0.9
EXPOSE 8081
ADD target/springboot-kafa-docker.jar springboot-kafa-docker.jar
ENTRYPOINT ["java","-jar","springboot-kafa-docker.jar"]