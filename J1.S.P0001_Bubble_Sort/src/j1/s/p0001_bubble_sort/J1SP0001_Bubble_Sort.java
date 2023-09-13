package j1.s.p0001_bubble_sort;

import java.util.Random;
import java.util.Scanner;

public class J1SP0001_Bubble_Sort {

    public static void main(String[] args) {
        int n = inputPositiveNumber();
        //Users run the program, display a screen to ask users to enter a positive decimal number.
        //Users input a positive decimal number.
        //Generate random integer in number range for each array element.
        //Display array before and after sorting.
        displayAndSortArray(n);
    }

    public static int inputPositiveNumber() {
        int n;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter positive number: ");
            while (!in.hasNextInt()) {
                System.out.println("Enter Integer number( positive number) : ");
                in.next();
            }
            n = in.nextInt();
        } while (n <= 0);
        return n;

    }

    public static void displayAndSortArray(int n) {
        int array[] = createRandomArray(n);
        System.out.print("Unsorted array: ");
        displayArray(array);
        System.out.print("Sorted Array: ");
        sortArrayWithBubbleSortAlgorithm(array);
        displayArray(array);

    }

    public static int[] createRandomArray(int n) {
        int[] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(n);
        }
        return array;

    }

    public static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void sortArrayWithBubbleSortAlgorithm(int[] array) {
        int n = array.length, temp;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (array[i - 1] < array[i]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
