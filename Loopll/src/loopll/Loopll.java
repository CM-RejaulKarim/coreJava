package loopll;

import java.util.Scanner;

public class Loopll {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int limit = s.nextInt();
        for (int i = 0; i < limit; i++) {

            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();

            int sum = a;
            int power = 1;

            for (int j = 0; j < n; j++) {
                power = j*j;
                        
                sum += power * b;
                System.out.print(sum + " ");

            }
            System.out.println();

        }
        
        
//        Scanner s = new Scanner(System.in);
//        int limit = s.nextInt();
//        for (int i = 0; i < limit; i++) {
//
//            int a = s.nextInt();
//            int b = s.nextInt();
//            int n = s.nextInt();
//
//            int sum = a;
//
//            for (int j = 0; j < n; j++) {
//
//                sum += Math.pow(2, j) * b;
//                System.out.print(sum + " ");
//
//            }
//            System.out.println();
//
//        }
    }

}
