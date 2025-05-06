
package testmaps.student;


public class Student {
    
    private int id;
    private String Name;
    private String email;

    public Student() {
    }

    public Student(int id, String Name, String email) {
        this.id = id;
        this.Name = Name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", Name=" + Name + ", email=" + email + '}';       //+"\n"
    }
    
    
}
