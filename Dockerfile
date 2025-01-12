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
RUN ../bin/shutdown.sh
COPY --from=base /target/myapp.war .
RUN rm -rf myapp
RUN ../bin/startup.sh