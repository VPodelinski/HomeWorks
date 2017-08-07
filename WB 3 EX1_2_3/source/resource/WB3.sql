/*EX1*/
CREATE DATABASE WB3;
USE WB3;
CREATE TABLE receivers(num int, name varchar(255), PRIMARY KEY (num));
CREATE TABLE expenses(num int, paydate date, receiver int, value dec, PRIMARY KEY(num), FOREIGN KEY(receiver) REFERENCES receivers(num));
SHOW TABLES;
INSERT INTO receivers VALUE(1, 'Интернет-провайдер "Соло"');
INSERT INTO receivers VALUE(2, 'Гипермаркет "Корона"');
INSERT INTO receivers VALUE(3, 'МТС');
SELECT * FROM receivers;
INSERT INTO expenses VALUE(1, '2011-5-10', 1, 20000.0);
INSERT INTO expenses VALUE(2, '2011-5-10', 2, 94200.0);
INSERT INTO expenses VALUE(3, '2011-5-11', 3, 10000.0);
INSERT INTO expenses VALUE(4, '2011-5-11', 2, 12950.0);
SELECT * FROM expenses;

/*Ex2*/
SELECT expenses.num, paydate, value, name FROM expenses, receivers WHERE receiver=receivers.num AND value > 10000;

/*EX3*/
DELETE FROM expenses WHERE value < 3000;
