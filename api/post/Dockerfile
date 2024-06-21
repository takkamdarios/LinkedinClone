FROM maven:3.9.7-amazoncorretto-21  AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests
FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar linkedin-post.jar
CMD ["java", "-jar", "linkedin-post.jar"]
