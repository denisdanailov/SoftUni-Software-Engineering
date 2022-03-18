package com.gamestore.services.impl;

import com.gamestore.entities.users.LoginDTO;
import com.gamestore.entities.users.RegisterDTO;
import com.gamestore.entities.users.User;
import com.gamestore.repositories.UserRepository;
import com.gamestore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterDTO registerData) {
        ModelMapper mapper = new ModelMapper();
        User toRegister = mapper.map(registerData, User.class);

        long userCount = this.userRepository.count();

        if (userCount == 0) {
            toRegister.setAdmin(true);
        }

        return this.userRepository.save(toRegister);
    }



    @Override
    public User login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public void logout() {

    }
}
