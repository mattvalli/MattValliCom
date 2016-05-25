-- GENDER
INSERT INTO GENDER(display_name, code_char)
VALUES	('Female','F');

INSERT INTO GENDER(display_name, code_char)
VALUES	('Male','M');

INSERT INTO GENDER(display_name, code_char)
VALUES	('Transgender','T');

INSERT INTO GENDER(display_name, code_char)
VALUES	('Unspecified','U');

-- TYPE_ADDRESS
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Not Provided', 'NOT_SPECIFIED', 0);
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Residence', 'RESIDENCE', 1);
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Business', 'BUSINESS', 2);
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Recreational', 'RECREATIONAL', 3);
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Institutional','INSTITUTIONAL', 4);
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Reserve', 'RESERVE', 5);
INSERT INTO TYPE_ADDRESS(display_name, enum_label, enum_value) VALUES ('Private Property', 'PRIVATE_OWNERSHIP', 6);

-- TYPE_CONTACT
INSERT INTO TYPE_CONTACT(display_name, enum_label, enum_value) VALUES ('Not Provided', 'NOT_SPECIFIED', 0);
INSERT INTO TYPE_CONTACT(display_name, enum_label, enum_value) VALUES ('Personal', 'PERSONAL', 1);
INSERT INTO TYPE_CONTACT(display_name, enum_label, enum_value) VALUES ('Professional', 'PROFESSIONAL', 2);

-- CONTACT_GROUP
INSERT INTO CONTACT_GROUP(display_name, enum_label, enum_value) VALUES ('Not Provided', 'NOT_SPECIFIED', 0);
INSERT INTO CONTACT_GROUP(display_name, enum_label, enum_value) VALUES ('Family', 'FAMILY', 1);
INSERT INTO CONTACT_GROUP(display_name, enum_label, enum_value) VALUES ('Friend', 'FRIEND', 2);
INSERT INTO CONTACT_GROUP(display_name, enum_label, enum_value) VALUES ('Colleague', 'COLLEAGUE', 3);
INSERT INTO CONTACT_GROUP(display_name, enum_label, enum_value) VALUES ('Client', 'CLIENT', 4);
INSERT INTO CONTACT_GROUP(display_name, enum_label, enum_value) VALUES ('Teammate', 'TEAMMATE', 5);

