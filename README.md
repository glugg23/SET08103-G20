[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Release](https://img.shields.io/github/release/glugg23/SET08103-G20.svg)](#)
![](https://img.shields.io/github/languages/code-size/glugg23/SET08103-G20.svg?style=flat)
# SET08103 Group 20
#### Development Branch
[![Build Status](https://travis-ci.org/glugg23/SET08103-G20.svg?branch=develop)](https://travis-ci.org/glugg23/SET08103-G20)
#### Master Branch
[![Build Status](https://travis-ci.org/glugg23/SET08103-G20.svg?branch=master)](https://travis-ci.org/glugg23/SET08103-G20)

## Introduction
This is group 20's coursework submission for the SET08103 course at Edinburgh Napier University

## Requirements
- Docker
- Docker Compose
- Maven 4.0.0
- JDK 11.0.2


## Build from source
```
mvn install
docker-compose up --build --abort-on-container-exit
```

## Run
```
java -jar target/SET08103-G20-X-X-X-jar-with-dependencies.jar
```
where `X-X-X` is the version number
