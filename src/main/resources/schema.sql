create table widget (
  id INTEGER (36) NOT NULL AUTO_INCREMENT,
  code VARCHAR (10) NOT NULL UNIQUE,
  name VARCHAR (50) NOT NULL,
  PRIMARY KEY (id)
);