To run this microservice, you will need:
1. (local) MySQL server
2. Java-compatible IDE like Eclipse
3. (optional) Postman.

First steps:
1. Open the application in your IDE
2. Setup your MySQL connection and database if you haven't already. 
3. Go to application.properties and edit lines 1-3 so they correspond to your MySQL settings
4. Create MySQL database that corresponds with entities in the application. You can do that automatically by uncommenting line 6 in application.properties, and running the application once. Once you do, comment/delete that line, or it will wipe out any existing records in the database upon running. Make sure the port that the application will listen to is empty.
5. Now you can send the POST and GET requests defined in the application. If you use Postman, you can import the possible commands from testrequests.yaml file. Check if the port in Postman (founded in variables part of your collection) corresponds to the port the application is set to use.
