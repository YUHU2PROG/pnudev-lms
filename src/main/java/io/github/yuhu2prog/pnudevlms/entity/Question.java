package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "questions")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "test_version_id")
    private TestVersion testVersion;

    @Column(name = "text")
    private String text;

    @Column(name = "image_path", columnDefinition = "text")
    private String imagePath;

    @NotNull
    @Column(name = "points_number", nullable = false)
    private Long pointsNumber;

    @NotNull
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, columnDefinition = "question_type DEFAULT 'SINGLE_CHOICE'")
    private QuestionType type = QuestionType.SINGLE_CHOICE;

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<AnswerOption> answerOptions = new HashSet<>();

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "question", orphanRemoval = true)
    @ToString.Exclude
    private Set<Session> sessions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question)) return false;
        return id != null && Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
