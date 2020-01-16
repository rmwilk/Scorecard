CREATE DATABASE `scorecarddb`;

USE `scorecarddb`;

DROP TABLE IF EXISTS `Accounts`;

CREATE TABLE `Accounts` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email` varchar(256) NOT NULL UNIQUE,
	`password` varchar(16) NOT NULL,
	`nickname` varchar(32)
);

DROP TABLE IF EXISTS `Courses`;

CREATE TABLE `Courses` (
	`id` int NOT NULL PRIMARY KEY,
	`name` varchar(1) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `Holes`;

CREATE TABLE `Holes` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`course_id` int NOT NULL,
	`number` int 	NOT NULL,
	`par` int NOT NULL,
	`hint` varchar(256) NOT NULL,
	CONSTRAINT `golfholes` UNIQUE (course_id, number),
	CONSTRAINT `h_courses_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
);

DROP TABLE IF EXISTS `Games`;

CREATE TABLE `Games` (
	`id` int NOT NULL PRIMARY KEY,
	`course_id` int NOT NULL,
	`score` int DEFAULT 0,
	`start_date` DATE,
	`start_last` DATE,
	CONSTRAINT `g_courses_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
);

DROP TABLE IF EXISTS `Game_Scores`;

CREATE TABLE `Game_Scores` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`account_id` int,
	`game_id` int,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_1` int DEFAULT 0,
	`hole_10` int DEFAULT 0,
	`hole_11` int DEFAULT 0,
	`hole_12` int DEFAULT 0,
	`hole_13` int DEFAULT 0,
	`hole_14` int DEFAULT 0,
	`hole_15` int DEFAULT 0,
	`hole_16` int DEFAULT 0,
	`hole_17` int DEFAULT 0,
	`hole_18` int DEFAULT 0,
	CONSTRAINT `gs_accounts_fk` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
	CONSTRAINT `gs_games_fk` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`)
);
	
	