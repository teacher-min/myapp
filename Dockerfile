FROM openjdk:11 as base
WORKDIR /app
# Dockerfile이 있는 디렉터리(현재 디렉터리) -> WORKDIR
COPY . .
RUN ls -al
RUN chmod u+x mvnw
RUN ./mvnw clean package

FROM tomcat:9
WORKDIR webapps
RUN rm -rf myapp
COPY --from=base /target/myapp.war .