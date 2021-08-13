package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun> {
       private List<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.guns;
    }

    @Override
    public void add(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        guns.add(gun);
    }

    @Override
    public boolean remove(Gun gun) {
        return this.guns.remove(gun);
    }

    @Override
    public Gun findByName(String name) {

        return this.guns.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
