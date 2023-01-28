package com.ajc.projetfilrouge.dao;

import com.ajc.projetfilrouge.entites.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> getUserByName(String username);

    //

}

