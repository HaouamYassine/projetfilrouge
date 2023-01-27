package com.ajc.projetfilrouge.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {//Création d'un utilisateur et de ses attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean admin;
    private String username;
    private String mail;
    private String password;

    // CONSTRUCTEURS


    //Besoin d'un constructeur vide pour la DAO
    public User() {
    }


    public User(String username, String mail, String password, Boolean admin) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
    }




    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }


    //GETTERS & SETTERS
    // + BOOLEAN ADMIN

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
