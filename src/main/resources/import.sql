--@formatter:off

INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth) VALUES (hibernate_sequence.nextval, 'last1', 'first1', 1, 'first.last@domain.com', TO_DATE('17/12/2015', 'DD/MM/YYYY'));
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, title) VALUES (hibernate_sequence.nextval, 'last2', 'first2', 2, 'first.last@domain.com', 1);
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress) VALUES (hibernate_sequence.nextval, 'last3', 'first3', 3, 'first.last@domain.com');