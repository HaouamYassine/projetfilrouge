package com.ajc.projetfilrouge.dao;

public class DaoFactory {
    public static UserDao getUserDao(){

        return new UserJpaDao();
    }

}