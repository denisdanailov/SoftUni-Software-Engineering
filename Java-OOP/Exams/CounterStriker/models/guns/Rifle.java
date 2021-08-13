package CounterStriker.models.guns;

public class Rifle extends GunImpl implements Gun {

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    private static final int BULLETS_TO_SHOOT = 10;

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_TO_SHOOT);
        return BULLETS_TO_SHOOT;
    }
}
