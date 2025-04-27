package learnfileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class LearnFileClass {

    public static void main(String[] args) {

//        File f = new File("C:\\Users\\user\\Desktop\\Java Store\\FileClass\\FileClass.txt");
        Scanner s = new Scanner(System.in);

        System.out.println("Enter limit...");
        int size = s.nextInt();

        PrintWriter pw = null;
        try {

            for (int i = 1; i <= size; i++) {
                System.out.println("Enter your Subject...");
                String sub = s.next();
                pw = new PrintWriter("C:\\Users\\user\\Desktop\\Java Store\\FileClass\\" + sub + ".txt");

                pw.println("Hello World.");
                pw.println("Hello Java.");
                pw.println("Hello FileClass.");

                System.out.println("Enter Subject details...");
                s.nextLine();
                String detail = s.nextLine();
                pw.println(detail);

                pw.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LearnFileClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

}
