CREATE SCHEMA stc;
USE stc;

------------- 1 ------------------

CREATE TABLE `drivers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`rating` FLOAT DEFAULT 5.5
);


CREATE TABLE `cars_drivers` (
`car_id` INT ,
`driver_id` INT,
CONSTRAINT fk_mapping_drivers
FOREIGN KEY (`driver_id`)
REFERENCES `drivers`(`id`),
CONSTRAINT pk_mapping PRIMARY KEY (`car_id`, `driver_id`)
);


CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`make` VARCHAR(20) NOT NULL,
`model` VARCHAR(20),
`year` INT NOT NULL DEFAULT 0,
`mileage` INT DEFAULT 0,
`condition` CHAR(1) NOT NULL,
`category_id` INT NOT NULL
);

ALTER TABLE `cars_drivers`
ADD
CONSTRAINT fk_mapping_cars
FOREIGN KEY (`car_id`)
REFERENCES `cars`(`id`);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL

);

ALTER TABLE `cars`
ADD
CONSTRAINT fk_cars_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);



CREATE TABLE `courses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`from_address_id`INT NOT NULL,
`start` DATETIME NOT NULL,
`bill` DECIMAL(10,2) DEFAULT 10,
`car_id` INT NOT NULL,
CONSTRAINT fk_courses_cars
FOREIGN KEY (`car_id`)
REFERENCES `cars`(`id`),
`client_id` INT NOT NULL

);



CREATE TABLE `clients` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`full_name`VARCHAR(50) NOT NULL,
`phone_number` VARCHAR(20) NOT NULL
);


ALTER TABLE `courses`
ADD
CONSTRAINT fk_courses_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`);


CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(100) NOT NULL
);

ALTER TABLE `courses`
ADD
CONSTRAINT fk_courses_addresses
FOREIGN KEY (`from_address_id`)
REFERENCES `addresses`(`id`);



------------- 2 ------------------

INSERT INTO `clients`(`full_name`, `phone_number`)
(SELECT 
CONCAT_WS(' ',d.`first_name`, d.`last_name`), 
CONCAT('(088) 9999',d.`id`* 2) AS `phone_number`
FROM `drivers` AS d
WHERE d.`id` BETWEEN 10 AND 20
);


------------- 3 ------------------



UPDATE `cars` AS c 
SET 
    c.`condition` = 'C'
WHERE c.`mileage` >= 800000 OR NULL 
    AND 
    c.`year` <= 2010
    AND 
    c.`make` != 'Mercedes-Benz';
   


------------- 4 ------------------

DELETE FROM `clients`
WHERE 
`id` NOT IN 
(SELECT `client_id` FROM `courses`) 
			AND 
            CHAR_LENGTH(`full_name`) > 3;


------------- 5 ------------------


SELECT c.`make`, c.`model`, c.`condition` FROM `cars` AS c
ORDER BY c.`id`;



------------- 6 ------------------

SELECT 
d.`first_name`, 
d.`last_name`, 
c.`make`, 
c.`model`, 
c.`mileage`  
FROM 
`drivers` AS d
JOIN 
`cars_drivers` AS cd ON d.`id` = cd.`driver_id` 
JOIN 
`cars` AS c ON c.`id` = cd.`car_id`
WHERE 
c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC, d.`first_name` ASC;


------------- 7 ------------------

SELECT 
c.`id`,
c.`make`, 
c.`mileage`, 
count(co.`car_id`) AS `count_of_courses`, 
ROUND(AVG(co.`bill`), 2) AS `avg_bill` 
FROM 
`cars` AS c
LEFT JOIN `courses` AS co ON c.`id` = co.`car_id`
GROUP BY c.`id`
HAVING  `count_of_courses` != 2
ORDER BY `count_of_courses` DESC , c.`id`;


------------- 8 ------------------

SELECT c.`full_name`,
COUNT(co.`car_id`) AS `count_of_cars`,
SUM(co.`bill`) AS `total_sum`
FROM 
`clients` AS c
LEFT JOIN `courses` AS co ON co.`client_id` = c.`id`
LEFT JOIN `cars` AS ca ON ca.`id` = co.`car_id`
GROUP BY c.`id`
HAVING `count_of_cars` > 1 AND
LEFT(`full_name`, 2) LIKE '%a'
ORDER BY `full_name` ASC;



------------- 9 ------------------

SELECT a.`name`,
IF(HOUR(c.`start`) BETWEEN 6 AND 20, 'Day', 'Night') AS `day_time`,
c.`bill`,
cl.`full_name`,
ca.`make`,
ca.`model`,
cat.`name`
FROM 
`courses` AS c
JOIN `addresses` AS a ON a.`id` = c.`from_address_id`
JOIN `clients` AS cl ON c.`client_id` = cl.`id`
JOIN `cars` AS ca ON ca.`id` = c.`car_id`
JOIN `categories` AS cat ON cat.`id` = ca.`category_id`
ORDER BY c.`id`;

------------- 10 ------------------


DELIMITER $$

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN (SELECT 
            COUNT(co.`id`)
        FROM
            `clients` AS cl
                JOIN
            `courses` AS co ON cl.`id` = co.`client_id`
        WHERE
            cl.`phone_number` = phone_num);
END $$

SELECT udf_courses_by_client ('(704) 2502909') as `count`;

















