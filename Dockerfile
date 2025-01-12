FROM openjdk:11 as base
WORKDIR /
COPY . .
RUN apt update
RUN apt install -y maven
RUN mvn -N io.takari:maven:wrapper
RUN chmod u+x mvnw
RUN ./mvnw clean package

FROM tomcat:9
WORKDIR webapps
EXPOSE 8080
RUN rm -rf myapp
COPY --from=base /target/myapp.war .