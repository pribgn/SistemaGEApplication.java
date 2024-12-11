package org.educadventista.Sistema.GE.controller;

import org.educadventista.Sistema.GE.entity.Users;
import org.educadventista.Sistema.GE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users users) {
        return userService.save(users);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
