FROM openjdk:11 as base
ENV APP_HOME /myapp
WORKDIR $APP_HOME
COPY . $APP_HOME
RUN cd $APP_HOME
RUN chmod u+x mvnw
RUN ./mvnw clean package

FROM tomcat:9
WORKDIR webapps
RUN rm -rf myapp
COPY --from=base /target/myapp.war .