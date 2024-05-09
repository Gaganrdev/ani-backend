# ANI BACKEND

### Steps to run the project in Amazon EC2 Instance

- SSH Login to the EC2 instance``ssh -i <key> ec2-user@<public-ip-address>``
- Run ``mvn package`` to generate the jar. It will be generated under target folder.
- Copy the generated jar``scp -i <key> backend-0.0.1-SNAPSHOT.jar ec2-user@<public-ip-address>:/home/ec2-user``
- Go to /home/ec2-user and run the command
``java -jar backend-0.0.1-SNAPSHOT.jar``
- Check by accessing the http://<public-ip-address>:8080/actuator/health

Swagger Link - http://ec2-54-163-201-84.compute-1.amazonaws.com:8080/swagger-ui/index.html#/