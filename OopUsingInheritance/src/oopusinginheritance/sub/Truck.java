package oopusinginheritance.sub;

import oopusinginheritance.ex.Vehicle;

public class Truck extends Vehicle {

    private int weight;

    public Truck() {
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int weight, String brand, int speed, double regularPrice) {
        super(brand, speed, regularPrice);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void calculateActualPrice() {

        if (this.weight > 2500) {
            double result = getRegularPrice() - (getRegularPrice() * .10);
            System.out.println("The actual price with discount: "+result);
        }
        else{
            System.out.println("The actual price: "+getRegularPrice());
        }

    }

}
