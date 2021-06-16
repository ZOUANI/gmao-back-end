package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByLoginAndPassword(String login,String password);
    List<User> findByRole(String role);
    User findByCollaborateurCodeCollaborateur(String code);
    int deleteByLoginAndPassword(String login,String password);
    int deleteByCollaborateurCodeCollaborateur(String code);
    User findByLogin(String login);
}
