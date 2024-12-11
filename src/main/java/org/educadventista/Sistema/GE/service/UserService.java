package org.educadventista.Sistema.GE.service;

import org.educadventista.Sistema.GE.entity.Users;
import org.educadventista.Sistema.GE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users save(Users users) {
        return userRepository.save(users);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Users updateUser(Long id, Users updatedUser) {
        Optional<Users> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            Users existingUser = existingUserOptional.get();
            if (updatedUser.getUsername() != null) {
                existingUser.setUsername(updatedUser.getUsername());
            }
            if (updatedUser.getPassword() != null) {
                existingUser.setPassword(updatedUser.getPassword());
            }
            if (updatedUser.getRole() != null) {
                existingUser.setRole(updatedUser.getRole());
            }

            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
