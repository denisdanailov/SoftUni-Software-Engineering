package softuni.bg.mobilelele.service;

import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.model.service.UserRegistrationServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void logout();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);
}
