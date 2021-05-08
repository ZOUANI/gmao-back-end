package com.example.demo.provided;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gmao/User-api")
public class UserProvided {
    @Autowired
    private UserService userService;
    @GetMapping("login/{login}/pswrd/password")
    public User findByLoginAndPassword(String login, String password) {
        return userService.findByLoginAndPassword(login, password);
    }
    @GetMapping("role/{role}")
    public List<User> findByRole(String role) {
        return userService.findByRole(role);
    }
    @GetMapping("utilisateur/{code}")
    public User findByUtilisateur(String code) {
        return userService.findByUtilisateur(code);
    }

    @DeleteMapping("login/{login}/pswrd/password")
    public int deleteByLoginAndPassword(String login, String password) {
        return userService.deleteByLoginAndPassword(login, password);
    }

    @DeleteMapping("utilisateur/{code}")
    public int deleteByUtilisateur(String code) {
        return userService.deleteByUtilisateur(code);
    }
    @PostMapping("/")
    public int register(User user) {
        return userService.register(user);
    }
}
