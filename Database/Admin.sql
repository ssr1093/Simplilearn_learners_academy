CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  `name` varchar(11) NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `section` int(55) NOT NULL,
  `teacher` varchar(124) NOT NULL,
  `subject` varchar(124) NOT NULL,
  `time` varchar(44) NOT NULL,
  PRIMARY KEY (`id`),
  )
  
  CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(55) NOT NULL,
  `lname` varchar(55) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `class` int(11) NOT NULL,
   PRIMARY KEY (id)  
) 

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `shortcut` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
)

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(55) NOT NULL,
  `lname` varchar(55) NOT NULL,
  `age` varchar(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
) 
