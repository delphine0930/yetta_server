docker stop yettaserver
docker rm yettaserver
docker rmi yettaserver
./gradlew bootjar
docker build -f dockerfile -t yettaserver .
docker run -p 8080:8080 --name yettaserver yettaserver

