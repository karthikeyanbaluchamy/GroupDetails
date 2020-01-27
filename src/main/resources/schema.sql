DROP TABLE IF EXISTS Product_Details;
  
CREATE TABLE Product_Details (
  Id INT NOT NULL PRIMARY KEY,
  items VARCHAR(50),
  brand VARCHAR(50),
  colour VARCHAR(50),
  size VARCHAR(50),
  type VARCHAR(50)
);