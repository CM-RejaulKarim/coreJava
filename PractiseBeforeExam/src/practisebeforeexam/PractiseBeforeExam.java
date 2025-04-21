package practisebeforeexam;

import java.util.Arrays;
import java.util.Scanner;

public class PractiseBeforeExam {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter a Positive Number for Fibonacci...");
        int inp = s.nextInt();

        int n1 = 0;
        int n2 = 1;
        System.out.println(n1);
        System.out.println(n2);
        int sum = 0;

        for (int index = 3; index <= inp; index++) {

            sum = n1 + n2;
            System.out.println(sum);
            n1 = n2;
            n2 = sum;

        }
        System.out.println("\n enter a Positive Number for Check whether it is prime or not ?...");
        int num = s.nextInt();
        isPrime(num);
    }

    public static void isPrime(int num) {

        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println(num + " is Prime Number");
        } else {
            System.out.println(num + " is not Prime Number");
        }

        System.out.println("\n Enter Your limit to Calculate how Many Numbers You want to Input...");
        int l = s.nextInt();

        minAndMax(l);
    }

    public static void minAndMax(int size) {

        int[] numbers = new int[size];

        for (int index = 0; index < numbers.length; index++) {
            System.out.println("Enter " + (index + 1)+numSeq(index) + " Number.");
            int inp = s.nextInt();
            numbers[index] = inp;
        }
        System.out.println("You Entered: " + Arrays.toString(numbers));

        int maxNum = numbers[0];
        int minNum = numbers[0];

        for (int number : numbers) {
            if (number > maxNum) {
                maxNum = number;
            }
            if (number < minNum) {
                minNum = number;

            }
        }
        System.out.println("Max Number is: " + maxNum);
        System.out.println("Min Number is: " + minNum);

        System.out.println("\n Enter total Price...");
        double price = s.nextDouble();
        discountCalculate(price);
    }

    public static void discountCalculate(double price) {

        float discountPercentage = 0.05f;
        double discount = price * discountPercentage;
        double actualPrice = price - discount;

        if (price > 200) {
            System.out.println("Discount is: " + discount + " and \n Actual Price is: " + actualPrice);
        } else {
            System.out.println("Discount is: " + discount + " and \n Actual Price is: " + actualPrice);
        }

        System.out.println("\n Enter Your Target, how Many Numbers You want to Input...");
        int bb = s.nextInt();

        bblSort(bb);
    }

    public static void bblSort(int size) {
        
        int[] myArr = new int[size];
        
        for (int index = 0; index < myArr.length; index++) {
            System.out.println("Enter "+(index+1)+numSeq(index)+ " Number");
            int inp = s.nextInt();
            myArr[index] = inp;
        }
        System.out.println("Before Bubble Sort: "+Arrays.toString(myArr));
        
        for (int i = 0; i < myArr.length-1; i++) {
            for (int j = 0; j < myArr.length-1-i; j++) {
                if (myArr[j] > myArr[j+1]) {
                    int temp = myArr[j+1];
                    myArr[j+1] = myArr[j];
                    myArr[j] = temp;
                }
            }
        }
        System.out.println("After Bubble Sort: "+Arrays.toString(myArr));

    }
    public static String numSeq(int num){
        String val = "";
        
        switch (num+1) {
            case 1:
                val = "st";
                break;
            case 2:
                val = "nd";
                break;
            case 3:
                val = "rd";
                break;
            default:
                val = "th";
        }
        
        return val;
    }

}
