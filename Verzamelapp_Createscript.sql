SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS SETJES;
DROP TABLE IF EXISTS BIERDOPJE; 
DROP TABLE IF EXISTS POSTZEGEL;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE SETJES(
	id		INT			PRIMARY KEY,
	naam 	VARCHAR(255)	UNIQUE 			NOT NULL,	
	jaar	YEAR			NOT NULL
);

CREATE TABLE BIERDOPJE(
	id			INT				PRIMARY KEY,
	set_ID		INT				NOT NULL,
	uitgavejaar	YEAR			NOT NULL,
	merk		VARCHAR(255)	NOT NULL
);

CREATE TABLE POSTZEGEL(
	id			INT		PRIMARY KEY,
	set_ID		INT		NOT NULL,
	uitgavejaar	YEAR	NOT NULL,
	lengte		INT		NOT NULL,
	breedte		INT		NOT NULL,

	CHECK(lengte > 0),
	CHECK(breedte > 0)
);

INSERT INTO SETJES (id, naam, jaar)
	VALUES (1, "Duitse Postzegels", 2013);
INSERT INTO SETJES (id, naam, jaar)
	VALUES (2, "Bierdopjes intro", 2015);	
INSERT INTO SETJES (id, naam, jaar)
	VALUES (3, "Voorwerpen uit Rusland", 2016);	
	
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (1, 2, 2015, "Heineken");	
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (2, 2, 2015, "Heineken");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (3, 2, 2015, "Heineken");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (4, 2, 2015, "Palm");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (5, 2, 2015, "Heineken");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (6, 2, 2015, "Bavaria");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (7, 2, 2014, "Hertog Jan");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (8, 2, 2014, "Heineken");	
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (9, 3, 2015, "Baltika");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (10, 3, 2016, "Bochkarev Krepoe");
INSERT INTO BIERDOPJE (id, set_ID, uitgavejaar, merk)
	VALUES (11, 3, 2015, "Bochkarev Krepoe");
	
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (1, 1, 2012, 12, 42);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (2, 1, 2005, 42, 19);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (3, 1, 1966, 22, 24);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (4, 1, 1977, 45, 31);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (5, 1, 2004, 24, 12);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (6, 1, 2012, 15, 15);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (7, 1, 2004, 16, 21);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (8, 1, 2008, 21, 18);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (9, 3, 2015, 24, 15);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (10, 3, 2016, 19, 19);
INSERT INTO POSTZEGEL (id, set_ID, uitgavejaar, lengte, breedte)
	VALUES (11, 3, 2016, 28, 29);
	
ALTER TABLE BIERDOPJE
	ADD CONSTRAINT fk_BIERDOPJE_set_ID FOREIGN KEY (set_ID) REFERENCES SETJES(ID);
ALTER TABLE POSTZEGEL
	ADD CONSTRAINT fk_POSTZEGEL_set_ID FOREIGN KEY (set_ID) REFERENCES SETJES(ID);