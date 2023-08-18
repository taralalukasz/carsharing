FROM openjdk:17-oracle
RUN mkdir -p /bin/workspace/
COPY ./target/carsharing-api-0.0.1-SNAPSHOT.jar /bin/workspace/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/bin/workspace/carsharing-api-0.0.1-SNAPSHOT.jar"]
