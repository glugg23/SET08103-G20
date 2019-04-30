#!/bin/bash
# Delete all containers
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
# Delete all images
docker rmi $(docker images -q)
