package com.gamestore.services;

import com.gamestore.entities.users.LoginDTO;
import com.gamestore.entities.users.RegisterDTO;
import com.gamestore.entities.users.User;

public interface UserService {

    User register(RegisterDTO registerData);

    User login(LoginDTO loginDTO);

    void logout();
}
