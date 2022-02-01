USE `soft_uni`;

/* Ex.1 */


SELECT 
    e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'full_name',
    d.`department_id`,
    d.`name`
FROM
    `employees` AS e
        RIGHT JOIN
    `departments` AS d ON d.`manager_id` = e.`employee_id`
ORDER BY e.`employee_id`
LIMIT 5;

/* Ex.2 */


SELECT 
    t.`town_id`, t.`name` AS 'town_name', a.`address_text`
FROM
    `towns` AS t
        LEFT JOIN
    `addresses` AS a ON t.`town_id` = a.`town_id`
WHERE
    `name` = 'San Francisco'
        OR `name` = 'Sofia'
        OR `name` = 'Sofia'
        OR `name` = 'Carnation'
ORDER BY `town_id` , `address_id`;

/* Ex.3 */


SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`last_name`,
    d.`department_id`,
    e.`salary`
FROM
    `employees` AS e
        RIGHT JOIN
    `departments` AS d ON e.`employee_id` = d.`manager_id`
WHERE
    `manager_id` IS NULL;


----------------- Exercises Joins, Subqueries and Indices --------------------------

/* Ex.1 */

USE `soft_uni`;

SELECT 
    e.`employee_id`,
    e.`job_title`,
    a.`address_id`,
    a.`address_text`
FROM
    `employees` AS e
        JOIN
    `addresses` AS a ON e.`address_id` = a.`address_id`
ORDER BY `address_id` ASC
LIMIT 5;


/* Ex.2 */

SELECT 
    e.`first_name`, e.`last_name`, t.`name`, a.`address_text`
FROM
    `employees` AS e
        JOIN
    `addresses` AS a ON e.`address_id` = a.`address_id`
        JOIN
    `towns` AS t ON a.`town_id` = t.`town_id`
ORDER BY `first_name` , `last_name` ASC
LIMIT 5;

/* Ex.3 */

SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`last_name`,
    d.`name` AS 'department_name'
FROM
    `employees` AS e
        JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
WHERE
    d.`name` = 'Sales'
ORDER BY `employee_id` DESC;
    

/* Ex.4 */

SELECT 
    e.`employee_id`, e.`first_name`, e.`salary`, d.`name`
FROM
    `employees` AS e
        JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
WHERE
    e.`salary` > 15000
ORDER BY e.`department_id` DESC
LIMIT 5;
   

/* Ex.5 */

SELECT 
    e.`employee_id`, e.`first_name`
FROM
    `employees` AS e
        LEFT JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
WHERE
    ep.`project_id` IS NULL
ORDER BY `employee_id` DESC
LIMIT 3;
    
/* Ex.6 */


SELECT 
    e.`first_name`,
    e.`last_name`,
    e.`hire_date`,
    d.`name` AS 'dept_name'
FROM
    `employees` AS e
        JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
WHERE
    DATE(e.`hire_date`) > '1999-01-01'
        AND `name` = 'Sales'
        OR `name` = 'Finance'
ORDER BY `hire_date` ASC;


/* Ex.7 */

SELECT 
    e.`employee_id`, e.`first_name`, p.`name` AS 'project_name'
FROM
    `employees` AS e
        JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        JOIN
    `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE
    DATE(p.`start_date`) > '2002-08-13'
        AND p.`end_date` IS NULL
ORDER BY e.`first_name` , p.`name`
LIMIT 5;
    
    /* Ex.8 */


SELECT 
    e.`employee_id`,
    e.`first_name`,
    IF(YEAR(p.`start_date`) > 2004,
        NULL,
        p.`name`)
FROM
    `employees` AS e
        JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        JOIN
    `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE
    e.`employee_id` = 24
ORDER BY p.`name`;


    /* Ex.9 */
 SELECT 
    e.`employee_id`,
    e.`first_name`,
    e.`manager_id`,
    emp.`first_name` AS 'manager_name'
FROM
    `employees` AS e
        JOIN
    `employees` AS emp ON emp.`employee_id` = e.`manager_id`
WHERE
    e.`manager_id` IN (3 , 7)
ORDER BY e.`first_name`;
    
   

    
      /* Ex.10 */
    
  SELECT 
    e.`employee_id`,
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'employee_name',
    CONCAT_WS(' ', m.`first_name`, m.`last_name`) AS 'manager_name',
    d.`name`
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON e.`manager_id` = m.`employee_id`
        JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;

   /* Ex.10 */
   
SELECT 
    AVG(`salary`) AS `min_average_salary`
FROM
    `employees`
GROUP BY `department_id`
ORDER BY `min_average_salary`
LIMIT 1;

