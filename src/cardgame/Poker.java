package cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Poker {

	Scanner input = new Scanner(System.in);
	Deck deck = new Deck();
	ArrayList<Player> players = new ArrayList<>();
	private final ArrayList<Card> flop = new ArrayList<>();

	public Poker() {
		Deck deck = new Deck();
		Betting pot = new Betting();

		System.out.println("How many players are playing?");
		String numPlayers = input.nextLine();
		int numPlayersString = Integer.parseInt(numPlayers);

		for (int i=0; i<numPlayersString; i++) {
			System.out.println("What is name of player: " + i);
			String name = input.nextLine();
			players.add(new Player(name));
		}

		// Deal the cards to the players
		for (Player xplay : players) {
			xplay.draw(deck, 5);
		}

		// Loop for the entire deal session.
		for (int j=0; j<=2; j++) {
			System.out.print("You are betting on the " + j + " round.");
			if (j == 0) {
				deck.drawFlop(flop);
			}else if (j > 1) {
				flop.add(deck.drawBurn());
			}
			pot.bet(players);
		}
	}

}
