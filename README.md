1)To build the project make sure to have maven installed and added to your PATH environment variable.
2) Open the project folder in cmd and $mvn install (this will run build and tests, you have to wait at least 1 minute, because the get summary test has to wait 1 minute to see if the counter is restarted)
3) To run the server in cmd use $ mvn spring-boot:run