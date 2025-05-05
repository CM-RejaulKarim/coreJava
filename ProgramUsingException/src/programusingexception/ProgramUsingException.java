
package programusingexception;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramUsingException {

    
    public static void main(String[] args) {
       
        
        try {
            PrintWriter pw = new PrintWriter("C:\\Users\\Admin\\Desktop\\FileClass\\New folder");   //evenNumber.txt
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
}
