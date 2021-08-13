package CounterStriker.models.guns;

public class Pistol extends GunImpl implements Gun {


    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    private static final int BULLETS_TO_SHOOT = 1;


    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_TO_SHOOT);
        return BULLETS_TO_SHOOT;

    }
}
