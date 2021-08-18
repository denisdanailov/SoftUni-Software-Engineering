package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> bakedFoods;

    public FoodRepositoryImpl() {
        this.bakedFoods = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return bakedFoods.stream().filter(f -> f.getName()
                .equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return this.bakedFoods;
    }

    @Override
    public void add(BakedFood bakedFood) {
            bakedFoods.add(bakedFood);
    }
}
