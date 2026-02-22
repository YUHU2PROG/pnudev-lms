package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "test_version_id", nullable = false)
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
}
