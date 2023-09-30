# SpringBoot-JWT-Authentication-Authorization
JWT authentication and authorization implementation in Spring Boot 3.0 application

## [Implementation]() 

- The implementation is about the JWT authentication and authorization in Spring Boot 3.0 application using Spring Security 6 and MySQL database to store user credentials. To secure the application and protect endpoints JSON Web Tokens were used. In the beginning we set the MySQL database and create user table to store user's credentials. Then we configure Spring Security to use JWT and define security rules for application. In the end, we test the application by building simple API and using Postman to send authenticated requests.

<p align="center">
  <img src="https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/8731a18f-7c26-4c88-8cad-3bcf5572674a" alt="Image">
</p>

## Run the Demonstration

- We start the Spring application:

<p align="center">
  <img src="https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/56e236a3-a688-4146-a68e-528b017b0d80" alt="Image">
</p>

- We can see that table was created:

<p align="center">
  <img src="https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/3fc19098-4b17-4fbc-936b-8acedc5224b9" alt="Image">
</p>

- Now we register new user to our Database by sending post request with `Postman` client:

  <img width="1307" alt="image" src="https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/0a81c831-dfd2-43f4-b0c1-8636e7ede355">

- Then we can see that our new user is successfully registered to Database and in fact as we can see password is encoded so that no one except the owner can know the real password:

![image](https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/5097d213-a9c7-4762-a8f4-45eb4a8dda06)

- And on Postman Client side we `Authorization JWT token` as the proof of successful registration to Database:

<img width="1290" alt="image" src="https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/5704153b-b754-4b7c-87a2-3ee2cf3bf335">


## [Troubleshooting](https://stackoverflow.com/questions/39632667/how-do-i-remove-the-process-currently-using-a-port-on-localhost-in-windows)

- Sometimes when we run the Spring application which in default listens to `port:8080` we get the `port in use` error. In this case we open the terminal and check port: 8080 and kill the PID which is listening to port.

<p align="center">
  <img src="https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/40137834-ad6b-4d31-8130-35633ce8d2ca" alt="Image">
</p>

![image](https://github.com/af4092/SpringBoot-JWT-Authentication-Authorization/assets/24220136/52596d27-dd2c-4688-995f-043ca6ec7240)

