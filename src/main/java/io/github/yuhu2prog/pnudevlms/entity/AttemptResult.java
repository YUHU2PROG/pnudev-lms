package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attempt_results")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttemptResult {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "test_assignment_id", nullable = false)
    private TestAssignment testAssignment;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "start_date", nullable = false, columnDefinition = "timestamptz")
    private Instant startDate;

    @Column(name = "end_date", columnDefinition = "timestamptz")
    private Instant endDate;

    @Column(name = "total_score")
    private Long totalScore;

    @NotNull
    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "attempt_results_answer_options",
            joinColumns = @JoinColumn(name = "attempt_result_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "answer_option_id", nullable = false)
    )
    private Set<AnswerOption> answerOptions = new HashSet<>();
}
