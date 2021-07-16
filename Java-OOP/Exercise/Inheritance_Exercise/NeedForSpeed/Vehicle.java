package Inheritance_Exercise.NeedForSpeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public void drive(double kilometers) {
        double consumedFuel = kilometers * this.getFuelConsumption();
        if (this.fuel >= consumedFuel) {
            double leftFuel = this.fuel - consumedFuel;
            this.setFuel(leftFuel);
        }

    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public double getHorsePower() {
        return this.horsePower;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
