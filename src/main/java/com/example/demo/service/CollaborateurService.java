package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Collaborateur;
import com.example.demo.dao.CollaborateurDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurService {

    @Autowired
    private CollaborateurDao collaborateurDao;

    public Collaborateur findByFullname(String fullname) {
        return collaborateurDao.findByFullname(fullname);
    }

    public Collaborateur findByCodeCollaborateur(String codeCollaborateur) {
        return collaborateurDao.findByCodeCollaborateur(codeCollaborateur);
    }

    public Collaborateur findByLogin(String login) {
        return collaborateurDao.findByLogin(login);
    }

    public Collaborateur findByLoginAndPassword(String login, String password) {
        return collaborateurDao.findByLoginAndPassword(login, password);
    }

    public List<Collaborateur> findAll() {
        return collaborateurDao.findAll();
    }

    public int save(Collaborateur collaborateur) {
        if (collaborateurDao.findByCodeCollaborateur(collaborateur.getCodeCollaborateur()) != null) {
            return -1;
        } else {
            collaborateurDao.save(collaborateur);
            return 1;
        }
    }

    public Collaborateur signin(String login, String passowrd) {
        return findByLoginAndPassword(login, passowrd);
    }
}
