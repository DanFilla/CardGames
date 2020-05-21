package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Poker {

	Scanner input = new Scanner(System.in);
	Deck deck = new Deck();
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Player> foldedPlayers = new ArrayList<>();
	private final ArrayList<Card> flop = new ArrayList<>();

	public Poker() {
		Deck deck = new Deck();
		Betting pot = new Betting();

		System.out.println("How many players are playing?");
		String numPlayers = input.nextLine();
		int numPlayersString = Integer.parseInt(numPlayers);

		for (int i=0; i<numPlayersString; i++) {
			System.out.println("What is name of player: " + (i+1));
			String name = input.nextLine();
			players.add(new Player(name));
		}

		// Deal the cards to the players
		for (Player xplay : players) {
			xplay.draw(deck, 2);
		}

		// Loop for the entire deal session.
		for (int j=0; j<3; j++) {
			System.out.println("You are betting on round " + (j+1));
			if (j == 0) {
				deck.drawFlop(flop);
			}else {
				this.flop.add(deck.drawBurn());
			}
			System.out.println(this.flop);
			pot.bet(players, foldedPlayers);
		}

//		Player winner = players.get(0);
//
//		for (Player y : players) {
//			ArrayList<Card> allCard = new ArrayList<>(this.flop);
//			allCard.addAll(y.getHand());
//			y.setHandMap(WinDetection.bestPokerHand(allCard));
//			if (y.getHandMap().get("handId") < winner.getHandMap().get("handId")) {
//				winner = y;
//			}else if (y.getHandMap().get("handId").equals(winner.getHandMap().get("handId")) && y.getHandMap().get("highCard") > winner.getHandMap().get("highCard")) {
//				winner = y;
//			}
//		}
//		System.out.println(winner.getName());
//		System.out.println(WinDetection.getHandName(winner.getHandMap().get("handId")));
	}
}