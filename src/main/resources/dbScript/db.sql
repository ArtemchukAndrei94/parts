CREATE DATABASE test CHARACTER SET utf8;
USE test;
DROP TABLE IF EXISTS part;

CREATE TABLE part (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
	need TINYINT(1) DEFAULT NULL,
  number INT UNSIGNED NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO part (name, need, number) VALUES ( 'Материнские платы', 1, 18);
INSERT INTO part (name, need, number) VALUES ( 'Процессоры', 1, 6);
INSERT INTO part (name, need, number) VALUES ( 'SSD Диски', 1, 9);
INSERT INTO part (name, need, number) VALUES ( 'Звуковые карты', 0, 14);
INSERT INTO part (name, need, number) VALUES ( 'Сетевые карты', 0, 11);
INSERT INTO part (name, need, number) VALUES ( 'Оптические приводы', 0, 6);
INSERT INTO part (name, need, number) VALUES ( 'Платы видеозахвата', 0, 17);
INSERT INTO part (name, need, number) VALUES ( 'Видеокарты', 1, 6);
INSERT INTO part (name, need, number) VALUES ( 'TV-тюнеры', 0, 32);
INSERT INTO part (name, need, number) VALUES ( 'Оперативная память', 1, 14);
INSERT INTO part (name, need, number) VALUES ( 'Корпуса', 1, 28);
INSERT INTO part (name, need, number) VALUES ( 'HDD диски', 0, 15);
INSERT INTO part (name, need, number) VALUES ( 'Системы охлаждения', 1, 10);
INSERT INTO part (name, need, number) VALUES ( 'Блоки питания', 1, 10);