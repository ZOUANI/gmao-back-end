package com.example.demo.service;

import com.example.demo.Util.EnvoyerEmail;
import com.example.demo.Util.random;
import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CollaborateurService collaborateurService;
    private EnvoyerEmail envoyerEmail=new EnvoyerEmail();
    private random Random= new random();
    String code;
    public User findByLoginAndPassword(String login, String password) {
        return userDao.findByLoginAndPassword(login, password);
    }
    public String forgotPassword(String email){
         code= this.Random.rndom();
        this.envoyerEmail.envoyer(email,code);
        return code;
    }
    public int isCodeTrue(String codeRequired){
        if(codeRequired.equals(code)){
            return 1;
        }
        else{
            return -2;
        }
    }
    public List<User> findByRole(String role) {
        return userDao.findByRole(role);
    }

    public User findByUtilisateur(String code) {
        return userDao.findByCollaborateurCodeCollaborateur(code);
    }
    @Transactional
     public int deleteByLoginAndPassword(String login, String password) {
        return userDao.deleteByLoginAndPassword(login, password);
    }
    @Transactional
    public int deleteByUtilisateur(String code) {
        return userDao.deleteByCollaborateurCodeCollaborateur(code);
    }
    public int register(User user){
        Collaborateur collaborateur=collaborateurService.findByCodeCollaborateur(user.getCollaborateur().getCodeCollaborateur());
        if(collaborateur!=null){
            user.setCollaborateur(collaborateur);
            userDao.save(user);
            return 1;
        }
        else {
            return -2;
        }
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public int IsConnected(String login, String password){
        User isCon=findByLoginAndPassword(login,password);
        if(isCon == null){
            return -1;
        }
        else{
            return 2;
        }
    }
    public int update(String login,String password){
        User user=findByLogin(login);
        user.setPassword(password);
        userDao.save(user);
        return 1;
    }
}
