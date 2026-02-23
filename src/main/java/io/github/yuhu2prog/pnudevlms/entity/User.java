package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotBlank
    @Column(name = "email", columnDefinition = "text", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(name = "password", columnDefinition = "text", nullable = false)
    private String password;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "avatar_image_path", columnDefinition = "text")
    private String avatarImagePath;

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private Set<Class> ownClasses = new HashSet<>();

    @NotNull
    @Builder.Default
    @ManyToMany(mappedBy = "participants")
    @ToString.Exclude
    private Set<Class> classes = new HashSet<>();

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private Set<Test> tests = new HashSet<>();

    @NotNull
    @Builder.Default
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<AttemptResult> attemptResults = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}