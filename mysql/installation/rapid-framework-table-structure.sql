DROP DATABASE IF EXISTS 	USER_SYSTEM;
CREATE DATABASE 			USER_SYSTEM;
USE 						USER_SYSTEM;

-- SYSTEM LEVEL TABLES
-- LOG_MODIFICATION
DROP TABLE IF EXISTS		LOG_MODIFICATION;

CREATE TABLE 	LOG_MODIFICATION(					id 							BIGINT UNSIGNED		NOT NULL	AUTO_INCREMENT	,
													table_name					VARCHAR(40)			NOT NULL					,
													fk_record_id				BIGINT UNSIGNED		NOT NULL					,
													version						BIGINT UNSIGNED									,
													date_created				TIMESTAMP			DEFAULT CURRENT_TIMESTAMP	,
													user_created				BIGINT											,
									PRIMARY KEY		(id) 																		,
									INDEX 			index_by_table_id_version(table_name,fk_record_id,version)					);
-- CREATE TABLE LOG_MODIFICATION(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, table_name VARCHAR(40) NOT NULL, record BIGINT UNSIGNED NOT NULL, version BIGINT UNSIGNED, date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP, user_created BIGINT, PRIMARY KEY(id),INDEX index_by_table_id_version(table_name,fk_record_id,version));






-- GENDER TABLE
DROP TABLE IF EXISTS		GENDER;

CREATE TABLE 	GENDER(								id 							INTEGER	UNSIGNED	NOT NULL	AUTO_INCREMENT	,
													display_name				VARCHAR(11)										,
													code_char					VARCHAR(1)										,
									PRIMARY KEY		(id)																		);
-- CREATE TABLE GENDER(id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, display_name VARCHAR(11), code_char VARCHAR(1), PRIMARY KEY(id));

-- NAME TABLE
-- Stores all names uniquely to reduce size of names throughout the entire database storage
DROP TABLE IF EXISTS 		NAME;

CREATE TABLE 	NAME(								id 							BIGINT UNSIGNED 	NOT NULL 	AUTO_INCREMENT	,
													name 						VARCHAR(60)										,
									PRIMARY KEY		(id)																		,
									CONSTRAINT 		unique_name					UNIQUE (NAME)									);
-- CREATE TABLE NAME(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, name VARCHAR(60), PRIMARY KEY(id), CONSTRAINT unique_name UNIQUE (name));

-- CONTAINER_NAME TABLE
-- Acts as a data structure reference for a person's full name
DROP TABLE IF EXISTS 		CONTAINER_NAME;

CREATE TABLE	CONTAINER_NAME(						id 							BIGINT UNSIGNED 	NOT NULL 	AUTO_INCREMENT	,
													name_prefix					VARCHAR(4)										,
													name_postfix				VARCHAR(5)										,
													display_name				VARCHAR(60)										,
													fk_log_modification			BIGINT UNSIGNED									,
									PRIMARY KEY		(id)																		,
									FOREIGN KEY 	(fk_log_modification)		REFERENCES		LOG_MODIFICATION(id)			);
-- CREATE TABLE	CONTAINER_NAME(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, name_prefix VARCHAR(4), name_postfix VARCHAR(5), display_name VARCHAR(60), fk_log_modification BIGINT UNSIGNED, PRIMARY KEY(id),FOREIGN KEY(fk_log_modification) REFERENCES LOG_MODIFICATION(id));


-- ASSOCIATE_NAME TABLE
-- Acts as an intermediate table to Associate Names to COUNTAINER_NAME instance
DROP TABLE IF EXISTS		ASSOCIATE_NAME;

CREATE TABLE	ASSOCIATE_NAME(						id 							BIGINT UNSIGNED		NOT NULL	AUTO_INCREMENT	,
													fk_container_name			BIGINT UNSIGNED									,
													fk_name						BIGINT UNSIGNED									,
													order_sort					TINYINT UNSIGNED								,
									PRIMARY	KEY		(id)																		,
									FOREIGN KEY 	(fk_container_name)			REFERENCES	 	CONTAINER_NAME(id)				,
									FOREIGN KEY 	(fk_name)					REFERENCES		NAME(id)						,
									INDEX			index_by_container(fk_container_name)										,
									INDEX 			index_by_name(fk_name)														);

