/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department.manager;


public class Employees {
    
    private String name;
    private int id;
    private double salary;

    public Employees() {
    }

    public Employees(String name, int id, double slary) {
        this.name = name;
        this.id = id;
        this.salary = slary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void employeeDetails(){
        System.out.println("Employee Name: "+ name);
        System.out.println("Empolyee Id: "+ id);
        System.out.println("Empolyee Salary: "+ salary);
    
    }
    
}
