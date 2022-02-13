CREATE SCHEMA online_store;
USE `online_store`;


CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`phone` VARCHAR(30) NOT NULL UNIQUE,
`address` VARCHAR(60) NOT NULL,
`discount_card` BIT(1) NOT NULL DEFAULT 0
);


CREATE TABLE `orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`order_datetime` DATETIME NOT NULL,
`customer_id` INT NOT NULL
);


ALTER TABLE `orders`
ADD
CONSTRAINT fk_orders_customers
FOREIGN KEY (`customer_id`)
REFERENCES `customers`(`id`);


CREATE TABLE `orders_products`(
`order_id` INT,
CONSTRAINT fk_mapping_orders
FOREIGN KEY (`order_id`)
REFERENCES `orders`(`id`),
`product_id` INT

);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`price` DECIMAL(19,2) NOT NULL,
`quantity_in_stock` INT,
`description` TEXT,
`brand_id` INT NOT NULL,
`category_id` INT NOT NULL,
`review_id` INT

);



CREATE TABLE `reviews`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`content` TEXT,
`rating` DECIMAL(10,2) NOT NULL,
`picture_url` VARCHAR(80) NOT NULL,
`published_at` DATETIME NOT NULL
);


CREATE TABLE `brands`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE

);


CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE

);



ALTER TABLE `products`
ADD
CONSTRAINT fk_products_brands
FOREIGN KEY (`brand_id`)
REFERENCES `brands`(`id`);

ALTER TABLE `products`
ADD
CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);

ALTER TABLE `products`
ADD
CONSTRAINT fk_products_reviews
FOREIGN KEY (`review_id`)
REFERENCES `reviews`(`id`);



ALTER TABLE `orders_products`
ADD
CONSTRAINT fk_orders_products
FOREIGN KEY (`product_id`)
REFERENCES `products`(`id`);

--------------- 2 --------------------

INSERT INTO `reviews`
(`content`, `picture_url`, `published_at`, `rating`)
(SELECT 
LEFT(p.`description`, 15), 
REVERSE(p.`name`),
p.`published_at`,
p.`price` * 8 
 FROM `products` AS p
 WHERE p.`id` >= 5 AND
 DATETIME(p.`published_at`) > '10-10-2010'
);													





--------------- 3 --------------------

UPDATE `products` AS p
SET 
    p.`quantity_in_stock` = `quantity_in_stock` - 5
WHERE p.`quantity_in_stock` >= 60 
    AND 
    p.`quantity_in_stock` <= 70;
    
   
--------------- 4 --------------------

DELETE FROM `customers`
WHERE 
`id` NOT IN 
(SELECT `customer_id` FROM `orders`);
			



--------------- 5 --------------------


SELECT `id`,`name` FROM `categories`
ORDER BY `name` DESC;



--------------- 6 --------------------

SELECT p.`id`,p.`brand_id`, p.`name`, p.`quantity_in_stock` FROM `products` AS p
WHERE p.`price` > 1000 AND p.`quantity_in_stock` < 30
ORDER BY p.`quantity_in_stock`, p.`id`;


--------------- 7 --------------------


SELECT r.`id`, r.`content`, r.`rating`, r.`picture_url`, r.`published_at` FROM `reviews` AS r
WHERE LEFT(r.`content`,2) = 'My' AND
CHAR_LENGTH(r.`content`) > 61
ORDER BY r.`rating` DESC;


--------------- 8 --------------------

SELECT CONCAT(c.`first_name`, ' ', c.`last_name`) AS `full_name`, c.`address`, o.`order_datetime` FROM `customers` AS c
JOIN `orders` AS o ON o.`customer_id` = c.`id`
WHERE YEAR(o.`order_datetime`) <= '2018'
ORDER BY `full_name` DESC;



--------------- 9 --------------------

SELECT count(p.`category_id`) AS `items_count`, c.`name`, sum(p.`quantity_in_stock`) AS `total_quantity` FROM `categories` AS c
JOIN `products` AS p ON p.`category_id` = c.`id`
GROUP BY c.`id`
ORDER BY `items_count` DESC, `total_quantity` ASC
LIMIT 5;


--------------- 10 --------------------


DELIMITER $$

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN (SELECT c.`first_name`, c.`last_name`, count(p.`category_id`) AS `total_products` FROM `customers` AS c
			 JOIN 
            `orders` AS o ON o.`customer_id` = c.`id`
             JOIN 
            `orders_products` AS op ON op.`order_id` = o.`id`
			 JOIN 
            `products` AS p ON op.`product_id` = p.`id`
WHERE c.`first_name` = name
GROUP BY c.`id`);
END $$


--------------- 11 --------------------


DELIMITER $$

CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
UPDATE
`products` AS p
   JOIN `categories` AS c ON c.`id` = p.`category_id`
   JOIN `reviews` AS r ON r.`id` = p.`review_id`
    SET 
        p.`price` = p.`price` * 0.70
        
       WHERE
        c.`name` = category_name
		AND r.`rating` < 4;
   
END $$



CALL udp_reduce_price ('Phones and tablets');















