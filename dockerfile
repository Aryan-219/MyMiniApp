FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . /app

EXPOSE 8080

CMD ["java" , "-war","MyMiniApp.war"]

