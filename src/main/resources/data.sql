INSERT INTO account (person_id, card_number_id, creation_date, is_active, balance, restrictions, last_used) VALUES
  (1, 1, '2019-12-10', 'Y', 0.0, NULL, '2019-12-10'),
  (2, 2, '2019-12-10', 'Y', 0.0, NULL, '2019-12-10'),
  (3, 3, '2019-12-10', 'Y', 0.0, NULL, '2019-12-10');
  
INSERT INTO person (first_name, last_name, date_of_birth, title, email, sex, marital_status, occupation, user_name, password) VALUES
  ('Jacob', 'Jones', '2019-12-10', 'MR', 'jacob.jones@esure.com', 'MALE', 'single', 'developer', 'jjones', '{bcrypt}$2a$10$iHRq3rGAvmJxbktGs.IFT.DQkhjUKbZH81qdPjq01ppWnz4vJcp8q'),
  ('Josh', 'Jones', '2019-12-10', 'MR', 'josh.jones@esure.com', 'MALE', 'single', 'developer', 'jjones2', '{bcrypt}$2a$10$3dcCF.Xdy29ZVziAqMozDeMOyfnzyBmUA2EZlYkYBrJfTG63GDEFi'),
  ('Andy', 'Jones', '2019-12-10', 'MR', 'andy.jones@esure.com', 'MALE', 'single', 'developer', 'ajones', '{bcrypt}$2a$10$3dcCF.Xdy29ZVziAqMozDeMOyfnzyBmUA2EZlYkYBrJfTG63GDEFi');
  
INSERT INTO card (experation_date, issue_date) VALUES
  ('2019-12-12', '2019-12-12'),
  ('2019-12-11', '2019-11-11'),
  ('2019-12-10', '2019-10-10');