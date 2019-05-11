# SET08103 Group 20

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Release](https://img.shields.io/github/release/glugg23/SET08103-G20.svg)](#)
[![codecov](https://codecov.io/gh/glugg23/SET08103-G20/branch/master/graph/badge.svg)](https://codecov.io/gh/glugg23/SET08103-G20)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/glugg23/SET08103-G20.svg)

#### Master Branch
[![Build Status](https://travis-ci.org/glugg23/SET08103-G20.svg?branch=master)](https://travis-ci.org/glugg23/SET08103-G20)

#### Development Branch
[![Build Status](https://travis-ci.org/glugg23/SET08103-G20.svg?branch=develop)](https://travis-ci.org/glugg23/SET08103-G20)

## Introduction
This is group 20's coursework submission for the SET08103 course at Edinburgh Napier University

## Requirements
- Docker
- Docker Compose
- Maven 4.0.0
- JDK 11.0.2

## Build from source
```
mvn install -DskipTests=true
```

## Run
```
java -jar target/SET08103-G20.jar {ip address}
```

Where {ip address} is the ip address of the SQL server you wish to connect to.

## Features

32 requirements of 32 have been implemented, which is 100%.

| ID  | Name | Met | Screenshot |
|-----|------|-----|------------|
| 1   | All the countries in the world organised by largest population to smallest. | Yes | [Link](img/1.png) |
| 2   | All the countries in a continent organised by largest population to smallest. | Yes | [Link](img/2.png) |
| 3   | All the countries in a region organised by largest population to smallest. | Yes | [Link](img/3.png) |
| 4   | The top `N` populated countries in the world where `N` is provided by the user. | Yes | [Link](img/4.png) |
| 5   | The top `N` populated countries in a continent where `N` is provided by the user. | Yes | [Link](img/5.png) |
| 6   | The top `N` populated countries in a region where `N` is provided by the user. | Yes | [Link](img/6.png) |
| 7   | All the cities in the world organised by largest population to smallest. | Yes | [Link](img/7.png) |
| 8   | All the cities in a continent organised by largest population to smallest. | Yes | [Link](img/8.png) |
| 9   | All the cities in a region organised by largest population to smallest. | Yes | [Link](img/9.png) |
| 10  | All the cities in a country organised by largest population to smallest. | Yes | [Link](img/10.png) |
| 11  | All the cities in a district organised by largest population to smallest. | Yes | [Link](img/11.png) |
| 12  | The top `N` populated cities in the world where `N` is provided by the user. | Yes | [Link](img/12.png) |
| 13  | The top `N` populated cities in a continent where `N` is provided by the user. | Yes | [Link](img/13.png) |
| 14  | The top `N` populated cities in a region where `N` is provided by the user. | Yes | [Link](img/14.png) |
| 15  | The top `N` populated cities in a country where `N` is provided by the user. | Yes | [Link](img/15.png) |
| 16  | The top `N` populated cities in a district where `N` is provided by the user. | Yes | [Link](img/16.png) |
| 17  | All the capital cities in the world organised by largest population to smallest. | Yes | [Link](img/17.png) |
| 18  | All the capital cities in a continent organised by largest population to smallest. | Yes | [Link](img/18.png) |
| 19  | All the capital cities in a region organised by largest to smallest. | Yes | [Link](img/19.png) |Contribution
| 20  | The top `N` populated capital cities in the world  where `N` is provided by the user. | Yes | [Link](img/20.png) |
| 21  | The top `N` populated capital cities in a continent where `N` is provided by the user. | Yes | [Link](img/21.png) |
| 22  | The top `N` populated capital cities in a region where `N` is provided by the user. | Yes | [Link](img/22.png) |
| 23  | The population of people, people living in cities, and people not living in cities in each continent. | Yes | [Link](img/23.png) |
| 24  | The population of people, people living in cities, and people not living in cities in each region. | Yes | [Link](img/24.png) |
| 25  | The population of people, people living in cities, and people not living in cities in each country. | Yes | [Link](img/25.png) |
| 26  | The population of the world. | Yes | [Link](img/26.png) |
| 27  | The population of a continent. | Yes | [Link](img/27.png) |
| 28  | The population of a region. | Yes | [Link](img/28.png) |
| 29  | The population of a country. | Yes | [Link](img/29.png) |
| 30  | The population of a district. | Yes | [Link](img/30.png) |
| 31  | The population of a city. | Yes | [Link](img/31.png) |
| 32  | The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world. | Yes | [Link](img/32.png) |

## Contributions

|                  | #1  | #2  | #3  | #4  | Final | Avg       |
|------------------|-----|-----|-----|-----|-------|-----------|
| Johann Leonhardt | 43% | 23% | 35% | 33% | 27%   | **32.2%** |
| Jacob Barrow     | 20% | 31% | 25% | 22% | 17%   | **23.0%** |
| Toby Cook        | 15% | 26% | 25% | 20% | 33%   | **23.8%** |
| Raish Allan      | 22% | 20% | 15% | 25% | 23%   | **21.0%** |
