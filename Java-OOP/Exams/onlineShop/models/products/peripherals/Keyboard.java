package onlineShop.models.products.peripherals;

public class Keyboard extends BasePeripheral implements Peripheral {

    public Keyboard(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }

    @Override
    public String getConnectionType() {
        return null;
    }
}
