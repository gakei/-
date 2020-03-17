FROM java:openjdk-8u111-alpine

VOLUME /tmp
ADD gs-spring-boot-0.1.0.jar /noname.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/noname.jar"]