package p0074;

import java.util.Scanner;

public class P0074 implements Interface {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        P0074 Cal = new P0074();
        Cal.Menu();
    }

    public void Menu() {
        int choice;
        int[][] m1, m2, result;

        do {
            System.out.println("Calculator Program");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = inputchoice();

            switch (choice) {
                case 1:
                    m1 = inputMatrix(1);
                    m2 = inputMatrix(2);
                    if (areMatricesEqualSize(m1, m2)) {
                        result = additionMatrix(m1, m2);
                        System.out.println("----------Result-----------");
                        printMatrix(m1);
                        System.out.println("+");
                        printMatrix(m2);
                        System.out.println("=");
                        printMatrix(result);
                    } else {
                        System.out.println("Two matrices are not of the same size. Do you want to try again? (1 for Yes, any number else for No)");
                        int tryAgainChoice = inputchoice();
                        if (tryAgainChoice != 1) {
                            choice = 4;
                        }
                    }
                    break;
                case 2:
                    m1 = inputMatrix(1);
                    m2 = inputMatrix(2);
                    if (areMatricesEqualSize(m1, m2)) {
                        result = subtractionMatrix(m1, m2);
                        System.out.println("----------Result-----------");
                        printMatrix(m1);
                        System.out.println("+");
                        printMatrix(m2);
                        System.out.println("=");
                        printMatrix(result);
                    } else {
                        System.out.println("Two matrices are not of the same size. Do you want to try again? (1 for Yes, any number else for No)");
                        int tryAgainChoice = inputchoice();
                        if (tryAgainChoice != 1) {
                            choice = 4;
                        }
                    }
                    break;
                case 3:
                    m1 = inputMatrix(1);
                    m2 = inputMatrix(2);
                    result = multiplicationMatrix(m1, m2);
                    printMatrix(m1);
                    System.out.println("*");
                    printMatrix(m2);
                    System.out.println("=");
                    printMatrix(result);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

    }

    public int inputchoice() {
        int choice;
        do {
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.err.println("Just input integer number from 1 to 4: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input choice! Enter your choice again!");
            }
        } while (true);
    }

    public int getInt() {
        int number = -1;
        boolean validInput = false;
        String input;
        while (!validInput) {
            try {
                input = sc.nextLine().trim();
                if (!input.isEmpty()) {
                    number = Integer.parseInt(input);
                    if (number > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Number must be a non-negative integer.");
                    }
                } else {
                    System.out.println("Please enter a non-negative integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
            }
        }

        return number;
    }

    public boolean areMatricesEqualSize(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        return (rows1 == rows2 && cols1 == cols2);
    }

    public int[][] inputMatrix(int mt) {
        int r, c;
        int[][] matrix;
        System.out.print("Enter rows matrix " + mt + ": ");
        r = getInt();
        System.out.print("Enter columns matrix " + mt + ": ");
        c = getInt();

        matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter matrix[" + (i + 1) + "][" + (j + 1) + "] : ");
                boolean valid = false;
                do {
                    try {
                        matrix[i][j] = Integer.parseInt(sc.nextLine());
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid value, input an Integer number please!");
                    }
                } while (!valid);
            }

        }
        return matrix;
    }

    @Override
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int i, j;
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        int r2 = matrix2.length;
        int c2 = matrix2[0].length;
        int[][] result = new int[r1][c1];
        if (r1 == r2 && c1 == c2) {
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        } else {
            System.err.println("size of both matrix is not same!");
            return null;
        }
        return result;

    }

    @Override
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int i, j;
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        int r2 = matrix2.length;
        int c2 = matrix2[0].length;
        int[][] result = new int[r1][c1];
        if (r1 == r2 && c1 == c2) {
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        } else {
            System.err.println("size of both matrix is not same!");
            return null;
        }
        return result;

    }

    @Override
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int i, j, k;
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        int r2 = matrix2.length;
        int c2 = matrix2[0].length;
        int[][] result = new int[r1][c2];

        if (c1 != r2) {
            System.out.println("Matrices cannot be multiplied!");
            return null;
        } else {

            for (i = 0; i < r1; i++) {
                for (j = 0; j < c2; j++) {
                    for (k = 0; k < c1; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return result;
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

}
