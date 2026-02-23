package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "sessions")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "session_token_hash", nullable = false, columnDefinition = "text")
    private String sessionTokenHash;

    @NotNull
    @Column(name = "expires_at", nullable = false, columnDefinition = "timestamptz")
    private Instant expiresAt;

    @NotNull
    @Column(name = "started_at", nullable = false, columnDefinition = "timestamptz")
    private Instant startedAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "current_question_id", nullable = false)
    private Question question;

    @NotNull
    @OneToOne(mappedBy = "session")
    private AttemptResult attemptResult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session session)) return false;
        return id != null && Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
