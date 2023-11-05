package p0070;

import java.util.Locale;

public class Main {

   
    public static void main(String[] args) {
        Controller con = new Controller();
        Validation vad = new Validation();
        while (true) {
            System.out.println("-----------Login Program------------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            int choice = vad.inputChoice("Please choice one option: ", 1, 3);
            switch (choice) {
                case 1:
                    con.login(new Locale("vi"));
                    break;
                case 2:
                    con.login(new Locale("en"));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
