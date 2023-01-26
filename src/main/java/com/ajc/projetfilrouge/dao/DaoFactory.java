package com.ajc.projetfilrouge.dao;

public class DaoFactory {
    public static UserDao getPastryDao(){
        return new UserJpaDao();
    }

}