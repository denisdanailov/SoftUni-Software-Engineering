package softuni.bg.mobilelele.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.mobilelele.model.entity.BrandEntity;
import softuni.bg.mobilelele.model.entity.ModelEntity;
import softuni.bg.mobilelele.model.entity.enums.CategoryEnum;
import softuni.bg.mobilelele.repository.BrandRepository;
import softuni.bg.mobilelele.service.BrandService;

import java.time.Instant;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeBrandAndModels() {

        if (brandRepository.count() == 0) {
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


            ford.setModels(List.of(fiesta, escort));

            brandRepository.save(ford);
        }
    }
}
