import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static ArrayList deck = new ArrayList();

    public static Object main(){
        createDeck();
        shuffleDeck();

        return deck;
    }

    private static void createDeck() {
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 14; k++) {
                deck.add(Card.createCard(i, k));
            }
        }
    }

    private static void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public static Object returnCard(int deckSpot){
        return deck.get(deckSpot);
    }

}

