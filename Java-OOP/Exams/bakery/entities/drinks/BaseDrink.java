package bakery.entities.drinks;

import bakery.entities.drinks.interfaces.Drink;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseDrink implements Drink {
    private String name;
    private int portion;
    private String brand;
    private double price;

    public BaseDrink(String name, int portion, String brand, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setBrand(brand);
        this.setPrice(price);

    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(int portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if (price <= 0 ) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return  this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv",
                this.name,this.brand,this.portion, this.price);
    }
}
