CREATE SCHEMA IF NOT EXISTS demo;
CREATE TABLE IF NOT EXISTS demo.users
(id long(4) auto_increment primary key, username varchar(255), phone varchar(255), key idx_name(username));