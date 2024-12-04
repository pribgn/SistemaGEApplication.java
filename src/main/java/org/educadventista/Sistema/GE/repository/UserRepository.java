package org.educadventista.Sistema.GE.repository;

import org.educadventista.Sistema.GE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
