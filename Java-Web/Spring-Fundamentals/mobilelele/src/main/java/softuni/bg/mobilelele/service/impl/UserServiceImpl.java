package softuni.bg.mobilelele.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.model.entity.UserEntity;
import softuni.bg.mobilelele.model.service.UserLoginServiceModel;
import softuni.bg.mobilelele.model.service.UserRegistrationServiceModel;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.sec.CurrentUser;
import softuni.bg.mobilelele.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void initializeUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin.setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("testtest"));

            userRepository.save(admin);
        }
    }

    @Override
    public void login(Long id, String username) {
        currentUser.setId(id).setUsername(username);
    }

    @Override
    public void logout() {

    }

    @Override
    public void registerUser(UserRegistrationServiceModel userRegistrationServiceModel) {

        UserEntity newUser = new UserEntity();

        newUser
                .setUsername(userRegistrationServiceModel.getUsername())
                .setFirstName(userRegistrationServiceModel.getFirstName())
                .setLastName(userRegistrationServiceModel.getLastName())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setConfirmPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setActive(true);

        newUser = userRepository.save(newUser);

    }

    @Override
    public UserLoginServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserLoginServiceModel.class))
                .orElse(null);
    }
}


















