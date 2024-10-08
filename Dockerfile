FROM eclipse-temurin:17.0.10_7-jdk

# Install Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY . .

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]