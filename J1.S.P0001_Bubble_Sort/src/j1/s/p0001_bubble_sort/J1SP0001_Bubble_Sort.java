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
            System.out.println("Please enter a positive number of array: ");
            while (!in.hasNextInt()) {
                System.out.println("Invalid value. Please enter again!");
                in.next();
            }
            n = in.nextInt();

        } while (n <= 0);

        return n;
    }

    public static void displayAndSortArray(int n) {
        int arr[] = createRandomArray(n);
        System.out.print("Unsorted array: ");
        displayOriginalArray(arr);
        System.out.print("Sorted Array: ");
        displaySortedArray(arr);
    }

    public static int[] createRandomArray(int n) {
        int[] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(100);
        }
        return array;
    }

    public static void displayOriginalArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void displaySortedArray(int[] array) {
        sortArrayWithBubbleSortAlgorithm(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void sortArrayWithBubbleSortAlgorithm(int[] array) {
        int n = array.length, temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
