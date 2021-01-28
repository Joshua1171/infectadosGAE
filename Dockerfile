FROM openjdk:8
VOLUME /tmp
EXPOSE 4000
ADD ./target/back-gae-0.0.1-SNAPSHOT.jar backGAE.jar
ENTRYPOINT ["java","-jar","/backGAE.jar"]
