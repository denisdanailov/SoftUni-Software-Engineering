package onlineShop.models.products.components;

public class Motherboard extends BaseComponent{
    private double baseMultiplier= 1.25;

    public Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
        setBaseMultiplier(overallPerformance);
    }

    public void setBaseMultiplier(double multiplier) {
        this.baseMultiplier += multiplier;
    }
}
