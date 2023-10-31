# Backend
This project is related with [this frontend project](https://github.com/Bernasss12/frontend-angular).

This is the backend code I edned up with for the tutorial video series found [here](https://youtu.be/Gzk4cc8LTQs)

## Setup
To set this up you will need to setup a database and define the connection info in the [`resources/application.properties`](https://github.com/Bernasss12/backend-spring-boot/blob/main/src/main/resources/application.properties) file.
This project was created using a PostgreSQL database but it can be easily adapted to work with some other database types.

### Setup with other databases
In the above mentioned file make sure that you are defining the correct jdbc url for the database you are using.

I haven't tested this but by defining the above url correctly and changing the `pom.xml` file by replacing the PostgresSQL dependency with the want you want everything _should just work™_


This project is technically complete, I have other in mind that use this framework so there's a chance I won't touch this further, but if I do it will most likely to comment code for future reference.
