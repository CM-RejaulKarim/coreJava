package department;

import department.manager.Manager;

public class Department {

    public static void main(String[] args) {

        Manager manager = new Manager(12, "reja", 7759, 12500);
        
        System.out.println(manager);
    }

}
