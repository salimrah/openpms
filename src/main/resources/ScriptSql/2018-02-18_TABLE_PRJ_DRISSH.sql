CREATE TABLE `prj_project` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`short_name` VARCHAR(5) NOT NULL,
	`description` TEXT NOT NULL,
	`prj_status_id` INT(11) NOT NULL,
	`expected_start_date` DATE NOT NULL,
	`expected_end_date` DATE NOT NULL,
	`actual_start_date` ,
	`actual_end_date` ,
	`open_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_date` ,
	`created_by` INT(11),
	`update_by` INT(11),
	PRIMARY KEY (`id`)
);

CREATE TABLE `prj_status` (
	`id` INT(11) NOT NULL,
	`description` VARCHAR(50) NOT NULL,
	`archived` CHAR(1) NOT NULL,
	`sortingKey` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `prj_project`
	ADD CONSTRAINT `FK_STATUS` FOREIGN KEY (`prj_status_id`) REFERENCES `prj_status` (`id`);
	
	


