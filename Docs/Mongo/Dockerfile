FROM ubuntu:18.04

LABEL Antonio Ceere 

RUN apt-get update && apt-get install -y mongodb && apt-get install nano

# Create the MongoDB data directory
RUN mkdir -p /data/db

# Expose port 37017 (default 27017) from the container to the host
EXPOSE 37017

#Start MongoDb
CMD ["mongod", "-f", "/etc/mongodb.conf"]



