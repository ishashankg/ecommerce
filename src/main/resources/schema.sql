DROP TABLE IF EXISTS products;

CREATE TABLE products (
  product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  created_on DATETIME NOT NULL,
  image varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  list_price DECIMAL(20,2) NOT NULL,
  name varchar(255) NOT NULL,
  quantity INT NOT NULL,
  sale_price DECIMAL(20,2) NOT NULL,
  status BOOLEAN NOT NULL,
  updated_on DATETIME DEFAULT NULL
);

DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
  category_id INT AUTO_INCREMENT PRIMARY KEY,
  description varchar(255) DEFAULT NULL,
  name varchar(255) NOT NULL,
  position INT DEFAULT NULL,
  status BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS product_categories;

CREATE TABLE product_categories (
  product_id BIGINT NOT NULL,
  category_id BIGINT NOT NULL,
  PRIMARY KEY (product_id,category_id)
);

DROP TABLE IF EXISTS sellers;

CREATE TABLE IF NOT EXISTS sellers (
  seller_id INT AUTO_INCREMENT PRIMARY KEY,
  create_date DATETIME NOT NULL,
  description varchar(255) DEFAULT NULL,
  name varchar(255) NOT NULL,
  status BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS seller_products;

CREATE TABLE seller_products (
  seller_id INT NOT NULL,
  product_id INT NOT NULL,
  PRIMARY KEY (seller_id,product_id)
);

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  role_id INT AUTO_INCREMENT PRIMARY KEY,
  description varchar(255) DEFAULT NULL,
  name varchar(255) NOT NULL
);

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id varchar(255) NOT NULL PRIMARY KEY,
  create_date DATETIME NOT NULL,
  email varchar(255) NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  middle_name varchar(255) DEFAULT NULL,
  password varchar(255) NOT NULL,
  role_id INT NOT NULL,
  status BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS user_addresses;

CREATE TABLE IF NOT EXISTS user_addresses (
  address_id INT AUTO_INCREMENT PRIMARY KEY,
  address varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  country varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  user_id varchar(255) NOT NULL
);

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  created_at datetime NOT NULL,
  grand_total DECIMAL(20,2) DEFAULT NULL,
  items_count INT DEFAULT NULL,
  items_quantity INT DEFAULT NULL,
  status BOOLEAN NOT NULL,
  updated_at datetime DEFAULT NULL,
  user_id varchar(255) NOT NULL,
  address_id BIGINT NOT NULL
);

DROP TABLE IF EXISTS  order_address ;

CREATE TABLE IF NOT EXISTS  order_address  (
   order_address_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
   address_id int(11) NOT NULL,
   order_id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime DEFAULT NULL
);

DROP TABLE IF EXISTS order_details ;

CREATE TABLE IF NOT EXISTS order_details  (
   order_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,
   created_at datetime NOT NULL,
   description varchar(255) DEFAULT NULL,
   name varchar(255) DEFAULT NULL,
   order_id BIGINT NOT NULL,
   price DECIMAL(20,2) DEFAULT NULL,
   product_id BIGINT NOT NULL,
   quantity INT DEFAULT NULL,
   updated_at datetime DEFAULT NULL
);

DROP TABLE IF EXISTS order_payment;

CREATE TABLE order_payment  (
   payment_id BIGINT NOT NULL,
   order_id BIGINT NOT NULL,
   status varchar(20) NOT NULL,
   transaction_id  varchar(255) NOT NULL,
   PRIMARY KEY ( payment_id , order_id )
);
