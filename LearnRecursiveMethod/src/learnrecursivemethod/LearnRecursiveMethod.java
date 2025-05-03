package learnrecursivemethod;

import java.util.Scanner;

public class LearnRecursiveMethod {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
                                              
//        System.out.println(factorial(5));
        System.out.println("\n" + fibonacci(n));
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            System.out.println(n);
            return n * factorial(n - 1);
        }

    }

    public static long fibonacci(int n) {
//                            0,1,1,2,3,5,8,13,21,34,55;   Make an java example to read and write a input from file
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n -2);

    }

}
