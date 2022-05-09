package softuni.bg.mobilelele.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.model.service.UserRegistrationServiceModel;
import softuni.bg.mobilelele.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void initializeUsersAndRoles() {

    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {


    }
}
