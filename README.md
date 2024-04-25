# Phoenix Project

This project is the task exercise for skill estimation. This project is built using Java Spring, PostgreSQL as database and includes a Docker Compose file for easy deployment.

## Prerequisites

Before running this project, you need to have Docker Engine and Docker Compose installed on your system.

## Installation

To run this project locally you need to perform these steps:

1) Clone repository

```
git clone https://github.com/Banurr/phoenix
```

2) Navigate to project directory

```
cd phoenix
```

3) Run Docker Compose command to start image pulling , container creation and run

```
sudo docker-compose up -d
```
5) Now when containers running, you can access project at http://localhost:8080

6) To stop containers and delete them you can use

```
sudo docker-compose down
```

## Usage

There several endpoints, only one main endpoint have simple html hello page

GET
```
http://localhost:8080/
```

## UserController

Enpoint for user creation

POST
```
http://localhost:8080/users/register
```

JSON file example

```
{
	"email" : "timur@gmail.com",
	"password" : "bbb",
	"rePassword" : "bbb",
	"fullName" : "Timir",
	"avatar" : "avatar"
} 
```

If user created successfully you will get message with 200 OK response
Otherwise:
if user email already exists, you will get appropriate error message and appplication will throw exception and handle it
if user passwords are not equal , same results as in previous example

## User authentication works with default Spring Security

Endpoint for User login

POST
```
http://localhost:8080/auth
```

For Insomnia use Form URL encoded

name : email  -> your value
name : password  -> your value

In success authentication you will be redirected to simple html hello page

## ApplicationController

Endpoint for Application creation

POST
```
http://localhost:8080/applications
```

JSON file example

```
{
	"title" : "Title1",
	"address" : "Abay 44",
	"quantity" : "100",
	"phone" : "+7701999999"
} 
```

You will see 200 OK response : Application created successfully

Endpoint for retrieving all applications

GET
```
http://localhost:8080/applications
```

You will get list of JSON objects ApplicationView

Endpoint for retrieving applicaton by id, change id on your number

GET
```
http://localhost:8080/applications/id
```

If application with this id exists, you will get single JSON object of ApplicationView
otherwise you will get bad request: Applicaton was not found and exception raised

## NewsController

One single endpoint which will return all News from database

GET
```
http://localhost:8080/news
```
You will get list of JSON objects NewsView
