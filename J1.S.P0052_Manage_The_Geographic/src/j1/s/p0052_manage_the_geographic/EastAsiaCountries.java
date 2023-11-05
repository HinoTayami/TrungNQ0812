package j1.s.p0052_manage_the_geographic;
public class EastAsiaCountries extends Country {
    private String countryTertain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryTertain) {
        this.countryTertain = countryTertain;
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTertain) {
        super(countryCode, countryName, totalArea);
        this.countryTertain = countryTertain;
    }

    public String getCountryTertain() {
        return countryTertain;
    }

    public void setCountryTertain(String countryTertain) {
        this.countryTertain = countryTertain;
    }
    
    public void Display(){
        super.Display();
        System.out.println("Country Tertain: " + countryTertain);
    }
}
