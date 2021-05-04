package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.dao.CollaborateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurService {
    @Autowired
    private CollaborateurDao collaborateurDao;

    public Collaborateur findByCodeCollaborateur(String codeCollaborateur) {
        return collaborateurDao.findByCodeCollaborateur(codeCollaborateur);
    }
}
