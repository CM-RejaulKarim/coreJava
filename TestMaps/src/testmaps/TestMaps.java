package testmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import testmaps.student.Student;

public class TestMaps {

    public static void main(String[] args) {

        
        Map<Integer,Student> stuDetails = new HashMap<>();
        
        stuDetails.put(1, new Student(1287759, "reja", "reja@gmail.com"));
        stuDetails.put(2, new Student(1287740, "atik", "a@gmail.com"));
        stuDetails.put(3, new Student(1287745, "sadiar", "sad@gmail.com"));
        stuDetails.put(4, new Student(1287769, "masud", "masud@gmail.com"));
        stuDetails.put(5, new Student(1287749, "rakib", "rakib@gmail.com"));
        
        System.out.println(stuDetails);
        
        
        Iterator<Map.Entry<Integer,Student>> li = stuDetails.entrySet().iterator();
        
        while (li.hasNext()) {            
            Map.Entry<Integer, Student> entry = li.next();
            
            System.out.println("Key: "+entry.getKey()+", Value: "+ entry.getValue());
        }
    }

}
