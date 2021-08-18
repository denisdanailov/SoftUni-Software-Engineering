package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        foodOrders = new ArrayList<>();
        drinkOrders = new ArrayList<>();

    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.price = getPricePerPerson() * numberOfPeople;
        this.numberOfPeople = numberOfPeople;

    }

    @Override
    public void orderFood(BakedFood food) {
        if (isReserved) {
            this.foodOrders.add(food);
        }
    }

    @Override
    public void orderDrink(Drink drink) {
        if (isReserved) {
            this.drinkOrders.add(drink);
        }
    }

    @Override
    public double getBill() {
        double foodSum = this.foodOrders.stream()
                .mapToDouble(BakedFood::getPrice).sum();
        double drinkSum = this.drinkOrders.stream()
                .mapToDouble(Drink::getPrice).sum();

        return foodSum + drinkSum + this.getPrice();
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.price = 0;
        isReserved = false;
    }

    @Override
    public String getFreeTableInfo() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Table: %d", this.tableNumber)).append(System.lineSeparator());
        builder.append(String.format("Typ: %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append(String.format("Capacity: %d", this.capacity)).append(System.lineSeparator());
        builder.append(String.format("Price per Person: %.2f", this.pricePerPerson)).append(System.lineSeparator());


        return builder.toString().trim();
    }
}
