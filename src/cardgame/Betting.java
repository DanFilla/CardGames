package cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Betting {

	private Integer playerThatRaisedIndex;
	private Integer playerBet;
	private Boolean firstRound = true;
	private Integer count = 0;

	private int pot;

	public Betting() {
		this.pot = 0;
	}

	private void addToPot(int betFromPlayer) {
		this.pot += betFromPlayer;
	}

	public void bet(ArrayList<Player> playerList) {
		// Method will loop through players while checking the previous players bet. This previous bet
		// is the minimum bet required to continue playing.
		// at the end of each iteration it also checks if all of the bets are identical
		// if they are then we know that betting has ended and we can move to the next round.

		// if potIsNotGood is false then the loop will break.
		Boolean potIsNotGood = true;
		do {

			Integer previousBet;
			if (count == 0) {
				Integer tempCount = playerList.size();
				previousBet = playerList.get(tempCount -1).getCurrentBet();
			}else {
				previousBet = playerList.get(count - 1).getCurrentBet();
			}

			System.out.println("The bet to call is " + previousBet);

			// loop for the actual betting.
			while (true) {
				Player currentPlayer = playerList.get(count);

				if (firstRound) {
					currentPlayer.bet();
				}else {
					currentPlayer.addToGetCurrentBet();
				}
				if (currentPlayer.getCurrentBet() >= previousBet) {
					break;
				}

//				if (count == 0) {
//					if (currentPlayer.getCurrentBet() >= previousBet) {
//						break;
//					}
//				}else {
//					if (currentPlayer.getCurrentBet() >= previousBet) {
//						break;
//					}
//				}
			}

			// check if all of the bets are equal or if every player has checked.
			Boolean areBetsEqual = true;
			Integer firstBet = playerList.get(0).getCurrentBet();
			for (Player person : playerList) {
				if (person.getCurrentBet() != firstBet || person.getCurrentBet() == 0) {
					areBetsEqual = false;
					break;
				}
			}

			int checkCount = 0;
			for (Player person2 : playerList) {
				if (person2.getHasChecked()) {
					checkCount++;
				}
			}
			Boolean haveAllPlayersChecked = false;
			if (checkCount == playerList.size()) {
				haveAllPlayersChecked = true;
			}

			count++;

			// reset the count variable so it does not exceed the size of the playerList.
			if (count > playerList.size()-1) {
				count = 0;
				firstRound = false;
			}

			if (areBetsEqual || haveAllPlayersChecked) {
				potIsNotGood = false;
			}

		}while (potIsNotGood);

		// Reset all current bets to 0 for next round of betting.
		for (Player play : playerList) {
			this.addToPot(play.getCurrentBet());
			play.resetCurrentBet();
			play.resetHasChecked();
		}

		// resetting first round variable and count variable.
		firstRound = true;
		count = 0;
	}
}
