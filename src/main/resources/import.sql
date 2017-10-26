--@formatter:off

INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth, birthplace, city, streetName, houseNumber, postalCode, gender, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'last1', 'first1', 1, 'first.last@domain.com', TO_DATE('01/01/1990', 'DD/MM/YYYY'), 'cityBirth1', 'city1','StreetName1', '123a', 12345, 1, 1, '0123456789');
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth, birthplace, city, streetName, houseNumber, postalCode, gender, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'last2', 'first2', 2, 'first.last@domain.com', TO_DATE('15/06/1995', 'DD/MM/YYYY'), 'cityBirth2', 'city2','StreetName2', '123b', 45678, 2, 2, '0123456789');
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth, birthplace, city, streetName, houseNumber, postalCode, gender, title, phoneNumber) VALUES (hibernate_sequence.nextval, 'last3', 'first3', 3, 'first.last@domain.com', TO_DATE('31/12/2000', 'DD/MM/YYYY'), 'cityBirth3', 'city3','StreetName3', '123c', 98765, 2, 2, '0123456789');


INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status) VALUES (hibernate_sequence.nextval, 'ENROLLED', 'first1', 'first.last@domain.com', 1000, 0);
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status) VALUES (hibernate_sequence.nextval, 'DROPPED_OUT', 'first2', 'first.last@domain.com', 1001, 1);
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status) VALUES (hibernate_sequence.nextval, 'ALUMNI', 'first1', 'first.last@domain.com', 1002, 2);
INSERT INTO STUDENT (ID, lastname, firstname, emailAddress, studentId, status) VALUES (hibernate_sequence.nextval, 'ALUMNI', 'first2', 'first.last@domain.com', 1003, 2);

-- noinspection SyntaxError
INSERT INTO COMPANY (ID, COMPANYNAME1, COMPANYNAME2, SHORTNAME) VALUES (hibernate_sequence.nextval, 'COMPANY_NAME 1', 'COMPANY_NAME 2', 'SHORT NAME')
INSERT INTO COMPANY (ID, COMPANYNAME1, COMPANYNAME2, SHORTNAME) VALUES (hibernate_sequence.nextval, 'COMPANY_NAME 12', 'COMPANY_NAME 22', 'SHORT NAME2')

INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (1, 2014, 'a')
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (1, 2014, 'b')
INSERT INTO CENTURY (FIELD_OF_STUDY, YEAR, LETTER_CODE) VALUES (2, 2014, 'b')