package onlineShop.models.products.peripherals;

public class Mouse extends BasePeripheral implements Peripheral {

    public Mouse(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }

    @Override
    public String getConnectionType() {
        return null;
    }
}
