package softuni.bg.mobilelele.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.bg.mobilelele.model.entity.BrandEntity;
import softuni.bg.mobilelele.model.entity.ModelEntity;
import softuni.bg.mobilelele.model.entity.UserEntity;
import softuni.bg.mobilelele.model.entity.enums.CategoryEnum;
import softuni.bg.mobilelele.repository.BrandRepository;
import softuni.bg.mobilelele.repository.UserRepository;

import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        initializeBrandAndModels();
        initializeUsers();

    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin.setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("test"));

            userRepository.save(admin);
        }
    }

    private void initializeBrandAndModels() {
        if(brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford").setCreated(Instant.now());

            ModelEntity fiesta = new ModelEntity();
            fiesta.setBrand(ford)
                    .setCategory(CategoryEnum.CAR)
                    .setName("Fiesta");

            fiesta.setStartYear(1976)
                            .setImageUrl("https://www.gpas-cache.ford.com/guid/5a628479-89a0-354d-8fd4-77314e4c952b.png");

            ModelEntity escort = new ModelEntity();
            escort.setBrand(ford)
                            .setCategory(CategoryEnum.CAR)
                    .setStartYear(2006)
                    .setName("Escort");

                escort
                    .setImageUrl("https://imgr1.auto-motor-und-sport.de/01-2021MST-Escort-MK-II-169FullWidth-2385fa9b-1755976.jpg");



            ford.setModels(List.of(fiesta,escort));

            brandRepository.save(ford);
        }
    }
}