-- CREATE TABLE	ASSOCIATE_NAME(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, fk_container_name BIGINT UNSIGNED, fk_name BIGINT UNSIGNED, order_sort TINYINT UNSIGNED, PRIMARY KEY(id),FOREIGN KEY(fk_container_name) REFERENCES CONTAINER_NAME(id), FOREIGN KEY(fk_name) REFERENCES NAME(id), INDEX index_by_container(fk_container_name), INDEX index_by_name(fk_name));


-- PERSON TABLE
DROP TABLE IF EXISTS 		PERSON;

CREATE TABLE 	PERSON(								id							BIGINT UNSIGNED		NOT NULL	AUTO_INCREMENT	,
													name_prefix					VARCHAR(4)										,
													name_first					VARCHAR(60)										,
													name_last					VARCHAR(60)										,
													name_postfix				VARCHAR(5)										,
													date_birth					DATE											,
													fk_container_name			BIGINT UNSIGNED									,
													fk_gender					INTEGER UNSIGNED								,
													display_name				VARCHAR(60)										,
													fk_log_modification			BIGINT UNSIGNED									,
									PRIMARY KEY		(id)																		,
									FOREIGN KEY		(fk_container_name)			REFERENCES		CONTAINER_NAME(id)				,
									FOREIGN	KEY		(fk_gender)					REFERENCES		GENDER(id)						,
									FOREIGN KEY		(fk_log_modification)		REFERENCES		LOG_MODIFICATION(id)			,
									INDEX 			index_person_by_last_first_name(name_last,name_first,date_birth)			,
									INDEX 			index_person_by_date_of_birth(date_birth)									);

-- CREATE TABLE PERSON(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, name_prefix VARCHAR(4), name_first VARCHAR(60), name_last VARCHAR(60), name_postfix VARCHAR(5), date_birth DATE, fk_container_name BIGINT UNSIGNED, fk_gender TINYINT UNSIGNED, display_name VARCHAR(60), fk_log_modification BIGINT UNSIGNED, PRIMARY KEY(id), FOREIGN KEY(fk_container_name) REFERENCES CONTAINER_NAME(id), FOREIGN KEY(fk_log_modification) REFERENCES LOG_MODIFICATION(id), INDEX index_person_by_last_first_name(name_last,name_first,date_birth), INDEX index_person_by_date_of_birth(date_birth));







-- ENUM_COUNTRY
DROP TABLE IF EXISTS		COUNTRY;

CREATE TABLE COUNTRY(								id 							SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT		,
													display_name 				VARCHAR(35)										,
													abbreviation 				VARCHAR(4)										,
													phone_code_country 			SMALLINT										,
													enum_value 				 	SMALLINT										,
									PRIMARY KEY		(id)																		);

-- CREATE TABLE COUNTRY(id SMALLINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(35), abbreviation VARCHAR(4), phone_code_country SMALLINT, enum_value SMALLINT, PRIMARY KEY(id));



-- TYPE_ADDRESS TABLE
DROP TABLE IF EXISTS		TYPE_ADDRESS;

CREATE TABLE 	TYPE_ADDRESS(						id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT			,
													display_name 				VARCHAR(20)										,
													enum_label					VARCHAR(25)										,
													enum_value					TINYINT UNSIGNED								,
									PRIMARY KEY		(id)																		);

-- CREATE TABLE TYPE_ADDRESS(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, display_name VARCHAR(20), PRIMARY KEY(id));

-- ADDRESS TABLE
DROP TABLE IF EXISTS		ADDRESS;

CREATE TABLE 	ADDRESS(							id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT			,
													street_number 				VARCHAR(8)										,
													street 						VARCHAR(60)										,
													unit 						VARCHAR(8)										,
													building_name 				VARCHAR(60)										,
													building_floor 				VARCHAR(10)										,
													complex 					VARCHAR(60)										,
													city 						VARCHAR(60)										,
													state 						VARCHAR(15)										,
													country 					VARCHAR(35)										,
													postal_code 				VARCHAR(10)										,
													fk_type_address 			BIGINT											,
													fk_contact 					BIGINT											,
													fk_business 				BIGINT											,
									PRIMARY KEY		(id)																		,
									INDEX 			index_by_state_city_street(state, city, street)								,
									INDEX 			index_by_postal_street_number(postal_code,street,street_number)				);

