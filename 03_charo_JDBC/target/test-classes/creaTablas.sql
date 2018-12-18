CREATE DATABASE  IF NOT EXISTS `tema1`;
use tema1;
DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS bonus;
DROP TABLE IF EXISTS salgrade;
DROP TABLE IF EXISTS DUMMY;
DROP TABLE IF EXISTS correos;
DROP TABLE IF EXISTS usuarios;
CREATE TABLE dept (deptNO INT(2), dname VARCHAR(14), loc VARCHAR(13), PRIMARY KEY (deptNO));
INSERT INTO dept VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES (20, 'RESEARCH',   'DALLAS');
INSERT INTO dept VALUES (30, 'SALES',      'CHICAGO');
INSERT INTO dept VALUES (40, 'OPERATIONS', 'BOSTON');
CREATE TABLE bonus (ename VARCHAR(10), job VARCHAR(9), sal   INT, comm  INT, PRIMARY KEY (ename));
CREATE TABLE salgrade (grade INT, losal INT, hisal INT, PRIMARY KEY (grade));
INSERT INTO salgrade VALUES (1,  700, 1200);
INSERT INTO salgrade VALUES (2, 1201, 1400);
INSERT INTO salgrade VALUES (3, 1401, 2000);
INSERT INTO salgrade VALUES (4, 2001, 3000);
INSERT INTO salgrade VALUES (5, 3001, 9999);
CREATE TABLE DUMMY (DUMMY INT PRIMARY KEY);
INSERT INTO DUMMY VALUES (0);
CREATE TABLE emp (empNO INTEGER(4) NOT NULL, ename VARCHAR(10), job VARCHAR(9), mgr INTEGER(4), hiredate DATE, sal NUMERIC(7, 2), comm NUMERIC(7, 2), deptNO INTEGER(2), PRIMARY KEY (empNO), FOREIGN KEY (deptNO) REFERENCES dept(deptNO));
INSERT INTO emp VALUES (7369, 'SMITH',  'CLERK',     7902, '1980/12/17',  800, NULL, 20);
INSERT INTO emp VALUES (7499, 'ALLEN',  'SALESMAN',  7698, '1981/02/20', 1600,  300, 30);
INSERT INTO emp VALUES (7521, 'WARD',   'SALESMAN',  7698, '1981/02/22',  1250,  500, 30);
INSERT INTO emp VALUES (7566, 'JONES',  'MANAGER',   7839, '1981/04/02',  2975, NULL, 20);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN',  7698, '1981/09/28', 1250, 1400, 30);
INSERT INTO emp VALUES (7698, 'BLAKE',  'MANAGER',   7839, '1981/05/01',  2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK',  'MANAGER',   7839, '1981/06/09',  2450, NULL, 10);
INSERT INTO emp VALUES (7788, 'SCOTT',  'ANALYST',   7566, '1982/12/09', 3000, NULL, 20);
INSERT INTO emp VALUES (7839, 'KING',   'PRESIDENT', NULL, '1981/11/17', 5000, NULL, 10);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN',  7698, '1981/09/08',  1500,    0, 30);
INSERT INTO emp VALUES (7876, 'ADAMS',  'CLERK',     7788, '1983/01/12', 1100, NULL, 20);
INSERT INTO emp VALUES (7900, 'JAMES',  'CLERK',     7698, '1981/12/03',   950, NULL, 30);
INSERT INTO emp VALUES (7902, 'FORD',   'ANALYST',   7566, '1981/12/03',  3000, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK',     7782, '1982/01/23', 1300, NULL, 10);
CREATE TABLE usuarios (idUsuario int not null primary key, nombre varchar(30) not null, nif varchar(9) not null, saldo double not null, fecha datetime default CURRENT_TIMESTAMP);
INSERT INTO usuarios (idUsuario, nombre, nif, saldo) VALUES (1, 'DANI', '53451245D', 50);
INSERT INTO usuarios (idUsuario, nombre, nif, saldo) VALUES (2, 'MARTA', '45456789M', 20);
INSERT INTO usuarios (idUsuario, nombre, nif, saldo) VALUES (3, 'SERGIO', '12345678S', 5);
CREATE TABLE correos (idCorreo int not null primary key, remitente varchar(30) not null, mensaje varchar(200) not null, fechaHora datetime default CURRENT_TIMESTAMP, idUsuario int not null);
ALTER TABLE correos ADD CONSTRAINT fk_usuarios_correos FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario);
INSERT INTO correos (idCorreo, remitente, mensaje, idUsuario) VALUES (1, "Armando", "Buenos dias", 1);
INSERT INTO correos (idCorreo, remitente, mensaje, idUsuario) VALUES (2, "Pablo", "Hola que tal", 2);
INSERT INTO correos (idCorreo, remitente, mensaje, idUsuario) VALUES (3, "Raquel", "Me gustaria informarle...", 2);
INSERT INTO correos (idCorreo, remitente, mensaje, idUsuario) VALUES (4, "Marc", "Su pedido se ha entrado", 3);
COMMIT;