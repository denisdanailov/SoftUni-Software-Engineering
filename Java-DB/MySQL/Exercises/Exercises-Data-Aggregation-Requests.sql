USE `restaurant`;


/*-------------------------------------- LAB Data Aggregation -----------------------------------------*/


/* Ex.1 */

SELECT `department_id`, count(`department_id`) AS 'Number of employees' FROM `employees`
GROUP BY `department_id`;

/* Ex.2 */

SELECT `department_id`, round(avg(`salary`),2) AS 'Average Salary' FROM `employees`
GROUP BY `department_id`;

/* Ex.3 */

SELECT `department_id`, round(min(`salary`),2)  AS 'Min Salary'  FROM `employees`
GROUP BY `department_id`
HAVING 
min(`salary`) > 800
ORDER BY min(`salary`);

/* Ex.4 */

SELECT `id`  FROM `products`
WHERE `price` > 8 AND `id` = 2
GROUP BY `id`;

/* Ex.4 */

SELECT `category_id`, 
round(avg(`price`),2) AS 'Average Price',
round(min(`price`),2) AS 'Cheapest Product',
round(max(`price`),2) AS 'Most Expensive Product'
FROM `products`
GROUP BY `category_id`;

/*-------------------------------------- Exercise Data Aggregation -----------------------------------------*/

/* Ex.1 */

USE `gringotts`;

SELECT count(`id`) AS 'count' FROM `wizzard_deposits`;

/* Ex.2 */

SELECT max(`magic_wand_size`) AS 'longest_magic_wand' FROM `wizzard_deposits`;

/* Ex.3 */

SELECT `deposit_group`, max(`magic_wand_size`) AS 'longest_magic_wand' FROM `wizzard_deposits`
GROUP BY `deposit_group` 
ORDER BY `longest_magic_wand` ASC, 
`deposit_group` ASC;

/* Ex.4 */

SELECT `deposit_group` FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY avg(`magic_wand_size`)
LIMIT 1;

/* Ex.5 */

SELECT `deposit_group`, sum(`deposit_amount`) AS 'total_sum' FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum` ASC;

/* Ex.6 */

SELECT `deposit_group`, sum(`deposit_amount`) AS 'total_sum' FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;

/* Ex.7 */

SELECT `deposit_group`, sum(`deposit_amount`)  AS 'total_sum' FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family' 
GROUP BY `deposit_group`
HAVING `total_sum`< 150000
ORDER BY `total_sum` DESC;

/* Ex.8 */

SELECT `deposit_group`, `magic_wand_creator`, min(`deposit_charge`)
 AS 'min_deposit_charge' 
 FROM `wizzard_deposits`
 GROUP BY `deposit_group`, `magic_wand_creator`
 ORDER BY `magic_wand_creator`, `deposit_group`  ASC;
 
/* Ex.9 */

SELECT 
(CASE
WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
ELSE '[61+]'
END) AS 'age_group',
COUNT(*) AS `wiz_count`
FROM 
`wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;

/* Ex.10 */

SELECT LEFT(`first_name`,1) AS 'f_letters' FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `f_letters` 
ORDER BY `f_letters` ASC;


/* Ex.11 */

SELECT `deposit_group`, `is_deposit_expired`, AVG(`deposit_interest`) AS 'average_interest' FROM `wizzard_deposits`
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY `is_deposit_expired`, `deposit_group`
ORDER BY `deposit_group` DESC, `is_deposit_expired` ASC;


/* Ex.12 */

USE `soft_uni`;

SELECT `department_id`, min(`salary`) AS 'minimum_salary' FROM `employees`
WHERE `department_id` IN (2,5,7) AND YEAR(`hire_date`) >= 2000
GROUP BY `department_id`
ORDER BY `department_id` ASC; 


/* Ex.13 */

CREATE TABLE `hpe` AS
SELECT * FROM `employees`
WHERE `salary` > 30000;

UPDATE `hpe`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

DELETE `hpe` FROM `hpe`
WHERE `manager_id` = 42;

SELECT `department_id`, AVG(`salary`) AS `avg_salary` 
FROM `hpe`
GROUP BY `department_id`
ORDER BY `department_id`;

/* Ex.14 */


SELECT `department_id`,  max(`salary`) AS `max_salary`
FROM `employees`
GROUP BY `department_id`
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY `department_id` ASC;



/* Ex.15*/

SELECT count(`salary`)
FROM `employees`
WHERE `manager_id` IS NULL;



/* Ex.16 */


SELECT `department_id` FROM `employees`
GROUP BY `department_id`; 

/* Ex.17 */

SELECT e.`first_name`, e.`last_name`, e.`department_id`
FROM `employees` AS e
WHERE e.`salary` > (
	SELECT avg(e2.`salary`)
    FROM `employees` AS e2
    WHERE e2.`department_id` = e.`department_id`

)
ORDER BY `department_id`, `employee_id`
LIMIT 10;

/* Ex.18 */

SELECT `department_id`, SUM(`salary`) AS `total_salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`




