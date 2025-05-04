package vehiclecarandbike.sub;

import vehiclecarandbike.sup.Vehicle;

public class Bike extends Vehicle{

    private Boolean hasCarrier;

    public Bike() {
    }

    public Bike(Boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

    public Bike(Boolean hasCarrier, String brand, int speed) {
        super(brand, speed);
        this.hasCarrier = hasCarrier;
    }

    public Boolean getHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(Boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayProperties() {
        super.displayProperties(); 
        System.out.println("Has a Carrier or Not: "+hasCarrier);
    }

    
    
    
}
