CREATE TABLE `represented` (
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `name` VARCHAR(100),
    `web_site` VARCHAR(255),
    `email` VARCHAR(100),
    `phone_id` INT UNIQUE,
    `address_id` INT UNIQUE,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);
ALTER TABLE `represented` ADD CONSTRAINT `represented_fk_phone` FOREIGN KEY (`phone_id`) REFERENCES `phones`(`id`);
ALTER TABLE `represented` ADD CONSTRAINT `represented_fk_address` FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`);