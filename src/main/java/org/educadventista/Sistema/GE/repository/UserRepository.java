package org.educadventista.Sistema.GE.repository;

import org.educadventista.Sistema.GE.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
