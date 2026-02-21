package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @NonNull
    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NonNull
    @NotBlank
    @Column(name = "email", columnDefinition = "text", nullable = false)
    private String email;

    @NonNull
    @NotBlank
    @Size(min = 8, max = 128)
    @Column(name = "password", columnDefinition = "text", nullable = false)
    private String password;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @ToString.Exclude
    private Role role;

    @Column(name = "avatar_image_path", columnDefinition = "text")
    private String avatarImagePath;
}