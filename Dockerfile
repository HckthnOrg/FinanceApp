FROM maven:3.9.6-eclipse-temurin-22 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:22-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
COPY .env /app/.env
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app/*.jar"]