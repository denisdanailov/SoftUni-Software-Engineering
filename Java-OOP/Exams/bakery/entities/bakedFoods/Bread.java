package bakery.entities.bakedFoods;

public class Bread extends BaseFood  {
    private static final int INITIAL_BREAD_PORTION = 200;

    public Bread(String name, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
