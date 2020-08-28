--liquibase formatted sql

--changeset BaseSchema:1
CREATE TABLE `lead_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` enum('USER','SELF','ADMIN') DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL COMMENT 'Organization ID',
  `is_head_user` tinyint(1) NOT NULL DEFAULT '0',
  `user_name` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `domain_url` varchar(300) DEFAULT NULL,
  `domain_id` bigint(20) DEFAULT NULL,
  `project_name` varchar(300) DEFAULT NULL,
  `project_id` bigint(14) DEFAULT NULL,
  `project_info` varchar(300) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `alternate_mobile_number` bigint(20) DEFAULT NULL, 
  `country_id` int(10) default null,
  `state_id` int(10) default null,
   `status` enum('ACTIVE','INACTIVE') DEFAULT NULL,
  `is_user_validation_required` int(1) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  unique(`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `country` (
  `id` bigint(20) NOT NULL,
  `country_name` varchar(200) default null,
  `state_id` varchar(200) default null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `state` (
  `id` bigint(20) NOT NULL,
  `state_name` varchar(200) default null,
  `distict_id` varchar(200) default null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `district` (
  `id` bigint(20) NOT NULL,
  `dist_name` varchar(200) default null,
  `tahseel_id` varchar(200) default null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE `tahseel` (
  `id` bigint(20) NOT NULL,
  `tah_name` varchar(200) default null,
  `vill_id` varchar(200) default null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `village` (
  `id` bigint(20) NOT NULL,
  `vill_name` varchar(200) default null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE lead_users ADD project_url VARCHAR( 255 ) after project_info;
ALTER TABLE lead_users ADD project_lat float after project_url;
ALTER TABLE lead_users ADD project_long float after project_lat;


CREATE TABLE `lead_freelance_work` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(400),
  `user_name` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `work_type` enum('MAINTENANCE','NEW','STATIC WEB APPLICATION','DYNAMIC WEB APPLICATION','HOSTING WEB APP','BACKEND DEVELOPEMENT','FRONTEND DEVELOPEMENT','REST WEB API'),
  `domain_url` varchar(300) DEFAULT NULL,
  `project_name` varchar(300) DEFAULT NULL,
  `project_info` varchar(300) DEFAULT NULL,
  `project_url` varchar(255) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `alternate_mobile_number` bigint(20) DEFAULT NULL,
  `country_id` int(10) DEFAULT NULL,
  `state_id` int(10) DEFAULT NULL,
  `status` enum('ACTIVE','INACTIVE') DEFAULT NULL,
  `is_user_validation_required` int(1) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


















