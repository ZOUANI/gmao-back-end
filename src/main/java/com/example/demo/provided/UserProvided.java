package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Gmao/User-api")
public class UserProvided {
    @Autowired
    private UserService userService;

    @GetMapping("/login/{login}/pswrd/{password}")
    public User findByLoginAndPassword(@PathVariable String login, @PathVariable String password) {
        return userService.findByLoginAndPassword(login, password);
    }

    @GetMapping("/role/{role}")
    public List<User> findByRole(@PathVariable String role) {
        return userService.findByRole(role);
    }

    @GetMapping("/utilisateur/{code}")
    public User findByUtilisateur(@PathVariable String code) {
        return userService.findByUtilisateur(code);
    }

    @DeleteMapping("/login/{login}/pswrd/{password}")
    public int deleteByLoginAndPassword(@PathVariable String login, @PathVariable String password) {
        return userService.deleteByLoginAndPassword(login, password);
    }

    @DeleteMapping("/utilisateur/{code}")
    public int deleteByUtilisateur(@PathVariable String code) {
        return userService.deleteByUtilisateur(code);
    }

    @PostMapping("/")
    public int register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/connected/{login}/pswrd/{password}")
    public int IsConnected(@PathVariable String login, @PathVariable String password) {
        return userService.IsConnected(login, password);
    }
}
