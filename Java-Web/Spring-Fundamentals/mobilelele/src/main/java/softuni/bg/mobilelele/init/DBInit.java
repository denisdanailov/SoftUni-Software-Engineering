package softuni.bg.mobilelele.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.bg.mobilelele.repository.BrandRepository;
import softuni.bg.mobilelele.repository.UserRepository;
import softuni.bg.mobilelele.service.BrandService;
import softuni.bg.mobilelele.service.UserService;

@Component
public class DBInit implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final BrandService brandService;

    public DBInit(PasswordEncoder passwordEncoder, UserService userService, BrandService brandService) {
        this.brandService = brandService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

       brandService.initializeBrandAndModels();
       userService.initializeUsers();

    }





}
