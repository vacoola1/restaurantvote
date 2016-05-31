DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM menues;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants (name) VALUES
  ('Ресторан грузинской кухни Шоти'),
  ('Ресторан Одесса'),
  ('Пиццерия Напуле'),
  ('Спотыкач');


INSERT INTO menues (restaurant_id, day) VALUES
  (100002, '2016-05-29'),
  (100003, '2016-05-29'),
  (100004, '2016-05-29'),
  (100005, '2016-05-29'),
  (100002, now()),
  (100003, now()),
  (100004, now()),
  (100005, now());

INSERT INTO dishes (menu_id, name, price) VALUES
(100006, 'Масло сливочное', 20),
(100006, 'Колбаса с/к', 30),
(100006, 'Каша кукурузная', 15),
(100006, 'Омлет с зеленью', 200),
(100006, 'Драники со сметаной', 165),
(100006, 'Яблоки запеченные', 150),
(100006, 'Чай "Липтон"', 200),
(100010, 'Масло сливочное', 20),
(100010, 'Колбаса с/к', 30),
(100010, 'Каша кукурузная', 15),
(100010, 'Омлет с зеленью', 200),
(100010, 'Драники со сметаной', 165),
(100010, 'Яблоки запеченные', 150),
(100010, 'Чай "Липтон"', 200);


INSERT INTO votes (user_id, restaurant_id, day) VALUES
  (100000, 100002, '2016-05-29');