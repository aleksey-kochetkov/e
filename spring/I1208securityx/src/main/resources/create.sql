DROP TABLE IF EXISTS role CASCADE;
CREATE TABLE role (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL
);
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_USER');

DROP TABLE IF EXISTS uzer CASCADE;
CREATE TABLE uzer (
  login    VARCHAR(8) PRIMARY KEY,
  role_id  INT REFERENCES role,
  password VARCHAR(16) NOT NULL,
  enabled  BOOLEAN NOT NULL,
  name     VARCHAR(16) NOT NULL
);
INSERT INTO uzer VALUES ('princess', 2, '{noop}princess', TRUE, 'Принцесса');
INSERT INTO uzer VALUES ('lion', 1, '{noop}lion', TRUE, 'Лев');
INSERT INTO uzer VALUES ('irkalii', 2, '{noop}irkalii', FALSE, 'Иркалий');
