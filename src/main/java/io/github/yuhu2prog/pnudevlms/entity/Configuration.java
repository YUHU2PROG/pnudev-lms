package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "configurations")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "test_assignment_id", unique = true)
    private TestAssignment testAssignment;

    @NotNull
    @Builder.Default
    @Column(name = "shuffle_questions", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean shuffleQuestions = false;

    @NotNull
    @Builder.Default
    @Column(name = "shuffle_answers", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean shuffleAnswers = false;

    @Column(name = "time_limit_minutes")
    private Short timeLimitMinutes;

    @NotNull
    @Builder.Default
    @Column(name = "show_correct_answer_immediately", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean showCorrectAnswerImmediately = false;

    @NotNull
    @Builder.Default
    @Column(name = "show_correct_answers_after_finish", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean showCorrectAnswersAfterFinish = false;

    @Column(name = "limit_attempts")
    private Short limitAttempts;

    @NotNull
    @Builder.Default
    @Column(name = "allow_changing_answers_after_accepted", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean allowChangingAnswersAfterAccepted = false;

    @NotNull
    @Builder.Default
    @Column(name = "allow_navigation_between_questions", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean allowNavigationBetweenQuestions = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Configuration that)) return false;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}