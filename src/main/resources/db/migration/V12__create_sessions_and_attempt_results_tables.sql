CREATE SEQUENCE IF NOT EXISTS attempt_results_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS sessions_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE attempt_results
(
    id                 BIGINT                   NOT NULL,
    test_assignment_id BIGINT                   NOT NULL,
    session_id         BIGINT,
    user_id            BIGINT                   NOT NULL,
    start_date         TIMESTAMP WITH TIME ZONE NOT NULL,
    end_date           TIMESTAMP WITH TIME ZONE,
    total_score        BIGINT,
    CONSTRAINT pk_attempt_results PRIMARY KEY (id)
);

CREATE TABLE attempt_results_answer_options
(
    answer_option_id  BIGINT NOT NULL,
    attempt_result_id BIGINT NOT NULL,
    CONSTRAINT pk_attempt_results_answer_options PRIMARY KEY (answer_option_id, attempt_result_id)
);

CREATE TABLE sessions
(
    id                  BIGINT                   NOT NULL,
    session_token_hash  TEXT                     NOT NULL,
    expires_at          TIMESTAMP WITH TIME ZONE NOT NULL,
    started_at          TIMESTAMP WITH TIME ZONE NOT NULL,
    current_question_id BIGINT                   NOT NULL,
    CONSTRAINT pk_sessions PRIMARY KEY (id)
);

ALTER TABLE attempt_results
    ADD CONSTRAINT uc_attempt_results_session UNIQUE (session_id);

ALTER TABLE attempt_results
    ADD CONSTRAINT FK_ATTEMPT_RESULTS_ON_SESSION FOREIGN KEY (session_id) REFERENCES sessions (id);

ALTER TABLE attempt_results
    ADD CONSTRAINT FK_ATTEMPT_RESULTS_ON_TEST_ASSIGNMENT FOREIGN KEY (test_assignment_id) REFERENCES tests_assignments (id);

ALTER TABLE attempt_results
    ADD CONSTRAINT FK_ATTEMPT_RESULTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE sessions
    ADD CONSTRAINT FK_SESSIONS_ON_CURRENT_QUESTION FOREIGN KEY (current_question_id) REFERENCES questions (id);

ALTER TABLE attempt_results_answer_options
    ADD CONSTRAINT fk_attresansopt_on_answer_option FOREIGN KEY (answer_option_id) REFERENCES answer_options (id);

ALTER TABLE attempt_results_answer_options
    ADD CONSTRAINT fk_attresansopt_on_attempt_result FOREIGN KEY (attempt_result_id) REFERENCES attempt_results (id);

ALTER TABLE tests_assignments
    ALTER COLUMN start_date TYPE TIMESTAMP WITH TIME ZONE,
    ALTER COLUMN end_date TYPE TIMESTAMP WITH TIME ZONE;