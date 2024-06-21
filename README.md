# LinkedIn Clone
>**with Spring Boot & ReactJS**

<p align="center">
<img src="https://github.com/haroldraj/linkedin_clone/blob/main/assets//logo-spring-boot.png" alt="Spring Boot" width="40%" height="40%"/> 
  <img src="https://github.com/haroldraj/linkedin_clone/blob/main/assets//logo-react-js.png" alt="ReactJS" width="40%" height="40%"/> 
</p>

## Used Dependancies

## Features 

### CRUD operation 
- CRUD user
- CRUD post
- CRUD comment

### Pages 

- Home Page :
Displays a list of posts with Author Name, Post Title, and a snippet of the content. It allow navigation to the post's detailed page and the user's profile.
- Post Page : 
Show the details of a single post, including full content, author details, and comments. Navigation to the author's profile is possible.
- New Post Page : 
Allow the user to create a new Post.
- User Profile Page : 
Displays user information, including education, skills, experience, and connections. Offer functionality to edit profile details.

## Prerequisites

- Docker
- Docker Compose

## Dockerized the Applications

### Database

MariaDB is used as the database for the application. We have a `Dockerfile` in the `db` directory which is used to build a Docker image of the MariaDB database.

### API

The address of the API is `http://localhost:8080/api` when running in Docker.

### Web
We used ReactJS for the frontend. We have a `Dockerfile` in the `web` directory which is used to build a Docker image of the Web. 
The address of the web application is `http://localhost:3002` when running in Docker.

## Start the Application

To start the applications, in the root directory of the project, run the following command:

```bash
#Just run the following command to run the project
docker-compose up --build

```


