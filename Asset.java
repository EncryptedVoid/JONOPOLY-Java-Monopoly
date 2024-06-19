public abstract class Asset extends Card{
    private final String listingName;
    private final String listingBanner;
    private final float listingPrice;
    private Player listingOwner;
    private boolean isMortgaged;
    private final float mortgagedValue;
    private final float unmortgagedValue;
    private float listingRent;

    public Asset(String listingName, String listingBanner, float listingPrice, float mortgagedValue, float un_mortgagedValue) {
        this.listingName = listingName;
        this.listingBanner = listingBanner;
        this.listingPrice = listingPrice;
        this.listingOwner = null;
        this.isMortgaged = false;
        this.mortgagedValue = mortgagedValue;
        this.unmortgagedValue = un_mortgagedValue;
        this.listingRent = 0; // Base rent, to be set by subclasses
    }

    // Getters and setters
    public String getListingName() { return listingName; }

    public String getListingBanner() { return listingBanner; }

    public float getListingPrice() { return listingPrice; }

    public Player getListingOwner() { return listingOwner; }

    public void setListingOwner(Player listingOwner) { this.listingOwner = listingOwner; }

    public boolean isMortgaged() { return isMortgaged; }

    public float getMortgagedValue() { return mortgagedValue; }

    public float getUnmortgagedValue() { return unmortgagedValue; }

    public float getListingRent() { return listingRent; }

    public void setListingRent(float listingRent) { this.listingRent = listingRent; }

    // Methods to mortgage and unmortgage the property
    public void mortgage() { this.isMortgaged = true; }

    public void unmortgage() { this.isMortgaged = false; }
}
