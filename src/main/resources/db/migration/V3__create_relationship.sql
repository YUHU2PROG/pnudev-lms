CREATE SEQUENCE IF NOT EXISTS permissions_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE permissions
(
    id          BIGINT NOT NULL,
    name        VARCHAR(50),
    description VARCHAR(255),
    CONSTRAINT pk_permissions PRIMARY KEY (id)
);

CREATE TABLE roles_permissions
(
    permission_id BIGINT NOT NULL,
    role_id       BIGINT NOT NULL,
    CONSTRAINT pk_roles_permissions PRIMARY KEY (permission_id, role_id)
);

ALTER TABLE roles_permissions
    ADD CONSTRAINT fk_rolper_on_permission FOREIGN KEY (permission_id) REFERENCES permissions (id);

ALTER TABLE roles_permissions
    ADD CONSTRAINT fk_rolper_on_role FOREIGN KEY (role_id) REFERENCES roles (id);