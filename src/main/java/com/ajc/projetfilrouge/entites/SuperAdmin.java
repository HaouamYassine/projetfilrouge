package com.ajc.projetfilrouge.entites;

public class SuperAdmin extends User{

    public SuperAdmin() {
    }

    public SuperAdmin(String username, String mail, String password, Boolean admin, Boolean activate) {
        setAdmin(true);
        setActivate(true);
    }


}
