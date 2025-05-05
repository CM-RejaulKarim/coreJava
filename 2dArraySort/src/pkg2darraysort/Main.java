package pkg2darraysort;

import java.util.Arrays;

public class Main {

        public static void sortRows(int[][] mat) {
        for (int[] row : mat) {
            Arrays.sort(row);
        }
    }

    public static void main(String[] args) {
        int[][] myArray = {
            {1, 99, 91, 11, 44},
            {0, 10, 9, 9, 11},
            {3, 23, 21, 5, 20},
            {11, 0, 1, 20, 56}
        };

        sortRows(myArray);

        
        for (int[] row : myArray) {
            System.out.print("  [");
            for (int j = 0; j < row.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(row[j]);
            }
            System.out.println("]");
        }
       
    }
    

}
