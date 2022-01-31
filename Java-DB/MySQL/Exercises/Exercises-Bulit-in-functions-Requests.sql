/*-------------------------------------- LAB Built-in Functions-----------------------------------------*/

USE `book_library`;

/* Ex.1 */

SELECT `title` FROM `books`
WHERE substring(`title`, 1, 3) = "The";

/* Ex.2 */


SELECT replace(`title`, "The", "***") 
AS "title" FROM `books`
WHERE substring(`title`, 1, 3) = "The";

/* Ex.3 */

SELECT round( SUM( `cost`), 2)
FROM `books`;


/* Ex.4 */

SELECT concat(`first_name`,' ', `last_name`) 
AS "Full Name",
TIMESTAMPDIFF(day, born, died) 
AS "Days Lived"
FROM `authors`;

/* Ex.5 */

SELECT `title` FROM `books`
WHERE substring(`title`, 1, 5) = "Harry";

/*-------------------------------------- Exercise Built-in Functions-----------------------------------------*/


/* Ex.1 */

USE `soft_uni`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE substring(`first_name`, 1, 2) = "Sa";

/* Ex.2 */

SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE "%ei%";

/* Ex.3 */

SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10) AND
YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;


/* Ex.4 */

SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title`  NOT LIKE '%engineer%'
ORDER BY `employee_id`;

/* Ex.5 */

SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5,6)
ORDER BY `name` ASC;

/* Ex.6 */

SELECT  `town_id`,`name`FROM `towns`
WHERE LEFT(`name`,1) IN ('M','K','B','E')
ORDER BY `name` ;

/* Ex.7 */

SELECT  `town_id`,`name`FROM `towns`
WHERE LEFT(`name`,1) NOT LIKE 'R' AND LEFT(`name`,1) NOT LIKE 'B' AND LEFT(`name`,1) NOT LIKE 'D'
ORDER BY `name`;

/* Ex.8 */

CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

/* Ex.9 */

SELECT `first_name`, `last_name` 
FROM `employees`
WHERE char_length(`last_name`) = 5;

/* Ex.10 */

USE `geography`;

SELECT `country_name`, `iso_code` 
FROM `countries`
WHERE `country_name` LIKE '%A%A%A%'
ORDER BY `iso_code`;

/* Ex.11 */

SELECT 
`peak_name`,
`river_name`,
lower(concat(`peak_name`, substring(`river_name`,2))) AS 'mix'
FROM 
`peaks`,
`rivers`
WHERE 
right(`peak_name`,1) = left(`river_name`,1) 
ORDER BY `mix`;

/* Ex.12 */

USE `diablo`;

SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d')
FROM
    `games`
WHERE
    YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start`
LIMIT 50;

/* Ex.13 */

SELECT 
    `user_name`,
    SUBSTRING(`email`,
        LOCATE('@', `email`) + 1) AS 'email_provider'
FROM
    `users`
ORDER BY `email_provider` , `user_name`;

/* Ex.14 */


SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;


/* Ex.15 */

SELECT 
    `name`,
    (CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END) AS 'Parts of the day',
     (CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` > 3 AND `duration` <= 6 THEN 'Short'
        WHEN `duration` > 6 AND `duration` <= 10 THEN  'Long'
        ELSE 'Extra Long'
    END) AS 'Duration'
FROM
    `games`;
    
    
/* Ex.16 */

USE `orders`;

SELECT `product_name`, `order_date`, date_add(`order_date`, INTERVAL 3 DAY) AS 'pay_due', 
date_add(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM `orders`









