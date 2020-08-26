FROM openjdk:8
WORKDIR /home/yetta
COPY ./build/libs /home/yetta
CMD ["java", "-jar", "yetta-0.0.1-SNAPSHOT.jar"]
