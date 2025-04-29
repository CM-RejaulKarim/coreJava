package subsupmethod.spec;

import subsupmethod.main.Vehicle;

public class Truck extends Vehicle {

    private int weight;

    public Truck() {
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int weight, int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {

        if (this.weight > 2000) {
//            System.out.println("Price is: "+ (getRegularPrice() - (getRegularPrice() * .1)));
            return super.getRegularPrice() - (getRegularPrice() * .1);
        } else {
//            System.out.println("Price is: "+getRegularPrice());
            return super.getRegularPrice();
        }

    }

}
