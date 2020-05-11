DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS TRANSACTIONS;
DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS CARD;

  
CREATE TABLE ACCOUNT (
  account_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  person_id BIGINT NOT NULL,
  card_number_id BIGINT NOT NULL,
  creation_date DATETIME,
  is_active BIT,
  balance DECIMAL,
  restrictions VARCHAR(250),
  last_used DATE
);

CREATE TABLE TRANSACTION (
  transaction_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  account_id BIGINT NOT NULL,
  price DECIMAL,
  is_topping_up BIT,
  item VARCHAR(250),
  transaction_date DATE,
  location VARCHAR(250)
);

CREATE TABLE PERSON (
  person_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  unique_employee_id BIGINT NOT NULL,
  user_name VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250),
  date_of_birth DATETIME,
  title VARCHAR(250),
  email VARCHAR(250) NOT NULL,
  mobile_number VARCHAR(250) NOT NULL,
  sex VARCHAR(250),
  marital_status VARCHAR(250),
  occupation VARCHAR(250),
  password VARCHAR(250),
  credentials_non_expired BOOLEAN
);

CREATE TABLE CARD (
  cardNumber_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  experation_date DATETIME,
  issue_date DATE
);

