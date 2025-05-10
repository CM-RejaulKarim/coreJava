/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department.manager;

/**
 *
 * @author Admin
 */
public class Manager extends Employees{
    private int teamSize;

    public Manager() {
    }

    public Manager(int teamSize) {
        this.teamSize = teamSize;
    }

    public Manager(int teamSize, String name, int id, double slary) {
        super(name, id, slary);
        this.teamSize = teamSize;
    }

    @Override
    public void employeeDetails() {
        super.employeeDetails(); 
        System.out.println("Team Size: "+ teamSize);
    }

    @Override
    public String toString() {
        return "Manager{"+"Employee Name: "+super.getName()+" Id: "+super.getId()+" Salary: "+super.getSalary() + " teamSize=" + teamSize + '}';
    }
    
    
    
}
