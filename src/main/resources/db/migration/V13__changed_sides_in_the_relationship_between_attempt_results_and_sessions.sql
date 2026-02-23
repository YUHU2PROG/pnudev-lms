ALTER TABLE attempt_results
    DROP CONSTRAINT fk_attempt_results_on_session;

ALTER TABLE sessions
    ADD attempt_result_id BIGINT;

ALTER TABLE sessions
    ALTER COLUMN attempt_result_id SET NOT NULL;

ALTER TABLE sessions
    ADD CONSTRAINT uc_sessions_attempt_result UNIQUE (attempt_result_id);

ALTER TABLE sessions
    ADD CONSTRAINT uc_sessions_current_question UNIQUE (current_question_id);

ALTER TABLE sessions
    ADD CONSTRAINT FK_SESSIONS_ON_ATTEMPT_RESULT FOREIGN KEY (attempt_result_id) REFERENCES attempt_results (id);

ALTER TABLE attempt_results
    DROP COLUMN session_id;