DROP TABLE IF EXISTS Sale_Transaction;

CREATE TABLE Sale_Transaction (CustomerID INTEGER NOT NULL AUTO_INCREMENT, Spent FLOAT, Date VARCHAR(255), NumberOfItems INTEGER NOT NULL, PRIMARY KEY (CustomerID));

INSERT INTO Sale_Transaction (Date, Spent, NumberOfItems) VALUES ("March 5", 6.99, 5);
INSERT INTO Sale_Transaction (Date, Spent, NumberOfItems) VALUES ("March 7", 11.99, 11);