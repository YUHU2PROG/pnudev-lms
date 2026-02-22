CREATE SEQUENCE IF NOT EXISTS configurations_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE configurations
(
    id                                    BIGINT                NOT NULL,
    test_assignment_id                    BIGINT                NOT NULL,
    shuffle_questions                     BOOLEAN DEFAULT FALSE NOT NULL,
    shuffle_answers                       BOOLEAN DEFAULT FALSE NOT NULL,
    time_limit_minutes                    SMALLINT,
    show_correct_answer_immediately       BOOLEAN DEFAULT FALSE NOT NULL,
    show_correct_answers_after_finish     BOOLEAN DEFAULT FALSE NOT NULL,
    limit_attempts                        SMALLINT,
    allow_changing_answers_after_accepted BOOLEAN DEFAULT FALSE NOT NULL,
    allow_navigation_between_questions    BOOLEAN DEFAULT FALSE NOT NULL,
    CONSTRAINT pk_configurations PRIMARY KEY (id)
);

ALTER TABLE configurations
    ADD CONSTRAINT uc_configurations_test_assignment UNIQUE (test_assignment_id);

ALTER TABLE configurations
    ADD CONSTRAINT FK_CONFIGURATIONS_ON_TEST_ASSIGNMENT FOREIGN KEY (test_assignment_id) REFERENCES tests_assignments (id);