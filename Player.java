import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final String avatar;
    private float bankBalance;
    private List<Asset> assets;
    private Asset position;
    private boolean incarcerated;
    private List<Card> cards;

    // Starting balance for the player, you can adjust this value as needed
    private static final float STARTING_BALANCE = 1500.0f;

    // Constructor
    public Player(String name, String avatar, Asset startPosition) {
        this.name = name;
        this.avatar = avatar;
        this.bankBalance = STARTING_BALANCE;
        this.assets = new ArrayList<>();
        this.position = startPosition;
        this.incarcerated = false;
        this.cards = new ArrayList<Card>();
    }

    // Getters and setters
    public String getName() { return name; }

    public String getAvatar() { return avatar; }

    public float getBankBalance() { return bankBalance; }

    public void setBankBalance(float bankBalance) { this.bankBalance = bankBalance; }

    public void depositMoney(float income) { this.bankBalance += income; }

    public List<Asset> getAssets() { return assets; }

    public Asset getPosition() { return position; }

    public void setPosition(Asset position) { this.position = position; }

    public boolean isIncarcerated() { return incarcerated; }

    public void setIncarcerated(boolean incarcerated) { this.incarcerated = incarcerated; }

    public List<Card> getCards() { return cards; }

    // Methods to manage assets
    public void addAsset(Asset asset) { assets.add(asset); }

    public void removeAsset(Asset asset) { assets.remove(asset); }

    // Methods to manage cards
    public void addCard(Card card) { cards.add(card); }

    public void removeCard(Card card) { cards.remove(card); }

    // Method to buy a property
    public boolean buyProperty(Asset property) {
        if (bankBalance >= property.getListingPrice()) {
            bankBalance -= property.getListingPrice();
            property.setListingOwner(this);
            addAsset(property);
            return true;
        } else {
            return false;
        }
    }

    // Method to pay rent
    public void payRent(float rent) {
        if (bankBalance >= rent) {
            bankBalance -= rent;
            this.depositMoney(rent);
        } else {
            return;
            // Handle case where player doesn't have enough money
            // This could involve selling assets, mortgaging properties, or declaring bankruptcy
        }
    }

    // Method to move the player
    public void move(int steps, List<Asset> board) {
        int currentPositionIndex = board.indexOf(this.position);
        int newPositionIndex = (currentPositionIndex + steps) % board.size();
        this.position = board.get(newPositionIndex);
    }

    // Method to handle going to jail
    public void goToJail() {
        this.position = Game.Jail;
        this.incarcerated = true;
    }

    // Method to get out of jail
    public boolean payBail() {
        if (bankBalance >= 50) {
            bankBalance -= 50;
            this.incarcerated = false;
            return true;
        }
        return false;
    }

    // Method to pay fine to get out of jail
    public void getOutOfJail(float fineAmount) {
        if (bankBalance >= fineAmount) {
            bankBalance -= fineAmount;
            this.incarcerated = false;
        }
    }
}
