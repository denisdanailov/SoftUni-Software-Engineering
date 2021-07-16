package Encapsulation_Exercise.ShoppingSpree;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.length() <= 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        bagOfProducts.add(product);
    }
}