-- CREATE TABLE ADDRESS(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, street_number VARCHAR(8), street VARCHAR(60), unit VARCHAR(8), building_name VARCHAR(60), building_floor VARCHAR(10), complex VARCHAR(60), city VARCHAR(60), state VARCHAR(15), country VARCHAR(35), postal_code VARCHAR(10), fk_type_address BIGINT, fk_contact BIGINT, fk_business BIGINT, PRIMARY KEY(id), INDEX index_by_state_city_street(state, city, street), INDEX index_by_postal_street_number(postal_code,street,street_number));

-- FOREIGN KEY(fk_type_address) REFERENCES TYPE_ADDRESS(id),
-- FOREIGN KEY		(fk_type_address) 			REFERENCES 		TYPE_ADDRESS(id)				,


-- PHONE_ROUTE_MAP
DROP TABLE IF EXISTS		PHONE_ROUTE_MAP;

CREATE TABLE 	PHONE_ROUTE_MAP(					id 							BIGINT NOT NULL AUTO_INCREMENT					,
													route_level 				TINYINT UNSIGNED								, 
													display_name				VARCHAR(65)										,
													point_of_contact			VARCHAR(125)									,
													is_automated				BIT 											,
													fk_path_recorded_message	BIGINT											,
									PRIMARY KEY 	(id)																		);

-- PHONE TABLE
DROP TABLE IF EXISTS		PHONE;

CREATE TABLE 	PHONE(								id 							BIGINT NOT NULL AUTO_INCREMENT					, 
													fk_country					BIGINT											,
													code_country 				VARCHAR(3)										,
													code_area 					VARCHAR(3)										,
													prefix 						VARCHAR(4)										,
													postfix 					VARCHAR(4)										,
													extension 					VARCHAR(4)										,
													fk_phone_route_map 			BIGINT											,
									PRIMARY KEY		(id)																		,
									FOREIGN KEY		(fk_phone_route_map)		REFERENCES		PHONE_ROUTE_MAP(id)				);

-- CREATE TABLE 	PHONE(id BIGINT NOT NULL AUTO_INCREMENT, code_country VARCHAR(3), code_area VARCHAR(3), prefix VARCHAR(4), postfix VARCHAR(4), extension VARCHAR(4), fk_phone_route_map BIGINT, PRIMARY KEY(id));










-- TYPE_CONTACT TABLE
DROP TABLE IF EXISTS		TYPE_CONTACT;

CREATE TABLE 	TYPE_CONTACT(						id 							BIGINT NOT NULL AUTO_INCREMENT				,
													display_name 				VARCHAR(12)									,
													enum_label					VARCHAR(25)									,
													enum_value					TINYINT										,
									PRIMARY KEY		(id)																	);
-- CREATE TABLE TYPE_CONTACT(id BIGINT NOT NULL AUTO_INCREMENT, display_name VARCHAR(12), PRIMARY KEY(id));

-- CONTACT_RELATIONSHIP
-- Specify relationship (Spouse, Mom, Dad, Sibling, Grandparent, Extended Family, Family-in-law, Friend, Collegue, Teammate, Classmate, etc)

-- CONTACT TABLE
DROP TABLE IF EXISTS		CONTACT;

CREATE TABLE CONTACT(								id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		, 
													fk_type_contact 			BIGINT										, 
													fk_person 					BIGINT										, 
													email_primary 				VARCHAR(60)									, 
													email_secondary 			VARCHAR(60)									, 
													email_business_primary 		VARCHAR(60)									, 
													email_business_secondary 	VARCHAR(60)									, 
													fk_phone_home 				BIGINT										, 
													fk_phone_mobile_primary 	BIGINT										, 
													fk_phone_mobile_secondary 	BIGINT										, 
													fk_phone_work_office 		BIGINT										, 
													fk_phone_work_mobile 		BIGINT										, 
													fk_address_home 			BIGINT										, 
													fk_address_perminent 		BIGINT										, 
													fk_address_mailing 			BIGINT										, 
													fk_address_work 			BIGINT										, 
													fk_log_modification 		BIGINT										, 
									PRIMARY KEY		(id)																	);
