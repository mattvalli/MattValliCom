-- Construct the Portfolio Database
DROP DATABASE IF EXISTS		PORTFOLIO;

CREATE DATABASE 	PORTFOLIO;

-- Select the Porfolio Database to construct tables
USE PORTFOLIO;

-- EXAPMLE PROJECT
DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary DOUBLE NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
-- EXAMPLE PROJECT

-- TYPE_BUSINESS TABLE
DROP TABLE IF EXISTS		TYPE_BUSINESS;

CREATE TABLE 	TYPE_BUSINESS(								id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(12)									,
															enum_label 					VARCHAR(12)									,
															enum_value 					SMALLINT									,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE TYPE_BUSINESS(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(12), enum_label VARCHAR(12), enum_value SMALLINT, PRIMARY KEY(id));

-- BUSINESS TABLE
DROP TABLE IF EXISTS		BUSINESS;

CREATE TABLE 	BUSINESS(									id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															name 						VARCHAR(125)								,
															fk_type_business	 		BIGINT										,
															fk_address 					BIGINT										,
															fk_url 						BIGINT										,
															PRIMARY KEY(id)															);

-- TYPE_INSTITUITION TABLE
DROP TABLE IF EXISTS		TYPE_INSTITUITION;

CREATE TABLE 	TYPE_INSTITUITION(							id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(12)									,
															enum_label 					VARCHAR(12)									,
															enum_value 					SMALLINT									,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE TYPE_INSTITUITION(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(12), enum_label VARCHAR(12), enum_value SMALLINT, PRIMARY KEY(id));

-- INSTITUTION TABLE
DROP TABLE IF EXISTS		INSTITUTION;

CREATE TABLE 	INSTITUTION(								id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															name 						VARCHAR(125)								,
															fk_type_institution 		BIGINT										,
															fk_address 					BIGINT										,
															fk_url 						BIGINT										,
															PRIMARY KEY(id)															);

-- Construct the Tables
-- TYPE_EXPERIENCE TABLE
DROP TABLE IF EXISTS		TYPE_EXPERIENCE;

CREATE TABLE 	TYPE_EXPERIENCE(							id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(12)									,
															enum_label 					VARCHAR(12)									,
															enum_value 					SMALLINT									,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE TYPE_EXPERIENCE(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(12), enum_label VARCHAR(12), enum_value SMALLINT, PRIMARY KEY(id));

-- EXPERIENCE TABLE
DROP TABLE IF EXISTS		EXPERIENCE;

CREATE TABLE EXPERIENCE(									id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															job_title 					VARCHAR(125)								,
															description 				VARCHAR(250)								,
															date_start 					DATE 										,
															date_end 					DATE  										,
															fk_business 				BIGINT										,
															fk_type_experience			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE EXPERIENCE(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), job_title VARCHAR(125), description VARCHAR(250), date_start DATE, date_end DATE, fk_business BIGINT, fk_type_experience BIGINT, PRIMARY KEY(id));


-- CREATE TABLE INSTITUTION(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), name VARCHAR(125), fk_type_institution BIGINT, fk_address BIGINT, fk_url BIGINT, PRIMARY KEY(id));

-- BOOK TABLE
DROP TABLE IF EXISTS		BOOK;

CREATE TABLE 	BOOK(										id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															title 						VARCHAR(125)								,
															subtitle 					VARCHAR(125)								,
															isbn 						VARCHAR(13)									,
															description 				VARCHAR(250)								,
															fk_url_cover_image 			BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE BOOK(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), title VARCHAR(125), subtitle VARCHAR(125), isbn VARCHAR(13), description VARCHAR(250), fk_url_cover_image BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- CHAPTER TABLE
DROP TABLE IF EXISTS		CHAPTER;

CREATE TABLE 	CHAPTER(									id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															title 						VARCHAR(125)								,
															subtitle 					VARCHAR(125)								,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE CHAPTER(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), title VARCHAR(125), subtitle VARCHAR(125), PRIMARY KEY(id));


-- CHAPTER SECTION
DROP TABLE IF EXISTS		SECTION;
CREATE TABLE 	SECTION(									id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															title 						VARCHAR(125)								,
															subtitle 					VARCHAR(125)								,
															body 						TEXT										,
															fk_log_modification 		BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE SECTION(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), title VARCHAR(125), subtitle VARCHAR(125), body TEXT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- PORTFOLIO TABLE
DROP TABLE IF EXISTS		PORTFOLIO;

CREATE TABLE 	PORTFOLIO(									id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															title 						VARCHAR(125)								,
															fk_person 					BIGINT										, 
															fk_subject 					BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE PORTFOLIO(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), title VARCHAR(125), fk_person BIGINT, fk_subject BIGINT, PRIMARY KEY(id));


-- PROJECT TABLE
DROP TABLE IF EXISTS		PROJECT;

CREATE TABLE 	PROJECT(									id 							BIGINT NOT NULL AUTO_INCREMENT				,
															display_name 				VARCHAR(125)								,
															name 						VARCHAR(125)								,
															description					VARCHAR(250)								,
															url_github_repository		VARCHAR(125)								,
															url_live_project			VARCHAR(125)								,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE PROJECT(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), name VARCHAR(125), description VARCHAR(250), url_github_repository VARCHAR(125), url_live_project VARCHAR(125), PRIMARY KEY(id));

-- RESOURCE TABLE
DROP TABLE IF EXISTS		RESOURCE;

CREATE TABLE 	RESOURCE(									id 							BIGINT NOT NULL AUTO_INCREMENT 				, 
															display_name 				VARCHAR(125)								, 
															url 						VARCHAR(125)								, 
															fk_type_resource 			SMALLINT									,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE RESOURCE(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), url VARCHAR(125), fk_resource_type SMALLINT, PRIMARY KEY(id));


-- SKILL TABLE
DROP TABLE IF EXISTS		SKILL;

CREATE TABLE 	SKILL(										id 							BIGINT NOT NULL AUTO_INCREMENT 				, 
															display_name 				VARCHAR(125)								, 
															description 				VARCHAR(250)								, 
											PRIMARY KEY		(id)																	);

-- CREATE TABLE SKILL(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), description VARCHAR(250), PRIMARY KEY(id));


-- TUTORIAL TABLE
DROP TABLE IF EXISTS		TUTORIAL;

CREATE TABLE 	TUTORIAL(									id 							BIGINT NOT NULL AUTO_INCREMENT 				, 
															display_name 				VARCHAR(125)								, 
															subtitle 					VARCHAR(125)								, 
															fk_subject 					BIGINT										, 
															content 					TEXT										, 
											PRIMARY KEY		(id)																	);

-- CREATE TABLE TUTORIAL(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(125), subtitle VARCHAR(125), fk_subject BIGINT, content TEXT, PRIMARY KEY(id));



-- ASSOCIATE_BOOK_AUTHOR
DROP TABLE IF EXISTS		ASSOCIATE_BOOK_AUTHOR;

CREATE TABLE 	ASSOCIATE_BOOK_AUTHOR(						id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_book 					BIGINT										, 
															fk_person 					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_BOOK_AUTHOR(id BIGINT NOT NULL AUTO_INCREMENT, fk_book BIGINT, fk_person BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_BOOK_CHAPTER
DROP TABLE IF EXISTS		ASSOCIATE_BOOK_CHAPTER;

CREATE TABLE 	ASSOCIATE_BOOK_CHAPTER(						id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_book 					BIGINT										, 
															fk_chapter 					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_BOOK_CHAPTER(id BIGINT NOT NULL AUTO_INCREMENT, fk_book BIGINT, fk_chapter BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_CHAPTER_SECTION
DROP TABLE IF EXISTS		ASSOCIATE_CHAPTER_SECTION;

CREATE TABLE 	ASSOCIATE_BOOK_SECTION(						id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_chapter 					BIGINT										, 
															fk_section 					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_BOOK_AUTHOR(id BIGINT NOT NULL AUTO_INCREMENT, fk_chapter BIGINT, fk_section BIGINT, KEY(id));

-- ASSOCIATE_SUBJECT_BOOK
DROP TABLE IF EXISTS		ASSOCIATE_SUBJECT_BOOK;

CREATE TABLE 	ASSOCIATE_SUBJECT_BOOK(						id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_subject					BIGINT										,
															fk_book 					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_BOOK_AUTHOR(id BIGINT NOT NULL AUTO_INCREMENT, fk_subject BIGINT, fk_book BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- ASSOCIATE_SUBJECT_TUTORIAL
DROP TABLE IF EXISTS		ASSOCIATE_SUBJECT_TUTORIAL;

CREATE TABLE 	ASSOCIATE_SUBJECT_TUTORIAL(					id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_subject					BIGINT										,
															fk_tutorial 				BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_SUBJECT_TUTORIAL(id BIGINT NOT NULL AUTO_INCREMENT, fk_subject BIGINT, fk_tutorial BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- ASSOCIATE_PERSON_PORTFOLIO
DROP TABLE IF EXISTS		ASSOCIATE_PERSON_PORTFOLIO;

CREATE TABLE 	ASSOCIATE_PERSON_PORTFOLIO(					id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_person 					BIGINT										,
															fk_portfolio				BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PERSON_PORTFOLIO(id BIGINT NOT NULL AUTO_INCREMENT, fk_person BIGINT, fk_portfolio BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PERSON_EXPERIENCE
DROP TABLE IF EXISTS		ASSOCIATE_PERSON_EXPERIENCE;

CREATE TABLE 	ASSOCIATE_PERSON_EXPERIENCE(				id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_person 					BIGINT										,
															fk_experience				BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PERSON_EXPERIENCE(id BIGINT NOT NULL AUTO_INCREMENT, fk_person BIGINT, fk_experience BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PERSON_PROJECT
DROP TABLE IF EXISTS		ASSOCIATE_PERSON_PROJECT;

CREATE TABLE 	ASSOCIATE_PERSON_PROJECT(					id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_person 					BIGINT										,
															fk_project					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PERSON_PROJECT(id BIGINT NOT NULL AUTO_INCREMENT, fk_person BIGINT, fk_project BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- ASSOCIATE_PERSON_SKILL
DROP TABLE IF EXISTS		ASSOCIATE_PERSON_SKILL;

CREATE TABLE 	ASSOCIATE_PERSON_SKILL(						id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_person 					BIGINT										,
															fk_skill					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PERSON_SKILL(id BIGINT NOT NULL AUTO_INCREMENT, fk_person BIGINT, fk_skill BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT
DROP TABLE IF EXISTS		ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT;

CREATE TABLE 	ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT(		id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_person 					BIGINT										,
															fk_social_media_account		BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT(id BIGINT NOT NULL AUTO_INCREMENT, fk_person BIGINT, fk_social_media_account BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT
DROP TABLE IF EXISTS		ASSOCIATE_PERSON_TUTORIAL;

CREATE TABLE 	ASSOCIATE_PERSON_TUTORIAL(					id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_person 					BIGINT										,
															fk_tutorial					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT(id BIGINT NOT NULL AUTO_INCREMENT, fk_person BIGINT, fk_tutorial BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- ASSOCIATE_PORTFOLIO_EXPERIENCE
DROP TABLE IF EXISTS		ASSOCIATE_PORTFOLIO_EXPERIENCE;

CREATE TABLE 	ASSOCIATE_PORTFOLIO_EXPERIENCE(				id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_portfolio				BIGINT										,
															fk_experience				BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PORTFOLIO_EXPERIENCE(id BIGINT NOT NULL AUTO_INCREMENT, fk_portfolio BIGINT, fk_experience BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PORTFOLIO_PROJECT
DROP TABLE IF EXISTS		ASSOCIATE_PORTFOLIO_PROJECT;

CREATE TABLE 	ASSOCIATE_PORTFOLIO_PROJECT(				id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_portfolio				BIGINT										,
															fk_project					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PORTFOLIO_PROJECT(id BIGINT NOT NULL AUTO_INCREMENT, fk_portfolio BIGINT, fk_project BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PORTFOLIO_SKILL
DROP TABLE IF EXISTS		ASSOCIATE_PORTFOLIO_SKILL;

CREATE TABLE 	ASSOCIATE_PORTFOLIO_SKILL(					id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_portfolio				BIGINT										,
															fk_skill					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PORTFOLIO_RESOURCE(id BIGINT NOT NULL AUTO_INCREMENT, fk_portfolio BIGINT, fk_resource BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PORTFOLIO_BOOK
DROP TABLE IF EXISTS		ASSOCIATE_PORTFOLIO_BOOK;

CREATE TABLE 	ASSOCIATE_PORTFOLIO_BOOK(					id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_portfolio				BIGINT										,
															fk_book 					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_BOOK_AUTHOR(id BIGINT NOT NULL AUTO_INCREMENT, fk_portfolio BIGINT, fk_book BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));


-- ASSOCIATE_PORTFOLIO_RESOURCE
DROP TABLE IF EXISTS		ASSOCIATE_PORTFOLIO_RESOURCE;

CREATE TABLE 	ASSOCIATE_PORTFOLIO_RESOURCE(				id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_portfolio				BIGINT										,
															fk_resource					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PORTFOLIO_RESOURCE(id BIGINT NOT NULL AUTO_INCREMENT, fk_portfolio BIGINT, fk_resource BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));

-- ASSOCIATE_PORTFOLIO_TUTORIAL
DROP TABLE IF EXISTS		ASSOCIATE_PORTFOLIO_TUTORIAL;

CREATE TABLE 	ASSOCIATE_PORTFOLIO_TUTORIAL(				id 							BIGINT NOT NULL AUTO_INCREMENT				,
															fk_portfolio				BIGINT										,
															fk_tutorial					BIGINT										,
															fk_log_modification			BIGINT										,
											PRIMARY KEY		(id)																	);

-- CREATE TABLE ASSOCIATE_PORTFOLIO_TUTORIAL(id BIGINT NOT NULL AUTO_INCREMENT, fk_portfolio BIGINT, fk_tutorial BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id));



-- Display Tables to User Via Command line
SHOW TABLES;

