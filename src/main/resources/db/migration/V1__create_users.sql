CREATE SEQUENCE IF NOT EXISTS users_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE users
(
    id                BIGINT NOT NULL,
    name              VARCHAR(50),
    email             TEXT,
    password          TEXT,
    avatar_image_path TEXT,
    CONSTRAINT pk_users PRIMARY KEY (id)
);