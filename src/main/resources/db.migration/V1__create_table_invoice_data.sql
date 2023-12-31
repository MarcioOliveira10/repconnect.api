CREATE TABLE `invoice_data`(
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `code` varchar(50),
    `pdf_link` varchar(255),
    `excel_link` varchar(255),
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);