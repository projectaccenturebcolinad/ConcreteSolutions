CREATE TABLE IF NOT EXISTS customers(
   id INT NOT NULL,
   name VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   password VARCHAR(40) NOT NULL,
   phones VARCHAR(2000) NOT NULL,
   created DATE NOT NULL,
   modified DATE,
   last_login DATE,
   token VARCHAR(100),
   PRIMARY KEY (id)
);