CREATE TABLE people (
  id  int(11) auto_increment PRIMARY KEY,
  first_name VARCHAR(128),
  last_name VARCHAR(128),
  created_at DATETIME,
  updated_at DATETIME
)ENGINE=InnoDB;
