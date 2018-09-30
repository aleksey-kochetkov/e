DROP TABLE IF EXISTS student CASCADE;
CREATE TABLE student (
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(16),
  address_id INT
);
DROP TABLE IF EXISTS address CASCADE;
CREATE TABLE address (
  id     SERIAL,
  street VARCHAR(16)
);