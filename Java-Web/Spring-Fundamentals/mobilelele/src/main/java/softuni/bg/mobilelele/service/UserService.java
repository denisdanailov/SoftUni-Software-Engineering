package softuni.bg.mobilelele.service;

import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.model.service.UserRegistrationServiceModel;


public interface UserService {

    void initializeUsers();

    void login(Long id, String username);

    void logout();

    void registerUser(UserRegistrationServiceModel userRegistrationServiceModel);

    UserLoginServiceModel findByUsernameAndPassword(String username, String password);
}
