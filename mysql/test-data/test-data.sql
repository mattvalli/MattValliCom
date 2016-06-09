-- NAME
INSERT INTO NAME(name) VALUES ('Matthew');
INSERT INTO NAME(name) VALUES ('Mathew');
INSERT INTO NAME(name) VALUES ('Matt');
INSERT INTO NAME(name) VALUES ('Alicia');
INSERT INTO NAME(name) VALUES ('Ali');
INSERT INTO NAME(name) VALUES ('Lici');
INSERT INTO NAME(name) VALUES ('Valli');
INSERT INTO NAME(name) VALUES ('Rabadon');
INSERT INTO NAME(name) VALUES ('Robert');
INSERT INTO NAME(name) VALUES ('Marnier');


-- CONTAINER_NAME
INSERT INTO CONTAINER_NAME(name_prefix,name_postfix,display_name) VALUES ('Mr.','','Matthew Valli');
INSERT INTO CONTAINER_NAME(name_prefix,name_postfix,display_name) VALUES ('Ms.','','Alicia Rabadon');

-- ASSOCIATE_NAME
INSERT INTO ASSOCIATE_NAME(fk_container_name, fk_name, name, order_sort) VALUES (1,1,'Matthew',0);
INSERT INTO ASSOCIATE_NAME(fk_container_name, fk_name, name, order_sort) VALUES (1,7,'Robert',2);
INSERT INTO ASSOCIATE_NAME(fk_container_name, fk_name, name, order_sort) VALUES (1,9,'Valli',1);
INSERT INTO ASSOCIATE_NAME(fk_container_name, fk_name, name, order_sort) VALUES (2,4,'Alicia',0);
INSERT INTO ASSOCIATE_NAME(fk_container_name, fk_name, name, order_sort) VALUES (2,8,'Marnier',2);
INSERT INTO ASSOCIATE_NAME(fk_container_name, fk_name, name, order_sort) VALUES (2,10,'Rabadon',1);

-- PERSON
INSERT INTO PERSON(name_prefix, name_first, name_last, name_postfix, date_birth, fk_container_name, fk_gender, display_name) VALUES('Mr.', 'Matthew', 'Valli', '', '1987-05-27', 1, 2, 'Matthew Valli');
INSERT INTO PERSON(name_prefix, name_first, name_last, name_postfix, date_birth, fk_container_name, fk_gender, display_name) VALUES('Ms.', 'Alicia', 'Rabadon', '', '1990-03-11', 2, 1, 'Alicia Rabadon');