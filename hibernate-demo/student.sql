create database person;
CREATE TABLE `student` (
  `id` int NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM person.student;