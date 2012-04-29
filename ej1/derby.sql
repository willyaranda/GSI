create table Customer(id int NOT NULL,
  name varchar(20) NOT NULL,
  lastname varchar(20) NOT NULL,
  address varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Product(
  id int NOT NULL,
  name varchar(100) NOT NULL,
  price float NOT NULL,
  valid int NOT NULL,
  description varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

create table Customer_Product(id_customer int NOT NULL,
  id_product int NOT NULL,
  PRIMARY KEY (id_customer,id_product),
  CONSTRAINT Customer_Product_ibfk_1 FOREIGN KEY (id_customer) REFERENCES Customer (id) ON DELETE CASCADE,
  CONSTRAINT Customer_Product_ibfk_2 FOREIGN KEY (id_product) REFERENCES Product (id) ON DELETE CASCADE
);



