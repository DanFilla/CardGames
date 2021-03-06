package Main;

import Tests.TestRun;

import java.util.ArrayList;
import java.util.Collections;
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

		//Loop finds the best possible hand for each player.
		for (Player p : players) {
			ArrayList<Card> allCard = new ArrayList<>(this.flop);
			allCard.addAll(p.getHand());
			p.setBestHand(WinDetection.bestPokerHand(allCard));
		}

		// Sorting will put the best hands at the front of the list.
		// Using the compareTo method from each hand class.
		Collections.sort(players);

		int count = 0;
		for (int q=1; q<players.size(); q++) {
			//Determines if there is a tie between the best hands.
			if (players.get(q-1).equals(players.get(q))){
				count++;
			}else {
				if (count < 1) {
					pot.givePotToPlayer(players.get(0));
					System.out.println("\nWinner");
					System.out.println(players.get(0));
					System.out.println(players.get(0).getBestHand());
					break;
				}else {
					System.out.println("\nTie Between");
					for (int d=0; d<=count; d++) {
						System.out.println(players.get(d));
						System.out.println(players.get(d).getBestHand());
						System.out.println("\n");
					}
					break;
				}
			}
		}

		System.out.println("\nLosers");
		for (int o=count+1; o<players.size(); o++) {
			System.out.println("");
			System.out.println(players.get(o));
			System.out.println(players.get(o).getBestHand());
		}
	}
}
