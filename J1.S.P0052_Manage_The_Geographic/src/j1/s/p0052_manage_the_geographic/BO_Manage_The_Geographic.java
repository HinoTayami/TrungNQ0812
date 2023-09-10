package j1.s.p0052_manage_the_geographic;

import j1.s.p0052_manage_the_geographic.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BO_Manage_The_Geographic {

    private static List<EastAsiaCountries> countriesList = new ArrayList<>();

    public static void Menu(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    try {
                        addCountryInformation();
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        EastAsiaCountries recentlyEntered = getRecentlyEnteredInformation();
                        if (recentlyEntered != null) {
                            recentlyEntered.display();
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter country name to search: ");
                        String searchName = scanner.nextLine();
                        EastAsiaCountries[] searchResult = searchInformationByName(searchName);
                        if (searchResult != null) {
                            for (EastAsiaCountries country : searchResult) {
                                country.display();
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        EastAsiaCountries[] sortedList = sortInformationByAscendingOrder();
                        if (sortedList != null) {
                            for (EastAsiaCountries country : sortedList) {
                                country.display();
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void addCountryInformation() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Country Code: ");
        String countryCode = scanner.nextLine();
        System.out.print("Enter Country Name: ");
        String countryName = scanner.nextLine();
        System.out.print("Enter Total Area: ");
        float totalArea = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Country Terrain: ");
        String countryTerrain = scanner.nextLine();

        if (totalArea <= 0) {
            throw new Exception("Total area must be greater than 0.");
        }

        EastAsiaCountries country = new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
        countriesList.add(country);
        System.out.println("Country information added successfully.");
    }

    public static EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No country information has been entered yet.");
        }
        return countriesList.get(countriesList.size() - 1);
    }

    public static EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        List<EastAsiaCountries> searchResults = new ArrayList<>();
        for (EastAsiaCountries country : countriesList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                searchResults.add(country);
            }
        }

        if (searchResults.isEmpty()) {
            throw new Exception("No country found with the specified name.");
        }

        return searchResults.toArray(new EastAsiaCountries[0]);
    }

    public static EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No country information has been entered yet.");
        }

        List<EastAsiaCountries> sortedList = new ArrayList<>(countriesList);
        sortedList.sort(Comparator.comparing(EastAsiaCountries::getCountryName));

        return sortedList.toArray(new EastAsiaCountries[0]);
    }
}
