FROM eclipse-temurin:17
RUN mkdir /opt/app

#COPY target/jvc-0.1.0-SNAPSHOT/jvc-0.1.0-SNAPSHOT /opt/app
COPY target/jvc.jar /opt/app

CMD ["java", "-jar", "/opt/app/jvc.jar"]