CREATE SEQUENCE IF NOT EXISTS tests_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE tests
(
    id          BIGINT      NOT NULL,
    owner_id    BIGINT      NOT NULL,
    title       VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    CONSTRAINT pk_tests PRIMARY KEY (id)
);

ALTER TABLE tests
    ADD CONSTRAINT FK_TESTS_ON_OWNER FOREIGN KEY (owner_id) REFERENCES users (id);