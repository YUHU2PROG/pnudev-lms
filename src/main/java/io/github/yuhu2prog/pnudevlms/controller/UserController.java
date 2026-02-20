package io.github.yuhu2prog.pnudevlms.controller;

import io.github.yuhu2prog.pnudevlms.dto.UserCreateDTO;
import io.github.yuhu2prog.pnudevlms.dto.UserResponseDTO;
import io.github.yuhu2prog.pnudevlms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }
}
