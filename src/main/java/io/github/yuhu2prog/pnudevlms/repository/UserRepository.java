package io.github.yuhu2prog.pnudevlms.repository;

import io.github.yuhu2prog.pnudevlms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
