package subsupmethod;

import subsupmethod.spec.Truck;

public class SubSupMethod {

    public static void main(String[] args) {

        Truck t = new Truck();

        t.setRegularPrice(100);
        t.setWeight(2001);

//        t.getSalePrice();
        System.out.println("Price is: " + t.getSalePrice());
    }

}
