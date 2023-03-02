# Spring Boot 3 Demo App with native support
SpringBoot 3 and Java Native Playground

## Build and run regular jvm container
```shell
mvn clean package

cd app
docker build . --file src/main/docker/Dockerfile-jvm --tag=spring-native-app-jvm:latest
docker run -p 8080:8080 spring-native-app-jvm:latest
```

## Build and run native container
```shell
mvn -Pnative clean native:compile

cd app
docker build . --file src/main/docker/Dockerfile-native --tag=spring-native-app-native:latest
docker run -p 8080:8080 spring-native-app-native:latest
```



