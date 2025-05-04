package studentobjectclass;

import studentobjectclass.spec.Student;

public class StudentObjectClass {

    public static void main(String[] args) {

        Student s = new Student(1287759, "Reja", 25);
        Student r = new Student();
        
        r.setName("atik");
        r.setAge(26);
        r.setStudentId(1287700);
        
        r.printDetails();
        
        System.out.println("\n");
        
        s.printDetails();
    }

}
