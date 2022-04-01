CREATE TABLE roles
(
	role_id SERIAL PRIMARY KEY,
	name text NOT NULL
);

CREATE TABLE users
(
	user_id SERIAL PRIMARY KEY,
	first_name text NOT NULL,
	last_name text NOT NULL,
	fk_role_id integer REFERENCES roles(role_id) NOT NULL
);

INSERT INTO roles (name)
VALUES
('ROLE_USER'),
('ROLE_ADMIN');

INSERT INTO users (first_name, last_name, fk_role_id)
VALUES
('default', 'user', 1),
('default', 'admin', 2);