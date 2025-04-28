package datatype;

import java.util.Scanner;

public class DataType {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        for (int i = 1; i <= 1; i++) {

            try {
                long x = s.nextLong();

                System.out.println(x + " can be fitted in:");

                if (x >= -128 && x <= 127) {
                    System.out.println("* byte");
                };
                if (x >= -2147483648 && x <= 2147483647) {

                    System.out.println("* int");
                }
                if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {

                    System.out.println("* long");
                }
            } catch (Exception e) {
                System.out.println(s.next() + " can't be fitted anywhere.");
            }

        }
    }

}
