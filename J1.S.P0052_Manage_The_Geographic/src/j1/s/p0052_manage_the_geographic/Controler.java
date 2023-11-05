package j1.s.p0052_manage_the_geographic;

import java.util.List;
import java.util.Scanner;

public class Controler {

    private BO_Manage_The_Geographic bo = new BO_Manage_The_Geographic();
    private Validation vad = new Validation();

    public void menu() {
        int choice;
        do {
            System.out.println("                                 Menu"
                    + "\n======================================================================="
                    + "\n1. Input the information of 11 countries in East Asia."
                    + "\n2. Display the information of country you've just input."
                    + "\n3. Search the information of country by user-entered name."
                    + "\n4. Display the information of countries sorted name in ascending order."
                    + "\n5. Exit."
                    + "\n======================================================================="
                    + "\nEnter your choice: ");
            choice = vad.inputChoice();
            switch (choice) {
                case 1:
                    addCountryInformation();
                    break;
                case 2:
                    displayRecentlyEnteredInformation();
                    break;
                case 3:
                    searchInformationByName();
                    break;
                case 4:
                    sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.out.println("Exit successfully!");
                    break;
                default:
                    System.out.println("Input your choice again!");
                    break;
            }
        } while (choice != 5);
    }

    public void addCountryInformation() {
        System.out.print("Enter country ID: ");
        String id = vad.inputID();
        System.out.print("Enter country name: ");
        String name = vad.inputJC();
        float totalArea = vad.inputTotalArea();
        System.out.print("Enter country terrain: ");
        String terrain = vad.inputJC();

        EastAsiaCountries country = new EastAsiaCountries(id, name, totalArea, terrain);

        try {
            bo.addCountryInformation(country);
            System.out.println("Country information added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayRecentlyEnteredInformation() {
        try {
            EastAsiaCountries recentlyEnteredCountry = bo.getRecentlyEnteredInformation();
            if (recentlyEnteredCountry != null) {
                System.out.println("Recently Entered Country Information:");
                System.out.format(" %-10s | %-20s | %-15s | %-15s \n", "Country ID", "Country Name", "Total Area", "Terrain");
                System.out.format(" %-10s | %-20s | %-15.2f | %-15s \n", recentlyEnteredCountry.getCountryCode(), recentlyEnteredCountry.getCountryName(), recentlyEnteredCountry.getTotalArea(), recentlyEnteredCountry.getCountryTertain());
            } else {
                System.err.println("No country information has been entered recently.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void searchInformationByName() {
        System.out.println("Enter country name to search for: ");
        String name = vad.input().toLowerCase().trim();

        try {
            List<EastAsiaCountries> searchResult = bo.searchInformationByName(name);
            if (!searchResult.isEmpty()) {
                System.out.println("Search result: ");
                System.out.format(" %-10s | %-20s | %-15s | %-15s \n", "Country ID", "Country Name", "Total Area", "Terrain");
                for (EastAsiaCountries country : searchResult) {
                    System.out.format(" %-10s | %-20s | %-15.2f | %-15s \n", country.getCountryCode(), country.getCountryName(), country.getTotalArea(), country.getCountryTertain());
                }
            } else {
                System.out.println("Not found any name matches!");
                System.out.format(" %-10s | %-20s | %-15s | %-15s \n", "Country ID", "Country Name", "Total Area", "Terrain");
                for (EastAsiaCountries country : searchResult) {
                    System.out.format(" %-10s | %-20s | %-15.2f | %-15s \n", country.getCountryCode(), country.getCountryName(), country.getTotalArea(), country.getCountryTertain());
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void sortInformationByAscendingOrder() {
        try {
            EastAsiaCountries[] sortedArray = bo.sortInformationByAscendingOrder();
            if (sortedArray.length > 0) {
                System.out.println("Country information sorted by name in ascending order:");
                System.out.format(" %-10s | %-20s | %-15s | %-15s \n", "Country ID", "Country Name", "Total Area", "Terrain");
                for (EastAsiaCountries country : sortedArray) {
                    System.out.format(" %-10s | %-20s | %-15.2f | %-15s \n", country.getCountryCode(), country.getCountryName(), country.getTotalArea(), country.getCountryTertain());
                }
            } else {
                System.out.println("No country information to display.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
