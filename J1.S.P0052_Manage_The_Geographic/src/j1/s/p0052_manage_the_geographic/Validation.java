package j1.s.p0052_manage_the_geographic;

import java.util.Scanner;

public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int inputChoice() {
        int choice = -1;
        while (true) {
            String in = sc.nextLine();

            if (in.matches("[1-5]")) {
                choice = Integer.parseInt(in);
                break;
            }
            System.err.println("Invalid value. Please enter an integer from 1 to 5.");
        }
        return choice;
    }

    public float inputTotalArea() {
        float area;
        do {
            System.out.print("Enter total area: ");
            String areaInput = sc.nextLine().trim();
            if(areaInput.isEmpty()){
                System.err.println("input is empty! enter again!");
                area = -1;
            }
            try {
                area = Float.parseFloat(areaInput);
                if (area < 728.6 ) {
                    System.err.println("The area must be larger than or equal the total area of Singapore (728.6) because Singapore is the country with the smallest total area in East Asia, enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("please enter float number again: ");
                area = -1;
            }
        } while (area < 728.6);

        return area;
    }
    public String inputID(){
        String input;
        do{
            input = sc.nextLine();
            if(input.trim().isEmpty()){
            System.err.println("Input is empty, enter again: ");
            }
        }while(input.trim().isEmpty());
        return input;
    }
    
    public String inputJC() {
        String inputString;
        do{
            inputString = sc.nextLine();
            if(!inputString.matches("^[^\\d]*$")){
                System.err.println("Invalid value, enter again without number: ");
            }
            if(inputString.trim().isEmpty()){
                System.err.println("Invalid value, enter again: ");
            }
        }while(!inputString.matches("^[^\\d]*$") || inputString.trim().isEmpty());
        return inputString;
    }
    
    public String input(){
        return sc.nextLine();
    }
    
}