-- , 
--									FOREIGN KEY		(fk_type_contact) 			REFERENCES 		TYPE_CONTACT(id)			, 
--									FOREIGN KEY		(fk_person) 				REFERENCES 		PERSON(id)					, 
--									FOREIGN KEY		(fk_phone_home) 			REFERENCES 		PHONE(id)					, 
--									FOREIGN KEY		(fk_phone_mobile_primary) 	REFERENCES 		PHONE(id)					, 
--									FOREIGN KEY		(fk_phone_mobile_secondary) REFERENCES 		PHONE(id)					, 
--									FOREIGN KEY		(fk_phone_work_mobile) 		REFERENCES 		PHONE(id)					, 
--									FOREIGN KEY		(fk_phone_work_mobile) 		REFERENCES 		PHONE(id)					, 
--									FOREIGN KEY		(fk_address_home) 			REFERENCES 		ADDRESS(id)					, 
--									FOREIGN KEY		(fk_address_perminent) 		REFERENCES 		ADDRESS(id)					, 
--									FOREIGN KEY 	(fk_address_mailing) 		REFERENCES 		ADDRESS(id)					, 
--									FOREIGN KEY		(fk_address_work) 			REFERENCES 		ADDRESS(id)					, 
--									FOREIGN KEY		(fk_log_modification) 		REFERENCES 		ADDRESS(id)					);

-- CREATE TABLE CONTACT(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, fk_type_contact BIGINT, fk_person BIGINT, email_primary VARCHAR(60), email_secondary VARCHAR(60), email_business_primary VARCHAR(60), email_business_secondary VARCHAR(60), fk_phone_home BIGINT, fk_phone_mobile_primary BIGINT, fk_phone_mobile_secondary BIGINT, fk_phone_work_office BIGINT, fk_phone_work_mobile BIGINT, fk_address_home BIGINT, fk_address_perminent BIGINT, fk_address_mailing BIGINT, fk_address_work BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id), FOREIGN KEY(fk_type_contact) REFERENCES TYPE_CONTACT(id)

-- , FOREIGN KEY(fk_person) REFERENCES PERSON(id), FOREIGN KEY(fk_phone_home) REFERENCES PHONE(id), FOREIGN KEY(fk_phone_mobile_primary) REFERENCES PHONE(id), FOREIGN KEY(fk_phone_mobile_secondary) REFERENCES PHONE(id), FOREIGN KEY(fk_phone_work_mobile) REFERENCES PHONE(id), FOREIGN KEY(fk_phone_work_mobile) REFERENCES PHONE(id), FOREIGN KEY(fk_address_home) REFERENCES ADDRESS(id), FOREIGN KEY(fk_address_perminent) REFERENCES ADDRESS(id), FOREIGN KEY (fk_address_mailing) REFERENCES ADDRESS(id), FOREIGN KEY(fk_address_work) REFERENCES	ADDRESS(id), FOREIGN KEY(fk_log_modification) REFERENCES ADDRESS(id));


-- CONTACT_GROUP TABLE
DROP TABLE IF EXISTS		CONTACT_GROUP;

CREATE TABLE 	CONTACT_GROUP(						id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		,
													display_name VARCHAR(75)												,
													enum_label					VARCHAR(25)									,
													enum_value					TINYINT										,
													fk_type_contact BIGINT													,
													description VARCHAR(250)												,
									PRIMARY KEY		(id)																	,
									FOREIGN KEY		(fk_type_contact) 			REFERENCES 		TYPE_CONTACT(ID)			);
-- CREATE TABLE CONTACT_GROUP(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, display_name VARCHAR(75), fk_type_contact BIGINT, description VARCHAR(250), PRIMARY KEY(id), FOREIGN KEY(fk_type_contact) REFERENCES TYPE_CONTACT(ID));

-- CONTACT_CIRCLE TABLE
DROP TABLE IF EXISTS		CONTACT_CIRCLE;

CREATE TABLE 	CONTACT_CIRCLE(						id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		,
													display_name 				VARCHAR(75)									, 
													fk_type_contact 			BIGINT										, 
													description 				VARCHAR(250)								, 
									PRIMARY KEY		(id)																	, 
									FOREIGN KEY		(fk_type_contact) 			REFERENCES 		TYPE_CONTACT(ID)			);

-- CONTACT_RELATIONSHIP TABLE
DROP TABLE IF EXISTS		CONTACT_RELATIONSHIP;

