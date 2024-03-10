# build
ARG JDK_VERSION=17.0.2

FROM openjdk:${JDK_VERSION}-slim-buster as build
WORKDIR /springboot
COPY . .
RUN ./gradlew build -x test

# deploy
FROM build as deploy
WORKDIR /app
COPY --from=build /springboot/build .
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "libs/forage-0.0.1-SNAPSHOT.jar" ]
