package bubblesortusingalgorithm;

import java.util.Arrays;

public class BubbleSortUsingAlgorithm {

    public static void main(String[] args) {

        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        sort(list);
//        for (int i = 0; i < list.length; i++) {
//            System.out.print(list[i] + " ");
//        }


        
    }

    public static void sort(int list[]) {

//        boolean needNextPass = true;
        for (int i = 1; i < list.length; i++) {

            for (int j = 0; j < list.length - i; j++) {

                if (list[j] > list[j + 1]) {

                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }

            }
        }

        System.out.println(Arrays.toString(list));

    }

}
