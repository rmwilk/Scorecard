
DROP DATABASE IF EXISTS `scorecarddb`;
CREATE DATABASE IF NOT EXISTS `scorecarddb`;

USE `scorecarddb`;

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email` varchar(256) NOT NULL UNIQUE,
	`password` varchar(16) NOT NULL,
	`nickname` varchar(32)
);

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(1) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `holes`;

CREATE TABLE `holes` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(255) NOT NULL,
	`course_id` int NOT NULL,
	`number` int 	NOT NULL,
	`par` int NOT NULL,
	`hint` varchar(256) NOT NULL,
	CONSTRAINT `golfholes` UNIQUE (course_id, number),
	CONSTRAINT `h_courses_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
);

DROP TABLE IF EXISTS `games`;

CREATE TABLE `games` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`course_id` int NOT NULL,
	`start_date` TIMESTAMP,
	`end_date` TIMESTAMP,
	CONSTRAINT `g_courses_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
);

DROP TABLE IF EXISTS `game_scores`;

CREATE TABLE `game_scores` (
	`id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,
	`game_id` int,
	`account_id` int,
	`hole_id` int,
	`score` int,
	CONSTRAINT `gs_games_fk` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`),
	CONSTRAINT `gs_accounts_fk` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
	CONSTRAINT `gs_holes_fk` FOREIGN KEY (`hole_id`) REFERENCES `holes` (`id`)
);