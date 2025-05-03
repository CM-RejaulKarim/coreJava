package readandwritefromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadAndWriteFromFile {

    public static void main(String[] args) {

        File f = new File("C:\\Users\\Admin\\Desktop\\FileClass\\Gave.txt");

        try {
            PrintWriter pw = new PrintWriter(f);
            pw.write("Class Test in Afternoon 03 of may 2025...");
            System.out.println(pw);

            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndWriteFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Scanner read = new Scanner(f);
            System.out.println(read.nextLine());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndWriteFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
