package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tests_assignments")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestAssignment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "test_version_id", nullable = false)
    private TestVersion testVersion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class assignment_class;

    @NotNull
    @Column(name = "start_date", nullable = false, columnDefinition = "timestamptz")
    private Instant startDate;

    @NotNull
    @Column(name = "end_date", nullable = false, columnDefinition = "timestamptz")
    private Instant endDate;

    @NotNull
    @OneToOne(mappedBy = "testAssignment")
    private Configuration configuration;

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "testAssignment")
    @ToString.Exclude
    private Set<AttemptResult> attemptResults = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestAssignment that)) return false;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
