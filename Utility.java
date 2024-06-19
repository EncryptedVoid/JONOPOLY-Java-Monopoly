public class Utility extends Asset {
    private static int rentMultiplier;
    private static int ownedUtilities;

    public Utility(String listingName, String listingBanner, float listingPrice, float mortgagedValue, float un_mortgagedValue) {
        super(listingName, listingBanner, listingPrice, mortgagedValue, un_mortgagedValue);
        Utility.rentMultiplier = 1;
        Utility.ownedUtilities = 0;
    }
}