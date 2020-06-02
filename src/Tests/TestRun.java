package Tests;

import Main.*;
import Hands.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TestRun {
    Scanner input = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> foldedPlayers = new ArrayList<>();
    private final ArrayList<Card> flop = new ArrayList<>();

	private String format(String input) {
		String tempString = "";
		for (Character letter : input.toCharArray()) {
			if (letter.equals('\n')) {
				return tempString.trim();
			}
            tempString += letter;
		}
		return tempString;
	}

    public TestRun(int num) throws IOException, InterruptedException {
        for (int a=0; a<num; a++) {
            Deck deck = new Deck();
            Betting pot = new Betting();

            FileWriter out = null;
            FileWriter in = null;

            int numPlayersString = 5;

//            String[] pla = {"Dan", "John", "Corey", "Sandy", "Chris"};
            String[] pla = {"Dan"};

            for (String x : pla) {
                players.add(new Player(x));
            }

            // Deal the cards to the players
            for (Player xplay : players) {
                xplay.draw(deck, 2);
            }

            // Loop for the entire deal session.
            for (int j = 0; j < 3; j++) {
                System.out.println("You are betting on round " + (j + 1));
                if (j == 0) {
                    deck.drawFlop(flop);
                } else {
                    this.flop.add(deck.drawBurn());
                }
                System.out.println(this.flop);
//            pot.bet(players, foldedPlayers);
            }

            for (Player p : players) {
                ArrayList<Card> allCard = new ArrayList<>(this.flop);
                allCard.addAll(p.getHand());
                p.setBestHand(WinDetection.bestPokerHand(allCard));
            }

            Collections.sort(players);


//            int count = 0;
//            for (int q = 1; q < players.size(); q++) {
//                if (players.get(q - 1).equals(players.get(q))) {
//                    count++;
//                } else {
//                    if (count < 1) {
////                    System.out.println("\nWinner");
////                    System.out.println(players.get(0));
////                    System.out.println(players.get(0).getBestHand());
//                        try {
//                            out = new FileWriter("output.txt", true);
//                            out.write(players.get(0).getBestHand().toString());
//                        } finally {
//                            if (out != null) {
//                                out.close();
//                            }
//                        }
//                        break;
//                    } else {
//                        System.out.println("\nTie Between");
//                        for (int d = 0; d <= count; d++) {
////                        System.out.println(players.get(d));
////                        System.out.println(players.get(d).getBestHand());
////                        System.out.println("\n");
//                        }
//                        break;
//                    }
//                }
//            }
//
//            System.out.println("\nLosers");
//            for (int o = count + 1; o < players.size(); o++) {
////            System.out.println("");
////            System.out.println(players.get(o));
////            System.out.println(players.get(o).getBestHand());
//            }


            try {
                out = new FileWriter("output2.txt", true);
				String data = format(players.get(0).getBestHand().toString());
                out.write(data);
                out.append(System.lineSeparator());
            } finally {
                if (out != null) {
                    out.close();
                }
            }

            players.clear();
            foldedPlayers.clear();
            flop.clear();
            TimeUnit.SECONDS.sleep((long) 0.5);
        }
    }
}
