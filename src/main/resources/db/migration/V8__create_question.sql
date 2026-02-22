CREATE TYPE question_type AS ENUM ('SINGLE_CHOICE', 'MULTI_CHOICE');

CREATE SEQUENCE IF NOT EXISTS questions_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE questions
(
    id              BIGINT                                NOT NULL,
    test_version_id BIGINT                                NOT NULL,
    text            VARCHAR(255),
    image_path      TEXT,
    points_number   BIGINT                                NOT NULL,
    type            QUESTION_TYPE DEFAULT 'SINGLE_CHOICE' NOT NULL,
    CONSTRAINT pk_questions PRIMARY KEY (id)
);

ALTER TABLE questions
    ADD CONSTRAINT FK_QUESTIONS_ON_TEST_VERSION FOREIGN KEY (test_version_id) REFERENCES test_versions (id);