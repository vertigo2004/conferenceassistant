CREATE DATABASE `cassistant` CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'conference'@'localhost' IDENTIFIED BY 'assistant';
GRANT ALL ON cassistant.* TO 'conference'@'localhost';
FLUSH PRIVILEGES;
