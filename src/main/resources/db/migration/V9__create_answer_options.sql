CREATE SEQUENCE IF NOT EXISTS answer_options_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE answer_options
(
    id          BIGINT                NOT NULL,
    question_id BIGINT                NOT NULL,
    text        VARCHAR(255),
    image_path  TEXT,
    is_correct  BOOLEAN DEFAULT FALSE NOT NULL,
    CONSTRAINT pk_answer_options PRIMARY KEY (id)
);

ALTER TABLE answer_options
    ADD CONSTRAINT FK_ANSWER_OPTIONS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES questions (id);