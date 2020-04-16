INSERT INTO account (person_id, card_number_id, creation_date, is_active, balance, restrictions, last_used) VALUES
  (1, 1, '2019-12-10', 'Y', 0.0, NULL, '2019-12-10'),
  (2, 2, '2019-12-10', 'Y', 0.0, NULL, '2019-12-10'),
  (3, 3, '2019-12-10', 'Y', 0.0, NULL, '2019-12-10');
  
INSERT INTO person (first_name, last_name, date_of_birth, title, email, sex, marital_status, occupation) VALUES
  ('Jacob', 'Jones', '2019-12-10', 'MR', 'jacob.jones@esure.com', 'MALE', 'single', 'developer'),
  ('Josh', 'Jones', '2019-12-10', 'MR', 'josh.jones@esure.com', 'MALE', 'single', 'developer'),
  ('Andy', 'Jones', '2019-12-10', 'MR', 'andy.jones@esure.com', 'MALE', 'single', 'developer');
  
INSERT INTO card (experation_date, issue_date) VALUES
  ('2019-12-12', '2019-12-12'),
  ('2019-12-11', '2019-11-11'),
  ('2019-12-10', '2019-10-10');