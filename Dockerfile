FROM amd64/openjdk:8

MAINTAINER "kelly"

COPY restAPIs-0.0.1-SNAPSHOT.jar /restAPIs-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/restAPIs-0.0.1-SNAPSHOT.jar"]

