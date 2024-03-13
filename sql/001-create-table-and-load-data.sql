DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(25) NOT NULL,
  age int NOT NULL,
  mail VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO employee (name, age , mail) VALUES ("横山　春雄",56,"haruo.com");
INSERT INTO employee (name, age , mail) VALUES ("藤岡　美穂子",48,"mihoko.com");
INSERT INTO employee (name, age , mail) VALUES ("今別府　和幸",22,"kazuyuki.com");

