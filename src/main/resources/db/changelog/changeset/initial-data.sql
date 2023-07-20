----------------------------------------------------------------
-- ROLES
----------------------------------------------------------------
INSERT INTO roles
VALUES (DEFAULT, 'ROLE_USER');
INSERT INTO roles
VALUES (DEFAULT, 'ROLE_ADMIN');

----------------------------------------------------------------
-- USERS
----------------------------------------------------------------
INSERT INTO users
VALUES (DEFAULT, 'user', '$2a$10$IypcuxGo2trhlajd1xTlVu0gzWP/HP3BfI1hbHfvalCBiQPUbFBFW');
INSERT INTO users
VALUES (DEFAULT, 'admin', '$2a$10$Guz702L9pxTnehQLm3yJ6OIh1CzZOVMtajZKO.N1wTk6aE.W9KqEu');

----------------------------------------------------------------
-- ROLE USER
----------------------------------------------------------------
INSERT INTO role_user
VALUES (1, 1);
INSERT INTO role_user
VALUES (2, 2);

