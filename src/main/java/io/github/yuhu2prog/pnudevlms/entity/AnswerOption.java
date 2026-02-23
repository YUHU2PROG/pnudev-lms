package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "answer_options")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOption {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "text")
    private String text;

    @Column(name = "image_path", columnDefinition = "text")
    private String imagePath;

    @NotNull
    @Builder.Default
    @Column(name = "is_correct", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isCorrect = false;

    @NotNull
    @Builder.Default
    @ManyToMany(mappedBy = "answerOptions")
    @ToString.Exclude
    private Set<AttemptResult> attemptResults = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerOption that)) return false;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
