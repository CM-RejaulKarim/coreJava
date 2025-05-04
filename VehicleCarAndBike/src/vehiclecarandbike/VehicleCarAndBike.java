package vehiclecarandbike;

import vehiclecarandbike.sub.Bike;
import vehiclecarandbike.sub.Car;

public class VehicleCarAndBike {

    public static void main(String[] args) {

        Car c = new Car(4, "Toyota", 180);
        Bike b = new Bike();

        b.setBrand("Yamaha");
        b.setSpeed(220);
        b.setHasCarrier(Boolean.TRUE);

        c.displayProperties();

        System.out.println("\n");

        b.displayProperties();

    }

}
