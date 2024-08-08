FROM tomcat:9.0-jdk17-temurin

COPY C:\Tomcat 9.0\webapps\MyMiniApp\MyMiniApp.war

EXPOSE 8080

CMD ["catalina.sh","run"]