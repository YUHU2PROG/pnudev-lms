CREATE SEQUENCE IF NOT EXISTS tests_assignments_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE tests_assignments
(
    id              BIGINT                      NOT NULL,
    test_version_id BIGINT                      NOT NULL,
    class_id        BIGINT                      NOT NULL,
    start_date      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_date        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_tests_assignments PRIMARY KEY (id)
);

ALTER TABLE tests_assignments
    ADD CONSTRAINT FK_TESTS_ASSIGNMENTS_ON_CLASS FOREIGN KEY (class_id) REFERENCES classes (id);

ALTER TABLE tests_assignments
    ADD CONSTRAINT FK_TESTS_ASSIGNMENTS_ON_TEST_VERSION FOREIGN KEY (test_version_id) REFERENCES test_versions (id);