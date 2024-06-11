  FROM openjdk:17

  ARG VERSION

  COPY target/myapp.war /app/myapp.war

  LABEL maintainer="GyeongTae Min<minkt78@naver.com>" \
        title="My Application" \
        version="$VERSION" \
        description="This image is myapp service"

  EXPOSE 8080

  ENV APP_HOME /app

  VOLUME $APP_HOME/upload
  VOLUME $APP_HOME/blog

  WORKDIR $APP_HOME

  ENTRYPOINT ["java"]
  CMD ["-jar", "myapp.war"]