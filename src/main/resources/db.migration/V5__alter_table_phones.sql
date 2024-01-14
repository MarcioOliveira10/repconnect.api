ALTER TABLE `phones`
ADD COLUMN `represented_id` INTEGER;
ALTER TABLE `phones`ADD CONSTRAINT `phones_fk`FOREIGN KEY (`represented_id`) REFERENCES `represented`(`id`);