## Build and Run

    $ mvn package docker:build
    
    $ docker images
    REPOSITORY                              TAG                 IMAGE ID            CREATED              SIZE
    hanisha/person-crud-app   0.0.1-SNAPSHOT                4eedf4811c2d        26 minutes ago      234MB
    java                          openjdk-8-jdk-alpine          3fd9dd82815c        4 years ago      145MB

    $ docker run -p 8080:8080 --name person-ap -t hanisha/person-crud-app:0.0.1-SNAPSHOT

    $ docker ps
    CONTAINER ID        IMAGE                                                  COMMAND                  CREATED             STATUS              PORTS                    NAMES
    83429f3       hanisha/person-crud-app:0.0.1-SNAPSHOT   "java -Djava.security"   25 seconds ago      Up 24 seconds       0.0.0.0:8080->8080/tcp   person-ap

#### mvn package docker:build

This builds the SNAPSHOT Spring Boot jar and wraps it with Docker as specified in the Dockerfile in src/main/docker.

The following configuration includes :${project.version} so that the Maven version number will become the Docker tag and so conceptually the Maven version number and the Docker tag are the same thing.

    <imageName>${docker.image.prefix}/${project.artifactId}:${project.version}</imageName>

#### docker images

This command confirms our expectations in terms of seeing a Docker image with REPOSITORY hanisha/spring-boot-docker-template and TAG 0.0.1-SNAPSHOT. It also confirms a small image size of only 193.9MB.

#### docker run -p 8088:8088 --name person-app -t hanisha/person-crud-app:0.0.1-SNAPSHOT

Here we run the newly minted image and so it becomes a named container with the web app on port 8088.


 Now access all apis at
##### http://localhost:8088/swagger-ui-custom.html

