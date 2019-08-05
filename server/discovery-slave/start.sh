docker stop discovery-slave
docker rm discovery-slave
docker run --name discovery-slave -d -p 8762:8762 discovery-slave
