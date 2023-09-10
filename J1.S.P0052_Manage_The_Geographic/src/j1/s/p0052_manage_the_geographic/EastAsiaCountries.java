package j1.s.p0052_manage_the_geographic;
public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Country Terrain: " + countryTerrain);
    }
}
