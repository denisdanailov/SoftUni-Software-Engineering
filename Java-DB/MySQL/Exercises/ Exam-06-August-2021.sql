CREATE SCHEMA `instd`;
USE `instd`;

CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT fk_addresses_users
FOREIGN KEY (`user_id`)
REFERENCES users(`id`)
);

CREATE TABLE `photos`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL,
`views` INT NOT NULL DEFAULT 0
);

CREATE TABLE `comments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_comments_photos
FOREIGN KEY (`photo_id`)
REFERENCES photos(`id`)
);

CREATE TABLE `users_photos`(
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_users_photos_users
FOREIGN KEY (`user_id`)
REFERENCES users(`id`),
CONSTRAINT fk_users_photos_photos
FOREIGN KEY (`photo_id`)
REFERENCES photos(`id`)
);

CREATE TABLE `likes`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`photo_id` INT,
`user_id` INT,
CONSTRAINT fk_likes_photos
FOREIGN KEY (`photo_id`)
REFERENCES photos(`id`),
CONSTRAINT fk_likes_users
FOREIGN KEY (`user_id`)
REFERENCES users(`id`)
);

------------------ 2 --------------------

INSERT INTO `addresses`
(`address`, `town`, `country`, `user_id`)
(SELECT u.`username`, u.`password`, u.`ip`, u.`age` FROM `users` AS u
WHERE u.gender = 'M'
);


------------------ 3 --------------------


UPDATE `addresses` AS a 
SET 
    a.`country` = CASE
        WHEN `country` LIKE 'B%' THEN 'Blocked'
        WHEN `country` LIKE 'T%' THEN 'Test'
        WHEN `country` LIKE 'P%' THEN 'In Progress'
        ELSE a.`country`
    END;



------------------ 4 --------------------

DELETE FROM `addresses` AS a
WHERE a.`id` % 3 = 0;



------------------ 5 --------------------


SELECT u.`username`, u.`gender`, u.`age` FROM `users` AS u
ORDER BY u.`age` DESC, u.`username` ASC;



------------------ 6 --------------------


SELECT 
    p.`id`,
    p.`date`,
    p.`description`,
    COUNT(c.`id`) AS `comments_count`
FROM
    `photos` AS p
        JOIN
    `comments` AS c ON p.`id` = c.`photo_id`
GROUP BY p.`id`
ORDER BY `comments_count` DESC , p.`id`
LIMIT 5;

------------------ 7 --------------------


SELECT 
    CONCAT_WS('', u.`id`, u.`username`) AS `id_username`,
    u.`email`
FROM
    `users` AS u
        JOIN
    `users_photos` AS up ON u.`id` = up.`user_id`
        JOIN
    `photos` AS p ON up.`photo_id` = p.`id`
WHERE
    u.`id` = p.`id`
ORDER BY u.`id` ASC;


------------------ 8 --------------------

SELECT 
    p.`id` AS `photo_id`,
    COUNT(DISTINCT l.`id`) AS `likes_count`,
    COUNT(DISTINCT c.`id`) AS `comments_count`
FROM
    `photos` AS p
        LEFT JOIN
    `likes` AS l ON p.`id` = l.`photo_id`
        LEFT JOIN
    `comments` AS c ON p.`id` = c.`photo_id`
GROUP BY p.`id`
ORDER BY `likes_count` DESC , `comments_count` DESC , p.`id` ASC;


------------------ 9 --------------------



SELECT CONCAT(LEFT(p.`description`, 30), '...' )AS `summary`, `date` FROM `photos` AS p
WHERE DAY(p.`date`) = 10
ORDER BY p.`date` DESC;



------------------ 10 --------------------
DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN ( SELECT count(p.`id`) FROM `photos` AS p
JOIN `users_photos` AS up ON p.`id` = up.`photo_id`
JOIN `users` AS u ON u.`id` = up.`user_id`
WHERE u.`username` = username);
END;
$$


------------------ 11 --------------------


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















