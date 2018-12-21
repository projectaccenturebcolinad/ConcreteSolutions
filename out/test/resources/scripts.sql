CREATE TABLE IF NOT EXISTS PUBLIC.customers(
   id INT NOT NULL,
   title VARCHAR(50) NOT NULL,
   author VARCHAR(20) NOT NULL,
   submission_date DATE,
   PRIMARY KEY (id)
);