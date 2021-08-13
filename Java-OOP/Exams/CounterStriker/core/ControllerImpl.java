package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Gun> gunRepository;
    private Repository<Player> playerRepository;
    private Field fields;


    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.playerRepository = new PlayerRepository();
        this.fields = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {


        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_GUN_NAME);
        }

        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        gunRepository.add(gun);

        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {

        Gun gun = this.gunRepository.findByName(gunName);

        Player player;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        playerRepository.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        Collection<Player> players =
                this.playerRepository
                .getModels()
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());

        return this.fields.start(players);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        this
                .playerRepository
                .getModels()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
                    if (result == 0) {
                        result = Integer.compare(p2.getHealth(), p1.getHealth());
                    }
                    if (result == 0) {
                        result = p1.getUsername().compareTo(p2.getUsername());
                    }
                    return result;
                })
                .forEach(p -> sb
                        .append(p.toString())
                        .append(System.lineSeparator()));


        return sb.toString().trim();
    }
}
