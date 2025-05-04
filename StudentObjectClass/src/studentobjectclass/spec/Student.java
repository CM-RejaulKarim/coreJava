package studentobjectclass.spec;

import studentobjectclass.sclass.Person;

public class Student extends Person {

    private int studentId;

    public Student() {
    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public Student(int studentId, String name, int age) {
        super(name, age);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Student id : "+ studentId);
    }

    
    
}
