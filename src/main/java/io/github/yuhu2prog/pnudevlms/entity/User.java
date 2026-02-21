package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name", length = 50)
    private String name;

    @NotBlank
    @Column(name = "email", columnDefinition = "text")
    private String email;

    @NotBlank
    @Size(min = 8, max = 128)
    @Column(name = "password", columnDefinition = "text")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @ToString.Exclude
    private Role role;

    @NotBlank
    @Column(name = "avatar_image_path", columnDefinition = "text")
    private String avatarImagePath;

}