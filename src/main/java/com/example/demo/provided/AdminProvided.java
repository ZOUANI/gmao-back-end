package com.example.demo.provided;

import com.example.demo.bean.Admin;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/admin")
public class AdminProvided {
    @Autowired
    private AdminService adminService;


    @GetMapping("/login/{login}")
    public Admin findByLogin(@PathVariable String login) {
        return adminService.findByLogin(login);
    }

    @PostMapping("/")
    public int save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PostMapping("/seconnecter")
    public Admin SeConnecter(@RequestBody Admin admin) {
        return adminService.SeConnecter(admin);
    }

}