CREATE TABLE 	CONTACT_RELATIONSHIP(				id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		,
													display_name VARCHAR(75)												,
													fk_type_contact BIGINT													,
													description VARCHAR(250)												,
									PRIMARY KEY		(id)																	
									-- ,
									-- FOREIGN KEY		(fk_type_contact) 			REFERENCES 		TYPE_CONTACT(ID)			
									);
-- CREATE TABLE CONTACT_RELATIONSHIP(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, display_name VARCHAR(75), fk_type_contact BIGINT, description VARCHAR(250), PRIMARY KEY(id), FOREIGN KEY(fk_type_contact) REFERENCES TYPE_CONTACT(ID));



-- ASSOCIATE_CONTACT_GROUP
DROP TABLE IF EXISTS		ASSOCIATE_CONTACT_GROUP;

CREATE TABLE 	ASSOCIATE_CONTACT_GROUP(			id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		, 
													fk_contact 					BIGINT										, 
													fk_contact_group 			BIGINT										, 
													fk_log_modification 		BIGINT										, 
									PRIMARY KEY		(id)																	
									-- , 
									-- FOREIGN KEY		(fk_contact) 				REFERENCES CONTACT(id)					, 
									-- FOREIGN KEY		(fk_contact_group) 			REFERENCES CONTACT_GROUP(id)				
									);
-- CREATE TABLE ASSOCIATE_CONTACT_GROUP(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, fk_contact BIGINT, fk_contact_group BIGINT, fk_log_modification BIGINT, PRIMARY KEY(id), FOREIGN KEY(fk_contact) REFERENCES CONTACT(id), FOREIGN KEY(fk_contact_group) REFERENCES CONTACT_GROUP(id));

-- ASSOCIATE_CONTACT_CIRCLE
DROP TABLE IF EXISTS		ASSOCIATE_CONTACT_CIRCLE;

CREATE TABLE 	ASSOCIATE_CONTACT_CIRCLE(			id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		, 
													fk_contact 					BIGINT										, 
													fk_contact_circle 			BIGINT										, 
													fk_log_modification 		BIGINT										, 
									PRIMARY KEY		(id)																	
									-- , 
									-- FOREIGN KEY		(fk_contact) 				REFERENCES CONTACT(id)						
									-- , 
									-- FOREIGN KEY		(fk_contact_circle) 		REFERENCES CONTACT_CIRCLE(id)				
									);
-- CREATE TABLE ASSOCIATE_CONTACT_CIRCLE(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, fk_contact BIGINT, fk_contact_circle BIGINT, fk_log_modification BIGINT, PRIMARY KEY(ID), FOREIGN KEY(fk_contact) REFERENCES CONTACT(id), FOREIGN KEY(fk_contact_circle) REFERENCES CONTACT_CIRCLE(id));

-- ASSOCIATE_CONTACT_RELATIONSHIP
DROP TABLE IF EXISTS		ASSOCIATE_CONTACT_RELATIONSHIP;

CREATE TABLE 	ASSOCIATE_CONTACT_RELATIONSHIP(		id 							BIGINT UNSIGNED NOT NULL AUTO_INCREMENT		, 
													fk_contact 					BIGINT										, 
													fk_contact_relationship		BIGINT										, 
													fk_log_modification 		BIGINT										, 
									PRIMARY KEY		(id)																	
									-- , 
									-- FOREIGN KEY		(fk_contact) 				REFERENCES CONTACT(id)						, 
									-- FOREIGN KEY		(fk_contact_relationship)	REFERENCES CONTACT_RELATIONSHIP(id)			
									);

-- CREATE TABLE ASSOCIATE_CONTACT_RELATIONSHIP(id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, fk_contact BIGINT, fk_contact_relationship BIGINT, fk_log_modification BIGINT, PRIMARY KEY(ID), FOREIGN KEY(fk_contact) REFERENCES CONTACT(id), FOREIGN KEY(fk_contact_relationship) REFERENCES CONTACT_RELATIONSHIP(id));












-- POPULATE THE ENUMERATIONS
source /usr/local/apache-tomcat-8.0.26/webapps/MattValliCom/mysql/enums/enums-populate.sql;

-- POPULATE THE VIEWS
source /usr/local/apache-tomcat-8.0.26/webapps/MattValliCom/mysql/views/rapid-framework-views.sql;

-- IF TESTING
source /usr/local/apache-tomcat-8.0.26/webapps/MattValliCom/mysql/test-data/test-data.sql;

SHOW TABLES;
