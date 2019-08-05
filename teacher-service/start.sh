docker stop teacher-service
docker rm teacher-service
docker run --name teacher-service -d -p 605:605 discovery-slave
