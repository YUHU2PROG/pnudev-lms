package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @Column(name = "password", columnDefinition = "text")
    private String password;

    // todo role_id

    @NotBlank
    @Column(name = "avatar_image_path", columnDefinition = "text")
    private String avatarImagePath;
}