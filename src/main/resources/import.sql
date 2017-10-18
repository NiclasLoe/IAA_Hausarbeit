--@formatter:off

INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress, dateOfBirth) VALUES (hibernate_sequence.nextval, 'last1', 'first1', 1, 'first.last@domain.com', new Date());
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress) VALUES (hibernate_sequence.nextval, 'last2', 'first2', 2, 'first.last@domain.com');
INSERT INTO APPLICANT (ID, lastname, firstname, fieldOfStudy, emailAddress) VALUES (hibernate_sequence.nextval, 'last3', 'first3', 3, 'first.last@domain.com');