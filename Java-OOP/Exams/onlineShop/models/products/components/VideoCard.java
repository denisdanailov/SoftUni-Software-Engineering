package onlineShop.models.products.components;

public class VideoCard extends BaseComponent {
    private double baseMultiplier= 1.15;

    public VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
        setBaseMultiplier(overallPerformance);
    }

    public void setBaseMultiplier(double multiplier) {
        this.baseMultiplier += multiplier;
    }
}
