package cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinDetection {

	private static int getHighCard(ArrayList<Card> hand) {
		int cardNum = 0;
		for (Card card : hand) {
			if (card.getCardNumberAsInt() > cardNum) {
				cardNum = card.getCardNumberAsInt();
			}
		}
		return cardNum;
	}

	private static Boolean isOnePair(ArrayList<Card> hand) {
		ArrayList<Integer> parsedHand = new ArrayList<>();

		for (Card card : hand) {
			parsedHand.add(card.getCardNumberAsInt());
		}

		for (int i=0; i<hand.size()-1; i++) {
			if (parsedHand.subList(i+1, parsedHand.size()).contains(parsedHand.get(i))) {
				return true;
			}
		}
		return false;

	}

	//private Boolean isTwoPair(ArrayList<Card> hand) {

	//}

	//private Boolean isThreeOfAKind(ArrayList<Card> hand) {

	//}

	//private Boolean isStraight(ArrayList<Card> hand) {

	//}

	//private Boolean isFlush(ArrayList<Card> hand) {

	//}

	//private Boolean isFullHouse(ArrayList<Card> hand) {

	//}

	//private Boolean isFourOfAKind(ArrayList<Card> hand) {

	//}

	//private Boolean isStraightFlush(ArrayList<Card> hand) {

	//}

	public static Map<Integer, Integer> bestPokerHand(ArrayList<Card> hand) {
		//takes in any number of cards and produces the best hand.

		//format for returned map.
		//Map<best hand id, high card>

		//*** hand id's ***
		//Straight flush : 1
		//Four of a kind : 2
		//Full house     : 3
		//Flush          : 4
		//Straight       : 5
		//Three of a kind: 6
		//Two Pair       : 7
		//One Pair       : 8
		//HighCard       : 9
		int highCard;



		Map <Integer, Integer> formatedMap = new HashMap<>();
		formatedMap.put(1, getHighCard(hand));
		System.out.println(isOnePair(hand));
		return formatedMap;
	}


}
