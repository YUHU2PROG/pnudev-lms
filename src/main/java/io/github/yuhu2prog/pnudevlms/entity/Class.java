package io.github.yuhu2prog.pnudevlms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classes")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    public User owner;

    @NotBlank
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name = "wallpaper_image_path", columnDefinition = "text")
    private String wallpaperImagePath;

    @NotBlank
    @Column(name = "invite_code", unique = true)
    private String inviteCode;

    @NotNull
    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "classes_participants",
            joinColumns = @JoinColumn(name = "class_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false)
    )
    @ToString.Exclude
    private Set<User> participants = new HashSet<>();
}
