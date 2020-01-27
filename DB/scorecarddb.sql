CREATE DATABASE `scorecarddb`;

USE `scorecarddb`;

DROP TABLE IF EXISTS `Accounts`;

CREATE TABLE `Accounts` (
	`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email` varchar(255) NOT NULL UNIQUE,
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

INSERT INTO Holes (course_id, number, par, hint)
VALUES 
(1, 1, 2, "Don't hit this one too hard! Keep your ball to the left and it'll curve back to the hole."),
(1, 2, 2, "Get up the hill!! Hit it hard enough over the hill and aim straight for the hole."),
(1, 3, 2, "Yay, another hill! Aim for the whole with enough strength to get over the hill but don't over shoot!"),
(1, 4, 3, "Okay, go for the front hole and aim lightly. Even if you miss, the second shot isn't difficult."),
(1, 5, 2, "Not sure how this is a par 2... Give it a strong smack and hopefully you get a good roll over that ledge."),
(1, 6, 2, "This is a hard hole to get in one. Aim for under the octopus to try for an ace or lightly tap your shot to the left for an easy 2."),
(1, 7, 2, "Did the cannon ball spray get you? For this one, start at the right of the tee box and aim to the left of the hole. Shoot lightly!"),
(1, 8, 2, "Go for the ridge or go left, either way, if you get a hole in one here YOU GOT LUCKY!"),
(1, 9, 2, "Up the right side, down the left side, back to the hole. A lucky shot gets the hole in one."),
(1, 10, 2, "Go left or go right, each side gets its own hole. Good power and a lucky bounce for the Ace."),
(1, 11, 2, "The hole is protected so a hole in one is almost impossible. Go for 2."),
(1, 12, 3, "We're looking for 2 here. Aim left lightly then your next shot is a bank shot off the right side of the bridge."),
(1, 13, 2, "Go right?"),
(1, 14, 2, "Go right and hope for a good roll or go very lightly directly at the hole. Your choice!"),
(1, 15, 2, "Shoot up the hill with power and aim straight! The hole is directly in the middle up top."),
(1, 16, 2, "So there are some goofy little hills by the hole. Aim off the slanted wall in front of you and hope for a good bounce."),
(1, 17, 3, "Play the hill on the right and the ball should curve towards the hole on the left."),
(1, 18, 2, "Not too hard, not too soft. Good luck!"),
(2, 1, 2, x),
(2, 2, 2, x),
(2, 3, 2, x),
(2, 4, 2, x),
(2, 5, 3, x),
(2, 6, 2, x),
(2, 7, 2, x),
(2, 8, 2, x),
(2, 9, 2, x),
(2, 10, 2, x),
(2, 11, 2, x),
(2, 12, 2, x),
(2, 13, 3, x),
(2, 14, 2, x),
(2, 15, 3, x),
(2, 16, 2, x),
(2, 17, 2, x),
(2, 18, 2, "Not too hard, not too soft. Good luck!");

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
	CONSTRAINT `gs_accounts_fk` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
	CONSTRAINT `gs_games_fk` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`)
);
	
