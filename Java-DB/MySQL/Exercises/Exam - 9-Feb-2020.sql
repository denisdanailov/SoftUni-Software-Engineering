---------------------- CREATE 1 ------------------------

CREATE SCHEMA fsd;

USE fsd;

CREATE TABLE `countries` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL
);

ALTER TABLE `countries` 
CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL ;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`country_id` INT NOT NULL,
CONSTRAINT fk_towns_countries
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)

);

CREATE TABLE `stadiums` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`capacity` INT NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_stadiums_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)

);

CREATE TABLE `teams` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT NOT NULL DEFAULT 0,
`stadium_id` INT NOT NULL,
CONSTRAINT fk_teams_stadiums
FOREIGN KEY (`stadium_id`)
REFERENCES `stadiums`(`id`)

);


CREATE TABLE `coaches` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`coach_level` INT NOT NULL DEFAULT 0

);

CREATE TABLE `players` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL DEFAULT 0,
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`hire_date` DATETIME,
`skills_data_id` INT,
`team_id` INT
);

CREATE TABLE `players_coaches` (
`player_id` INT,
CONSTRAINT fk_players_coaches_players
FOREIGN KEY (`player_id`)
REFERENCES `players`(`id`),
`coach_id` INT,
CONSTRAINT fk_players_coaches_coaches
FOREIGN KEY (`coach_id`)
REFERENCES `coaches`(`id`),
CONSTRAINT pk_mapping PRIMARY KEY (`player_id`, `coach_id`)
);

CREATE TABLE `skills_data` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`dribbling` INT DEFAULT 0,
`pace` INT DEFAULT 0,
`passing` INT DEFAULT 0,
`shooting` INT DEFAULT 0,
`speed` INT DEFAULT 0,
`strength` INT DEFAULT 0

);

ALTER TABLE `players`
ADD
CONSTRAINT fk_players_skills_data
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data`(`id`);

ALTER TABLE `players`
ADD
CONSTRAINT fk_players_teams
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`);


---------------------- INSERT 2 ------------------------


INSERT INTO `coaches` 
(`first_name`, `last_name`, `salary`, `coach_level`)
( SELECT `first_name`, `last_name`, `salary` * 2, character_length(`first_name`) AS`coach_level` FROM `players` WHERE `age` >= 45);


---------------------- UPDATE 3 ------------------------


UPDATE `coaches` AS c
JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
SET `coach_level` = `coach_level` + 1
WHERE pc.`player_id` > 0 AND
c.`first_name` LIKE 'A%';


UPDATE `coaches`
SET `coach_level` = `coach_level` + 1
WHERE `first_name` LIKE 'A%'
AND `id` IN (SELECT `coach_id` FROM `players_coaches`);


---------------------- DELETE 4 ------------------------

DELETE FROM `players`
WHERE `age` >= 45;



----------------------  5 ------------------------

SELECT  `first_name`, `age`, `salary` FROM `players`
ORDER BY `salary` DESC;




----------------------  6 ------------------------

SELECT p.`id`, concat_ws(' ',`first_name`, `last_name`) AS `full_name`, `age`, `position`, `hire_date`
FROM `players` AS p
JOIN `skills_data` As sd
ON sd.`id` = p.`skills_data_id`
WHERE 
sd.`strength` > 50 
AND p.`age` < 23 
AND p.`position` = 'A'
AND p.`hire_date` IS NULL
ORDER BY `salary` ASC, `age`ASC;



---------------------- 7 ------------------------


SELECT t.`name` AS `team_name`, t.`established`, t.`fan_base`,
 (SELECT COUNT(*) FROM `players`
 WHERE `team_id`= t.`id`
 )AS `players_count` FROM `teams` AS t
 ORDER BY `players_count` DESC, `fan_base` DESC;

---------------------- 8 ------------------------

SELECT max(sd.`speed`) AS `max_speed`, t.`name` FROM `players` AS p
JOIN `skills_data` AS sd
ON p.`skills_data_id` = sd.`id`
RIGHT JOIN `teams` AS tm
ON p.`team_id` = tm.`id`
JOIN `stadiums` as s
ON tm.`stadium_id` = s.`id`
JOIN `towns` AS t
ON t.`id` = s.`town_id`
GROUP BY t.`name`
HAVING t.`name` != 'Devify'
ORDER BY `max_speed` DESC, t.`name`;


---------------------- 9 ------------------------



SELECT c.`name`, count(p.`id`) AS `total_count_of_players`, sum(p.`salary`) AS `total_sum_of_salaries` FROM `players` AS p
RIGHT JOIN `teams` AS team
ON team.`id` = p.`team_id`
RIGHT JOIN `stadiums` AS stadium
ON  stadium.`id` = team.`stadium_id`
RIGHT JOIN `towns` AS town
ON town.`id` = stadium.`town_id`
RIGHT JOIN `countries` AS c
ON c.`id` = town.`country_id`
GROUP BY c.`id`
ORDER BY `total_count_of_players` DESC, c.`name` ASC;



---------------------- 10 ------------------------
DELIMITER $$

CREATE FUNCTION `udf_stadium_players_count` (stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
      RETURN (
SELECT count(*) AS `count` FROM `players` AS p
JOIN `teams` AS t
ON t.`id` = p.`team_id`
JOIN `stadiums` as s
ON s.`id` = t.`stadium_id`
WHERE s.`name` = stadium_name);

END;
$$

---------------------- 11 ------------------------

DELIMITER $$
CREATE PROCEDURE `udp_find_playmaker` (min_points INT, team_name VARCHAR(45))
BEGIN

SELECT CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`, p.`age`, p.`salary`, s.`dribbling`, s.`speed`, t.`name` AS `team_name` FROM `players` AS p
RIGHT JOIN `skills_data` AS s
ON p.`skills_data_id` = s.`id`
RIGHT JOIN `teams` AS t
ON p.`team_id` = t.`id`
WHERE s.`dribbling` > min_points 
AND t.`name` = team_name 
AND s.`speed`> (SELECT AVG(`speed`) FROM `skills_data`)
ORDER BY s.`speed` DESC
LIMIT 1;

END
$$


CALL udp_find_playmaker(20, 'Skyble');






Error Code: 1054. Unknown column '‘Skyble’' in 'field list'



