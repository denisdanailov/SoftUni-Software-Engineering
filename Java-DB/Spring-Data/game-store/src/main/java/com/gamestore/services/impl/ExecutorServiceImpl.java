package com.gamestore.services.impl;

import com.gamestore.entities.users.LoginDTO;
import com.gamestore.entities.users.RegisterDTO;
import com.gamestore.entities.users.User;
import com.gamestore.services.ExecutorService;
import com.gamestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    private final UserService userService;

    @Autowired
    public ExecutorServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(String commandLine) {
        String[] commandParts = commandLine.split("\\|");

        String commandName = commandParts[0];

        String commandOutput = switch (commandName) {
            case REGISTER_USER_COMMAND -> {
                RegisterDTO registerData = new RegisterDTO(commandParts);
                User user = userService.register(registerData);

                yield String.format("%s was registered", user.getFullName());
            }
            case LOGIN_USER_COMMAND -> {
                LoginDTO loginData = new LoginDTO(commandParts);
                User user = userService.login(loginData);

                yield String.format("Successfully logged in %s", user.getFullName());

            }
            default -> "unknown command";
        };

        return commandOutput;
    }
}
