package p0070;

import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

     public int inputChoice(String message, int min, int max) {
        int choice;
        while (true) {
            System.out.print(message);
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, try again");
            }
        }
    }

    public String input() {
        return sc.nextLine();
    }
}
