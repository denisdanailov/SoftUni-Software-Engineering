package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.BaseDrink;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.BaseTable;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.DrinkRepositoryImpl;
import bakery.repositories.FoodRepositoryImpl;
import bakery.repositories.TableRepositoryImpl;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = new FoodRepositoryImpl();
        this.drinkRepository = new DrinkRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
        this.totalIncome = 0.0;

    }


    @Override
    public String addFood(String type, String name, double price) {

        BakedFood bakedFood = null;
        switch (type) {
            case "Bread":
                bakedFood = new Bread(name, price);
                break;
            case "Cake":
                bakedFood = new Cake(name, price);
                break;
        }

        if (foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(FOOD_OR_DRINK_EXIST);
        }
        foodRepository.add(bakedFood);

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        BaseDrink baseDrink = null;
        switch (type) {
            case "Tea":
                baseDrink = new Tea(name, portion, brand);
                break;
            case "Water":
                baseDrink = new Water(name, portion, brand);
                break;
        }
        if (drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(FOOD_OR_DRINK_EXIST);
        }
        drinkRepository.add(baseDrink);

        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        BaseTable baseTable = null;

        switch (type) {
            case "InsideTable":
                baseTable = new InsideTable(tableNumber, capacity);
                break;
            case "OutsideTable":
                baseTable = new OutsideTable(tableNumber, capacity);
                break;
        }

        tableRepository.add(baseTable);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

        Table table = tableRepository.getAll()
                .stream()
                .filter((t -> {
                    return !t.isReserved() && t.getCapacity() >= numberOfPeople;
                })).findFirst().orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        BakedFood bakedFood = foodRepository.getByName(foodName);

        if (bakedFood == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        table.orderFood(bakedFood);

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = tableRepository.getByNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);

        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {

        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        table.clear();
        this.totalIncome += bill;

        return String.format(BILL, table.getTableNumber(), bill);
    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTables = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved())
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();

        for (Table table : freeTables) {
            builder.append(table.getFreeTableInfo())
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
