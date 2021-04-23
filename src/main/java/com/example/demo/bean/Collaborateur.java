package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CodeCollaborateur;
    private String fullname;


    public double getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCollaborateur() {
        return CodeCollaborateur;
    }

    public void setCodeCollaborateur(String codeCollaborateur) {
        CodeCollaborateur = codeCollaborateur;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
