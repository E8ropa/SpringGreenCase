FROM openjdk:22-jdk-alpine


# Install Maven

RUN apk add --no-cache maven


# Set the working directory to /app

WORKDIR /app


# Copy the pom.xml file

COPY pom.xml .


# Download dependencies

RUN mvn dependency:go-offline


# Copy the source code

COPY src/ src/


# Compile the project

RUN mvn package


# Create a new stage for the runtime environment

FROM openjdk:22-jdk-alpine


# Copy the JAR file from the previous stage

COPY --from=0 /app/target/SpringGreenCaseApplication.jar .


# Expose the port

EXPOSE 8080


# Run the application

CMD ["java", "-jar", "SpringGreenCaseApplication.jar"]