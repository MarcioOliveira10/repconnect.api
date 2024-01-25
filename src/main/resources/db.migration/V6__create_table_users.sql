CREATE TABLE `users`(
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `name` VARCHAR(100),
    `email` VARCHAR(100),
    `password` VARCHAR(50),
    `phone_id` INT UNIQUE,
    `address_id` INT UNIQUE,
    `type_of_user` VARCHAR(20),
    `activation_key` VARCHAR(100),
    `remember_token` VARCHAR(100),
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
);