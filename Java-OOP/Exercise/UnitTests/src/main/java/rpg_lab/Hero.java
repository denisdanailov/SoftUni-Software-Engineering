package rpg_lab;

import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;



public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;

    public Hero(String name, int experience, Weapon axe) {
        this.name = name;
        this.experience = 0;
        this.weapon = new Axe(10, 10);
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
