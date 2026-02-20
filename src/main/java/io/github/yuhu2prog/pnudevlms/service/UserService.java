package io.github.yuhu2prog.pnudevlms.service;

import io.github.yuhu2prog.pnudevlms.dto.UserCreateDTO;
import io.github.yuhu2prog.pnudevlms.dto.UserResponseDTO;
import io.github.yuhu2prog.pnudevlms.entity.User;
import io.github.yuhu2prog.pnudevlms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        User user = User.builder()
                .name(userCreateDTO.getName())
                .password(userCreateDTO.getPassword())
                .build();
        userRepository.save(user);
        return UserResponseDTO.builder().id(user.getId()).build();
    }
}
