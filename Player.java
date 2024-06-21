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


}
