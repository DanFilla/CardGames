package cardgame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static final String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9",
                                             "10", "J", "Q", "K", "A"};
    private static final String[] suites = {"H", "D", "S", "C"};
    private final ArrayList<Card> deck = new ArrayList<>();
    private final ArrayList<Card> discardDeck = new ArrayList<>();

    public Deck() {
        for (String suite : suites) {
            for (String number : numbers) {
                deck.add(new Card(number, suite));
            }
        }
        Collections.shuffle(deck);
    }

    private void checkEmpty() {
        if (deck.isEmpty()) {
            this.shuffle();
            this.discardDeck.clear();
        }
    }

    private void burn() {
        checkEmpty();
        Card card = this.deck.get(0);
        this.discardDeck.add(card);
        this.deck.remove(0);
    }

    private void shuffle() {
        deck.addAll(discardDeck);
        Collections.shuffle(deck);
    }

	public void drawFlop(ArrayList<Card> aflop) {
		this.burn();
		for (int i=0; i<3; i++) {
			aflop.add(this.draw());
		}
	}

    public Card drawBurn() {
        this.burn();
        checkEmpty();
        Card card = deck.get(0);
        discardDeck.add(card);
        deck.remove(0);
        return card;
    }

    public Card draw() {
        checkEmpty();
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

}
