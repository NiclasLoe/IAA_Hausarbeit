--@formatter:off
INSERT INTO ROOM (ID, BEAMERPRESENT, BUILDING, ROOM_NUMBER, SEATS) VALUES (hibernate_sequence.nextval, TRUE, 'A', '101', 45);
INSERT INTO ROOM (ID, BEAMERPRESENT, BUILDING, ROOM_NUMBER, SEATS) VALUES (hibernate_sequence.nextval, FALSE, 'A', '102', 30);
INSERT INTO ROOM (ID, BEAMERPRESENT, BUILDING, ROOM_NUMBER, SEATS) VALUES (hibernate_sequence.nextval, TRUE, 'A', '103', 40);

INSERT INTO COURSE (ID, FIELD_OF_STUDY, LECTURER, NUMBER, TITLE) VALUES (hibernate_sequence.nextval, 'I', 'Anft', 148, 'Internet-Anwendungsarchitektur');
