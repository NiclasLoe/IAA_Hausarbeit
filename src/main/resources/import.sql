--@formatter:off

-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth, birthplace, city, streetName, houseNumber, postalCode, gender, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Franz', 'Hans', 1, 'hans.franz@domain.com', TO_DATE('01/01/1990', 'DD/MM/YYYY'), 'Muenchen', 'Hamburg', 'Beispielstraße', '123a', 12345, 1, 1, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth, birthplace, city, streetName, houseNumber, postalCode, gender, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Meier', 'Max', 2, 'max.meier_99@domain.com', TO_DATE('15/06/1995', 'DD/MM/YYYY'), 'Bonn', 'Hamburg', 'Beispielstraße', '123b', 45678, 2, 2, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth, birthplace, city, streetName, houseNumber, postalCode, gender, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Graf', 'Ludwig', 3, 'l.graf@domain.com', TO_DATE('31/12/2000', 'DD/MM/YYYY'), 'Hamburg', 'Elmshorn', 'Beispielstraße', '123c', 98765, 2, 2, '0123456789');

-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (3, 2010, 'a');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (0, 2014, 'a');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (1, 2014, 'b');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (2, 2014, 'a');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (3, 2014, 'a');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (0, 2015, 'a');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (1, 2015, 'a');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (2, 2015, 'b');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (3, 2015, 'b');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO COMPANY (ID, companyName1, companyName2, shortName, contactPerson, faxNumber, phoneNumber, mailAddress, streetName, houseNumber, city, postalCode) VALUES (hibernate_sequence.nextval, 'IT-Software', 'Germany GmbH', 'IT GmbH', 'Michael Mueller', '012345678910', '012345678910', 'm.mueller@it-gmbh.de', 'Max-Muster-Str.', '123a', 'MusterCity', 12345);
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO COMPANY (ID, companyName1, companyName2, shortName, contactPerson, faxNumber, phoneNumber, mailAddress, streetName, houseNumber, city, postalCode) VALUES (hibernate_sequence.nextval, 'Sales Team', 'Germany', 'STG', 'Michelle Muster', '012345678910', '012345678910', 'm.muster@stg.com', 'Max-Muster-Str.', '123a', 'MusterCity', 12345);
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO COMPANY (ID, companyName1, shortName, contactPerson, faxNumber, phoneNumber, mailAddress, streetName, houseNumber, city, postalCode) VALUES (hibernate_sequence.nextval, 'Smart Machines', 'SMachines', 'Cornelia Meyer', '012345678910', '012345678910', 'cornelia.meyer@it-gmbh.com', 'Max-Muster-Str.', '123a', 'MusterCity', 12345);
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO COMPANY (ID, companyName1, companyName2, shortName, contactPerson, faxNumber, phoneNumber, mailAddress, streetName, houseNumber, city, postalCode) VALUES (hibernate_sequence.nextval, 'BigMedia', 'DACH GmbH', 'BigMedia', 'Lutz Schulze', '012345678910', '012345678910', 'lutzschulze@bigmedia.de', 'Max-Muster-Str.', '123a', 'MusterCity', 12345);

-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Corinna', 'Bauer');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Johanna', 'Meier');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Peter', 'Versuch');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Katharina', 'Exemplar');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Marit', 'Beispiel');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Klaus', 'Muster');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Max', 'Meyer');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO SUPERVISOR (ID, firstName, lastName) VALUES (hibernate.hibernate_sequence.nextval, 'Joe', 'Brauer');


-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Last', 'Chris', 'c.last@studend.com', 1000, 2, 'Hamburg', TO_DATE('01/01/1990', 'DD/MM/YYYY'), 0, 'ExampleStreetName', '12', 'Hamburg', 98765, 10000, 'chris.last@nordakademie.de', 3, 2010, 'a', 4, 2, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Muster', 'Jessi', 'jessi.muster@studend.com', 1001, 1, 'Bremen', TO_DATE('02/02/1990', 'DD/MM/YYYY'), 1, 'ExampleStreetName', '12', 'Hamburg', 98765, 10001, 'jessi.muster@nordakademie.de', 0, 2014, 'a', 5, 1, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Beispiel', 'Susanne', 's.beispiel@studend.com', 1002, 1, 'Frankfurt', TO_DATE('03/04/1990', 'DD/MM/YYYY'), 1, 'ExampleStreetName', '12', 'Hamburg', 98765, 10002, 'susanne.beispiel@nordakademie.de', 1, 2014, 'b', 6, 2, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Meyer', 'Jonas', 'jonas.meyer@studend.com', 1003, 0, 'Muenchen', TO_DATE('04/05/1990', 'DD/MM/YYYY'), 0, 'ExampleStreetName', '12', 'Hamburg', 98765, 10003, 'jonas.meyer@nordakademie.de', 2, 2014, 'a', 7, 0, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Mueller', 'Frank', 'frank.mueller@studend.com', 1004, 0, 'Braunschweig', TO_DATE('05/05/1990', 'DD/MM/YYYY'), 0, 'ExampleStreetName', '12', 'Hamburg', 98765, 10004, 'frank.mueller@nordakademie.de', 3, 2014, 'a', 4, 0, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Meier', 'Mike', 'mike.meier@studend.com', 1005, 0, 'Hamburg', TO_DATE('04/05/1990', 'DD/MM/YYYY'), 0, 'ExampleStreetName', '12', 'Hamburg', 98765, 10005, 'mike.meier@nordakademie.de', 0, 2015, 'a', 5, 2, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Paul', 'Ute', 'u.paul_1@studend.com', 1006, 0, 'Berlin', TO_DATE('06/06/1990', 'DD/MM/YYYY'), 1, 'ExampleStreetName', '12', 'Hamburg', 98765, 10006, 'ute.paul@nordakademie.de', 1, 2015, 'a', 6, 1, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Menke', 'Melina', 'melina.menke@studend.com', 1007, 0, 'Flensburg', TO_DATE('08/01/1990', 'DD/MM/YYYY'), 1, 'ExampleStreetName', '12', 'Hamburg', 98765, 10007, 'melina.menke@nordakademie.de', 2, 2015, 'b', 7, 1, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Hahn', 'Anna', 'annahahn@studend.com', 1008, 0, 'Elmshorn', TO_DATE('08/08/1990', 'DD/MM/YYYY'), 1, 'ExampleStreetName', '12', 'Hamburg', 98765, 10008, 'anna.hahn@nordakademie.de', 3, 2015, 'b', 5, 1, '0123456789');
-- noinspection SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve,SqlResolve
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status, birthplace, dateofbirth, gender, streetName, houseNumber, city, postalCode, username, userEmail, century_FIELD_OF_STUDY, century_year, century_LETTER_CODE, company_id, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'Fuchs', 'Karl', 'kfuchs@studend.com', 1009, 0, 'Elmhorns', TO_DATE('10/01/1990', 'DD/MM/YYYY'), 0, 'ExampleStreetName', '12', 'Hamburg', 98765, 10009, 'karl.fuchs@nordakademie.de', 3, 2015, 'b', 6, 0, '0123456789');




