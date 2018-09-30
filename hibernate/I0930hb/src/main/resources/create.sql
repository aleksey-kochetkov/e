DROP TABLE IF EXISTS employee CASCADE;
CREATE TABLE employee (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(16) NOT NULL,
  salary INT
);
DROP TABLE IF EXISTS certificate CASCADE;
CREATE TABLE certificate (
  id          SERIAL PRIMARY KEY,
  descript    VARCHAR(16) NOT NULL,
  employee_id INT NOT NULL
);