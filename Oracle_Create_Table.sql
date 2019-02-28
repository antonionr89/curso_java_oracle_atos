CREATE TABLE USUARIO(
	ID NUMBER(10)NOT NULL,
	NOMBRE VARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(255) NOT NULL,
	EDAD NUMBER(3,0) NOT NULL,
	PASSWORD VARCHAR2(50) NOT NULL
);


ALTER TABLE USUARIO ADD
	CONSTRAINT dept_pk PRIMARY KEY(ID);

ALTER TABLE USUARIO ADD
	CONSTRAINT uq_usuario_email UNIQUE(EMAIL);
	


CREATE SEQUENCE dept_seq START WITH 1;

CREATE OR REPLACE TRIGGER dept_bir
	BEFORE INSERT ON USUARIO
	FOR EACH ROW 
	
	BEGIN
		SELECT dept_seq.NEXTVAL
		INTO :new.id
		FROM dual;
	END;
	
DROP TRIGGER dept_bir;


INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('bbbbb', 'bbb@bb.com',20,'bb');
INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('aaaaaa', 'aaaa@aa.com',25,'aa');
INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('cccccc', 'cccc@cccc.com',17,'cc');
INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('dddddd', 'ddddd@ddd.com',21,'dd');
INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('eeeeee', 'eeeee@eeeee.com',35,'ee');
INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('ffffff', 'ddddd@ddddd.com',56,'fff');
INSERT INTO USUARIO (nombre,email,edad,password)
	VALUES ('gggggg', 'ggggg@gggg.com',34,'gg');	
	

/*DROP TABLE H_USUARIO; */

*************************************
TRUNCATE TABLE H_USUARIO;
DELETE TABLE H_USUARIO;                                HACEN LO MISMO
*******************************************



UPDATE H_USUARIO SET edad = edad+1;

update usuario set nota=dbms_random.value(1,10)





update usuario set fecha_registro = add_months (fecha_registro, 1 + ROUND (dbms_random.value(1,11)))