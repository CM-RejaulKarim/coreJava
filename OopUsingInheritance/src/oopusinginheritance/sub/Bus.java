
package oopusinginheritance.sub;

import oopusinginheritance.ex.Vehicle;

public class Bus extends Vehicle{
   
    private int totalSeat;

    public Bus() {
    }

    public Bus(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public Bus(int totalSeat, String brand, int speed, double regularPrice) {
        super(brand, speed, regularPrice);
        this.totalSeat = totalSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }
    
    
    
}
