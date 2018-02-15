CREATE TABLE `tsk_task` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`short_name` VARCHAR(5) NOT NULL,
	`description` TEXT NOT NULL,
	`tsk_status_id` INT(11) NOT NULL,
	`prj_project_id` INT(11) NOT NULL,
	`assigned_to` int(11) not null,
	`expected_start_date` DATE NOT NULL,
	`expected_end_date` DATE NOT NULL,
	`actual_start_date` DATE,
	`actual_end_date` DATE,
	`open_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_date` DATE,
	`created_by` INT(11),
	`update_by` INT(11),
	
	PRIMARY KEY (`id`)
);

CREATE TABLE `tsk_status` (
	`id` INT(11) NOT NULL,
	`description` VARCHAR(50) NOT NULL,
	`archived` CHAR(1) NOT NULL,
	`sortingKey` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tsk_task`
	ADD CONSTRAINT `FK_TSK_STATUS` FOREIGN KEY (`tsk_status_id`) REFERENCES `tsk_status` (`id`);
	
ALTER TABLE `tsk_task`
	ADD CONSTRAINT `FK_TSK_PROJECT` FOREIGN KEY (`prj_project_id`) REFERENCES `prj_project` (`id`);	
	
	

CREATE TABLE `prj_project_history` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`prj_project_id` int(11) NOT NULL,
	`short_name` VARCHAR(5) NOT NULL,
	`description` TEXT NOT NULL,
	`prj_status_id` INT(11) NOT NULL,
	`assigned_to` int(11) not null,
	`expected_start_date` DATE ,
	`expected_end_date` DATE,
	`actual_start_date` DATE ,
	`actual_end_date` DATE,
	`open_date` TIMESTAMP,
	`update_date` DATE ,
	`created_by` INT(11) ,
	`update_by` INT(11) ,
	PRIMARY KEY (`id`)
)	

CREATE TABLE `tsk_task_history` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`tsk_task_id` int(11) not null,
	`short_name` VARCHAR(5) NOT NULL,
	`description` TEXT NOT NULL,
	`tsk_status_id` INT(11) NOT NULL,
	`prj_project_id` INT(11) NOT NULL,
	`assigned_to` int(11) not null,
	`expected_start_date` DATE NOT NULL,
	`expected_end_date` DATE NOT NULL,
	`actual_start_date` DATE,
	`actual_end_date` DATE,
	`open_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`update_date` DATE,
	`created_by` INT(11),
	`update_by` INT(11),
	
	PRIMARY KEY (`id`)
);	
	
	
create table `us_users` (
`id` int(11),
`user_name` varchar(50),
`email` varchar(50),
`password` varchar(50),
`us_status_id` int(11),
`name` varchar(50),
`family_name` varchar(50),
`adress` varchar(200),
`tel` varchar(10),
 url_picture varchar(150)
 
 PRIMARY KEY (`id`)
);
	
	CREATE TABLE `us_status` (
	`id` INT(11) NOT NULL,
	`description` VARCHAR(50) NOT NULL,
	`archived` CHAR(1) NOT NULL,
	`sortingKey` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);
	
ALTER TABLE `us_users`
	ADD CONSTRAINT `FK_US_STATUS` FOREIGN KEY (`us_status_id`) REFERENCES `us_status` (`id`);	

ALTER TABLE `tsk_task` 
    ADD CONSTRAINT `FK_TSK_ASSIGN` FOREIGN KEY (`assigned_to`) REFERENCES `us_users` (`id`);	

ALTER TABLE `prj_project` add `assigned_to` int(11) not null;

ALTER TABLE `prj_project` 
    ADD CONSTRAINT `FK_PRJ_ASSIGN` FOREIGN KEY (`assigned_to`) REFERENCES `us_users` (`id`);		


