package com.example.demo.dao;


import com.example.demo.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
    public Admin findByLogin(String login);
    public Admin findByLoginAndPassword(String login,String password);
}
