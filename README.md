# crudUsers
Test task #1 JavaRush: web-application lists the users from the database.

To run:
1. SDK 1.7 is required, MySQL.
2. After project import (Maven) configure connection to your MySQL db in ApplicationContextConfig
3. Sql scripts for table creation, sample data import, delete are placed under resources/.
4. Run Maven task 'install' to generate war file.
3. Standard run configuration of Tomcat 7 is sufficient to run the *.war (http://localhost:8080/).

Functionality:
1. Display the list of all users from "User" table.
2. New Users can be added.
3. Users are editable and can be deleted.



