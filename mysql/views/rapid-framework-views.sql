-- PERSON_DETAILS VIEW
-- Constructs all the information required to display a user name 
-- MOST LIKELY
-- Better performance to run more frequent smaller queries, but good for testing relationships via command line
CREATE VIEW 	PERSON_DETAIL 
AS 
	SELECT			p.id AS PERSON_ID								, 
					p.name_prefix									, 
					p.name_first									, 
					p.name_last										, 
					p.name_postfix									, 
					p.date_birth									, 
					g.display_name 		AS 'GENDER'					, 
					cn.id 				AS CONTAINER_NAME_ID		, 
					n.name 				AS 'GIVEN NAMES' 
	
	FROM 			PERSON p 

	INNER JOIN 		container_name cn 
			ON 		p.fk_container_name 	= cn.id 

	INNER JOIN 		GENDER g 
			ON 		p.fk_gender 			= g.id 

	INNER JOIN 		ASSOCIATE_NAME an 
			ON 		an.fk_container_name 	= cn.id 

	INNER JOIN 		NAME n 
			ON 		an.fk_name 				= n.id 

	ORDER BY 		p.id 											, 
					an.order_sort 
	ASC 													;

-- CREATE VIEW PERSON_DETAIL AS SELECT p.id AS PERSON_ID, p.name_prefix, p.name_first, p.name_last, p.name_postfix, p.date_birth, g.display_name AS 'GENDER', cn.id AS CONTAINER_NAME_ID, n.name AS 'GIVEN NAMES' from person p INNER JOIN container_name cn on p.fk_container_name = cn.id INNER JOIN GENDER g ON p.fk_gender = g.id INNER JOIN ASSOCIATE_NAME an ON an.fk_container_name = cn.id INNER JOIN NAME n ON an.fk_name = n.id ORDER BY p.id, an.order_sort ASC;


-- Returns all NAMEs Associated with a particular CONTAINER_NAME
CREATE VIEW 	PERSON_FULL_NAME 
AS 
	SELECT 			an.fk_container_name							, 
					an.order_sort									, 
					n.name

	FROM 			ASSOCIATE_NAME an 

	INNER JOIN 		NAME n 
			ON 		an.fk_name = n.id 

	ORDER BY 		an.fk_container_name							, 
					order_sort										;


-- CREATE VIEW PERSON_FULL_NAME AS SELECT an.fk_container_name, an.order_sort, n.name FROM ASSOCIATE_NAME an INNER JOIN NAME n ON an.fk_name = n.id ORDER BY an.fk_container_name, order_sort;