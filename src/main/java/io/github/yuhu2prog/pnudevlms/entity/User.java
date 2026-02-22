package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @Setter(AccessLevel.NONE)
    @Builder.Default
    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private Set<Class> ownClasses = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @Builder.Default
    @ManyToMany(mappedBy = "participants")
    @ToString.Exclude
    private Set<Class> classes = new HashSet<>();

    @Setter(AccessLevel.NONE)
    @Builder.Default
    @OneToMany(mappedBy = "owner")
    @ToString.Exclude
    private Set<Test> tests = new HashSet<>();
}