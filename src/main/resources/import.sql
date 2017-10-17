--@formatter:off

INSERT INTO APPLICANT (ID, lastname, firstname, gender, title)
VALUES (hibernate_sequence.nextval, 'last', 'first', Gender.MALE, Title.MR);