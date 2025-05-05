
package oopusinginheritance;

import oopusinginheritance.sub.Bus;
import oopusinginheritance.sub.Truck;

public class OopUsingInheritance {

  
    public static void main(String[] args) {
      
        Bus bus = new Bus(36, "marcedees", 100, 15000);
        
        Truck truck = new Truck(3000, "Toyota", 80, 20000);
        
        truck.calculateActualPrice();
        
    }
    
}
