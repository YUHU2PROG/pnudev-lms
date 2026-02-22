CREATE SEQUENCE IF NOT EXISTS classes_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE classes
(
    id                   BIGINT      NOT NULL,
    owner_id             BIGINT      NOT NULL,
    title                VARCHAR(50) NOT NULL,
    description          VARCHAR(255),
    wallpaper_image_path TEXT,
    invite_code          VARCHAR(255),
    CONSTRAINT pk_classes PRIMARY KEY (id)
);

CREATE TABLE classes_participants
(
    class_id BIGINT NOT NULL,
    user_id  BIGINT NOT NULL,
    CONSTRAINT pk_classes_participants PRIMARY KEY (class_id, user_id)
);

ALTER TABLE classes
    ADD CONSTRAINT uc_classes_invite_code UNIQUE (invite_code);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE classes
    ADD CONSTRAINT FK_CLASSES_ON_OWNER FOREIGN KEY (owner_id) REFERENCES users (id);

ALTER TABLE classes_participants
    ADD CONSTRAINT fk_clapar_on_class FOREIGN KEY (class_id) REFERENCES classes (id);

ALTER TABLE classes_participants
    ADD CONSTRAINT fk_clapar_on_user FOREIGN KEY (user_id) REFERENCES users (id);