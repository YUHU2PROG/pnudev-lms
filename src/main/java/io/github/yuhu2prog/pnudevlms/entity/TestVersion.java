package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "test_versions")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestVersion {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "testVersion")
    @ToString.Exclude
    private Set<Question> questions = new HashSet<>();

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "testVersion")
    private Set<TestAssignment> testAssignments = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestVersion that)) return false;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
