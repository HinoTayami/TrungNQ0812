package j1.s.p0052_manage_the_geographic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BO_Manage_The_Geographic {

    private List<EastAsiaCountries> countryList = new ArrayList<>();
    private EastAsiaCountries recentlyEnteredCountry;

    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        boolean check = false;
        for (EastAsiaCountries checkInfor : countryList) {
            if (checkInfor.getCountryName().equalsIgnoreCase(country.getCountryName()) || checkInfor.getCountryCode().equalsIgnoreCase(country.getCountryCode())) {
                check = true;
                break;
            }
        }
        if (!check) {
            countryList.add(country);
            recentlyEnteredCountry = country;
        }else{
            throw new Exception("Country you just enter almost exists!");
        }

    }

    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        return recentlyEnteredCountry;
    }

    public List<EastAsiaCountries> searchInformationByName(String input) throws Exception {
        List<EastAsiaCountries> result = new ArrayList<>();
        
        for (EastAsiaCountries country : countryList) {
            String countryName = country.getCountryName();
            if (countryName.toLowerCase().contains(input.toLowerCase()) || countryName.equalsIgnoreCase(input)) {
                result.add(country);
            }
        }

        if (result.isEmpty() || input.isEmpty()) {
            return countryList;
        } else {
            return result;
        }
    }

    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        int n = countryList.size(), i;
        boolean swapped;
        do {
            swapped = false;
            for (i = 0; i < n - 1; i++) {
                EastAsiaCountries country1 = countryList.get(i);
                EastAsiaCountries country2 = countryList.get(i + 1);
                if (country1.getCountryName().compareToIgnoreCase(country2.getCountryName()) > 0) {
                    Collections.swap(countryList, i, i + 1);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        EastAsiaCountries[] sortedArray = countryList.toArray(new EastAsiaCountries[0]);

        return sortedArray;
    }

}
