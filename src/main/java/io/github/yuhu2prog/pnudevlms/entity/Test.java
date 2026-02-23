package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tests")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;

    @NotBlank
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "test", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true)
    @ToString.Exclude
    private Set<TestVersion> testVersions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test test)) return false;
        return id != null && Objects.equals(id, test.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
