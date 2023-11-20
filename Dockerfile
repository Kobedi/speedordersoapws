FROM openjdk:17
MAINTAINER zadscience.com
COPY target/speed-order-1.0.0.jar speed-order-1.0.0.jar
ENTRYPOINT ["java","-jar","/speed-order-1.0.0.jar"]