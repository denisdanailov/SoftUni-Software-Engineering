CREATE SCHEMA `sgd`;
USE `sgd`;

------------- 1 -------------------

CREATE TABLE `employees` (

`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`happiness_level` CHAR(1) NOT NULL

);

CREATE TABLE `teams` (

`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`office_id` INT NOT NULL,
`leader_id` INT UNIQUE
);

CREATE TABLE `offices` (

`id` INT PRIMARY KEY AUTO_INCREMENT,
`workspace_capacity` INT NOT NULL,
`website` VARCHAR(50),
`address_id` INT NOT NULL
);


CREATE TABLE `addresses` (

`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL

);

CREATE TABLE `games` (

`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`description` TEXT,
`rating` FLOAT NOT NULL DEFAULT 5.5,
`budget` DECIMAL(10,2) NOT NULL,
`release_date` DATE ,
`team_id` INT NOT NULL
);


CREATE TABLE `games_categories` (

`game_id` INT NOT NULL,
`category_id` INT NOT NULL

);


CREATE TABLE `categories` (

`id` INT  PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL

);

ALTER TABLE `teams`
ADD 
CONSTRAINT fk_teams_offices
FOREIGN KEY (`office_id`)
REFERENCES `offices`(`id`);


ALTER TABLE `teams`
ADD 
CONSTRAINT fk_teams_employees
FOREIGN KEY (`leader_id`)
REFERENCES `employees`(`id`);

ALTER TABLE `games`
ADD 
CONSTRAINT fk_games_teams
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`);

ALTER TABLE `offices`
ADD 
CONSTRAINT fk_offices_adresses
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`);

ALTER TABLE `games_categories`
ADD 
CONSTRAINT fk_mapping_games
FOREIGN KEY (`game_id`)
REFERENCES `games`(`id`);

ALTER TABLE `games_categories`
ADD 
CONSTRAINT fk_mapping_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);


ALTER TABLE `games_categories` 
ADD PRIMARY KEY (`game_id`, `category_id`);
;

------------- 2 -------------------

INSERT INTO `games`(
`name`,
`rating`,
`budget`,
`team_id`)
(SELECT REVERSE(LOWER(SUBSTR(t.`name`, 2))), t.`id`, t.`leader_id` * 1000, t.`id`
FROM `teams` AS t
WHERE t.`id` BETWEEN 1 AND 9);


------------- 3 -------------------

UPDATE `employees` AS e
JOIN `teams` AS t ON e.`id` = t.`leader_id`
SET  e.`salary`= e.`salary` + 1000
WHERE e.`age` <= 40 AND e.`salary` <= 5000;


------------- 4 -------------------


DELETE `games` FROM `games` 
LEFT JOIN `games_categories` ON  games.`id` = games_categories.`game_id`
WHERE 
`category_id` IS NULL AND
`release_date` IS NULL;


------------- 5 -------------------

SELECT `first_name`, `last_name`, `age`, `salary`, `happiness_level` FROM `employees`
ORDER BY `salary`, `id`;


------------- 6 -------------------

SELECT t.`name` AS `team_name`, a.`name` AS `adress_name`, char_length(a.`name`) AS `count_of_characters` FROM `teams` AS t
JOIN `offices` AS o ON t.`office_id` = o.`id`
JOIN `addresses` AS a ON o.`address_id` = a.`id`
WHERE o.`website` IS NOT NULL
ORDER BY `team_name`, `adress_name`;


------------- 7 -------------------

SELECT c.`name`, COUNT(gc.`category_id`) AS `games_count`,
ROUND(AVG(g.`budget`),2) AS `avg_budget`, 
MAX(g.`rating`) AS `max_rating` 
FROM `categories` AS c
JOIN `games_categories` AS gc ON c.`id` = gc.`category_id`
JOIN `games` AS g ON gc.`game_id` = g.`id`
GROUP BY c.`id`
HAVING `max_rating` >= 9.5
ORDER BY `games_count` DESC, c.`name` ASC;



------------- 8 -------------------

SELECT 
g.`name`,
g.`release_date`, 
CONCAT(SUBSTR(g.`description`, 1, 10), '...') AS `summary`, 
(CASE 
	WHEN MONTH(g.`release_date`) IN (1, 2, 3) THEN 'Q1'
	WHEN MONTH(g.`release_date`) IN (4, 5, 6) THEN 'Q2'
	WHEN MONTH(g.`release_date`) IN (7, 8, 9) THEN 'Q3'
	WHEN MONTH(g.`release_date`) IN (10, 11, 12) THEN 'Q4'

END) AS `quater`,
t.`name` AS `team_name`
FROM `games` AS g
JOIN `teams` AS t ON t.`id` = g.`team_id`
WHERE YEAR(`release_date`) = 2022 AND
MONTH(`release_date`) % 2 = 0 AND
g.`name` LIKE '%2' /*  RIGHT(g.`name`, 1) = 2 */ 
ORDER BY `quater`;



------------- 9 -------------------

SELECT g.`name`,
(CASE 
	WHEN g.`budget`< 50000 THEN 'Normal budget'          
	WHEN g.`budget`>= 50000 THEN 'Insufficient budget'
END) AS `budget_level`,
t.`name` AS `team_name`,
a.`name` AS `address_name`
FROM `games` AS g
LEFT JOIN `games_categories` AS gc ON g.`id` = gc.`game_id`
JOIN `teams` AS t ON g.`team_id` = t.`id`
JOIN `offices` AS o ON t.`office_id` = o.`id`
JOIN `addresses` AS a ON o.`address_id` = a.`id`
WHERE g.`release_date` IS NULL AND
gc.`category_id` IS NULL
ORDER BY g.`name`;


------------- 10 -------------------


DELIMITER $$

CREATE FUNCTION `udf_game_info_by_name` (game_name VARCHAR(20))
RETURNS TEXT
DETERMINISTIC
BEGIN
      RETURN (
SELECT CONCAT_WS(' ', 'The',
                     g.`name`, 
                     'is developed by a', 
                     t.`name`, 
                     'in an office with an address',
                     a.`name`
                     )  FROM `games` AS g
JOIN `teams` AS t ON g.`team_id` = t.`id`
JOIN `offices` AS o ON o.`id` = t.`office_id`
JOIN `addresses` AS a ON a.`id` = o.`address_id`
WHERE g.`name` = game_name);
END;
$$


SELECT udf_game_info_by_name('Butwolf') AS info;


------------- 11 -------------------

DELIMITER $$

CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN
UPDATE `games` AS g
    SET 
        `budget` = `budget` + 100000,
        `release_date` = DATE_ADD(`release_date`,
            INTERVAL 1 YEAR)
    WHERE
        g.`id` NOT IN (SELECT `game_id` FROM `games_categories`)
            AND g.`rating` > min_game_rating
            AND g.`release_date` IS NOT NULL;
END $$



CALL udp_update_budget (8);