package vehiclecarandbike.sub;

import vehiclecarandbike.sup.Vehicle;

public class Car extends Vehicle{

    private int numberOfDoors;

    public Car() {
    }

    public Car(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Car(int numberOfDoors, String brand, int speed) {
        super(brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayProperties() {
        super.displayProperties();
        System.out.println("Number of Doors are: "+numberOfDoors);
    }
    
    
}
