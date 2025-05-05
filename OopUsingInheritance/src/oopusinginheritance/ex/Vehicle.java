package oopusinginheritance.ex;

public class Vehicle {

    private String brand;
    private int speed;
    private double regularPrice;

    public Vehicle() {
    }

    public Vehicle(String brand, int speed, double regularPrice) {
        this.brand = brand;
        this.speed = speed;
        this.regularPrice = regularPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void calculateActualPrice() {
        System.out.println(regularPrice);
    }

}
