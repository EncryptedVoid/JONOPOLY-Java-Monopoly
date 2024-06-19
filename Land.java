public class Land extends Asset {
    private final String company; // Color group or company
    private int housesBuilt;
    private int hotelsBuilt;
    private float constructionPrice; // Cost to build next development
    private final int hotelConstructionRequirement; // Number of houses needed to build a hotel

    public Land(String company, float constructionPrice, int hotelConstructionRequirement, String listingName, String listingBanner, float listingPrice, float mortgagedValue, float un_mortgagedValue) {
        super(listingName, listingBanner, listingPrice, mortgagedValue, un_mortgagedValue);

        this.company = company;
        this.housesBuilt = 0;
        this.hotelsBuilt = 0;
        this.constructionPrice = constructionPrice;
        this.hotelConstructionRequirement = hotelConstructionRequirement;
    }

    // Getters and setters
    public String getCompany() { return company; }

    public int getHousesBuilt() { return housesBuilt; }

    public int getHotelsBuilt() { return hotelsBuilt; }

    public float getConstructionPrice() { return constructionPrice; }

    public boolean sufficientBalance(Player player) {
        return player.getBalance() >= constructionPrice;
    }

    public boolean canBuildHotel() {
        return housesBuilt == hotelConstructionRequirement;
    }

    // Methods to build houses and hotels
    public boolean buildHouse(Player player) {
        if (sufficientBalance(player)) {
            housesBuilt++;
            constructionPrice*=1.5F;
            return true;
        }
        return false;
    }

    public boolean buildHotel(Player player) {
        if (canBuildHotel() && sufficientBalance(player)) {
            hotelsBuilt++;
            housesBuilt-=hotelConstructionRequirement;
            constructionPrice*=1.85F;
            return true;
        }
        return false;
    }

    public float calculateRent() {
        return constructionPrice*0.8F;
    }
}
