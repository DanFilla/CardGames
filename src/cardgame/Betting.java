package cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Betting {

	private Integer playerThatRaisedIndex;
	private Integer playerBet;
	private Boolean firstRound = true;
	private Boolean potIsNotGood = false;
	private Integer firstBet;
	private Integer count = 0;
	private Integer previousBet;
	private Integer tempCount;

	private int pot;

	public Betting() {
		this.pot = 0;
	}

	public void bet(ArrayList<Player> playerList) {
		do {
			potIsNotGood = false;

			if (count == 0) {
				tempCount = playerList.size();
				previousBet = playerList.get(tempCount-1).getCurrentBet();
			}else {
				previousBet = playerList.get(count - 1).getCurrentBet();
			}

			System.out.println("The bet to call is " + previousBet);

			while (true) {
				if (firstRound) {
					playerList.get(count).bet();
				}else {
					playerList.get(count).addToGetCurrentBet();
				}


				if (count == 0) {
					if (playerList.get(count).getCurrentBet() >= previousBet) {
						break;
					}
				}else {
					if (playerList.get(count).getCurrentBet() >= previousBet) {
						break;
					}
				}
			}

			firstBet = playerList.get(0).getCurrentBet();
			for (Player person : playerList) {
				if (person.getCurrentBet() != firstBet) {
					potIsNotGood = true;
				}
			}

			count++;

			if (count > playerList.size()-1) {
				count = 0;
				firstRound = false;
			}

		}while (potIsNotGood);

		// Reset all current bets to 0 for next round of betting.
		for (Player play : playerList) {
			play.resetCurrentBet();
		}
	}
}
