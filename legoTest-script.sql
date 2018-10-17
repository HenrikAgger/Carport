-- There is a schema named "useradmin" with one table: "Users"
-- The test schema is named "useradminTest"
-- make a copy of the table
DROP DATABASE IF EXISTS `legoTest`;
CREATE DATABASE `legoTest`;
USE `legoTest`;
CREATE TABLE legoTest.user LIKE lego.user;
-- make an other copy, this time naming it UsersTest
CREATE TABLE userTest LIKE legoTest.user;
INSERT INTO userTest VALUES 
    (1,'jens@somewhere.com','jensen','customer'),
    (2,'ken@somewhere.com','kensen','customer'),
    (3,'robin@somewhere.com','batman','employee'),
    (4,'someone@nowhere.com','sesam','customer');

-- make a new user for the test database
-- CREATE USER 'testinguser' IDENTIFIED BY 'try1try2tryAgain';
-- GRANT ALL PRIVILEGES ON legoTest.* TO 'testinguser';