FROM maven:3-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21
COPY --from=build /target/fibonacci-0.0.1-SNAPSHOT.jar japp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "japp.jar"]