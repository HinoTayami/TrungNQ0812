package p0071;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public int getInt(String message, int min, int max) {
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

    public boolean checkReviewer(String assignee, String reviewer) {
        if (assignee.equalsIgnoreCase(reviewer)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkTime(double from, double to) {
        if (from < to) {
            return true;
        } else {
            return false;
        }
    }

    public double getDouble(String msg, double min, double max) {
        double input;
        while (true) {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input % 0.5 != 0) {
                    throw new NumberFormatException();
                }
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String inputString(String msg, String regex) {
        String input;
        while (true) {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (!input.matches(regex)) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String inputDate(String msg) {
        String input;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            try {
                Date date = dateFormat.parse(input);
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                
                if (year <= currentYear) {
                    return dateFormat.format(date);
                } else {
                    System.err.println("Invalid year, please try again");
                }
            } catch (Exception e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String inputTaskTypeId(String msg) {
        int choice = getInt(msg, 1, 4);
        String input = null;
        switch (choice) {
            case 1:
                input = "Code";
                break;
            case 2:
                input = "Test";
                break;
            case 3:
                input = "Design";
                break;
            case 4:
                input = "Review";
                break;
        }
        return input;
    }
}
