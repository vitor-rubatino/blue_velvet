INSERT INTO tb_user (first_name, last_name ,email, password) VALUES ('user', 'user', 'user@email.com','$2a$10$DuAA66Nv15ov4WtTprWEdOTn4DryrM1frVLaa.DJix5hyewazeQe2');
INSERT INTO tb_user(first_name, last_name ,email, password) VALUES ('admin', 'admin','admin@email.com','$2a$10$DuAA66Nv15ov4WtTprWEdOTn4DryrM1frVLaa.DJix5hyewazeQe2');

INSERT INTO tb_role(role_name) VALUES('ROLE_ADMIN');
INSERT INTO tb_role(role_name) VALUES('ROLE_USER');

INSERT INTO tb_user_role(user_id, role_id) VALUES(1, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES(2, 1);