package io.github.yuhu2prog.pnudevlms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserCreateDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
}
