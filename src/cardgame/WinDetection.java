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

	private static Boolean isOnePair(ArrayList<Integer> hand) {
		for (int i=0; i<hand.size()-1; i++) {
			if (hand.subList(i+1, hand.size()).contains(hand.get(i))) {
				return true;
			}
		}
		return false;

	}

	private static Boolean isTwoPair(ArrayList<Integer> hand) {
		int count = 0;

		for (int i=0; i<hand.size()-1; i++) {
			if (hand.subList(i+1, hand.size()).contains(hand.get(i))) {
				count++;
			}
		}
		return count > 1;


	}

	private static Boolean isThreeOfAKind(ArrayList<Integer> hand) {
		return false;

	}

	private static Boolean isStraight(ArrayList<Integer> hand) {
		return false;

	}

	private static Boolean isFlush(ArrayList<Integer> hand) {
		return false;

	}

	private static Boolean isFullHouse(ArrayList<Integer> hand) {
		return false;

	}

	private static Boolean isFourOfAKind(ArrayList<Integer> hand) {
		return false;

	}

	private static Boolean isStraightFlush(ArrayList<Integer> hand) {
		return false;

	}

	public static Map<String, Integer> bestPokerHand(ArrayList<Card> hand) {
		//takes in any number of cards and produces the best hand.

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

		int highCard = getHighCard(hand);

		ArrayList<Integer> parsedHand = new ArrayList<>();
		for (Card card : hand) {
			parsedHand.add(card.getCardNumberAsInt());
		}

		Map <String, Integer> formattedMap = new HashMap<>();

		if (isStraightFlush(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 1);
		}else if(isFourOfAKind(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 2);
		}else if(isFullHouse(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 3);
		}else if(isFlush(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 4);
		}else if(isStraight(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 5);
		}else if(isThreeOfAKind(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 6);
		}else if(isTwoPair(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 7);
		}else if(isOnePair(parsedHand)){
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 8);
		}else {
			formattedMap.put("highCard", highCard);
			formattedMap.put("handId", 9);
		}
		return formattedMap;
	}


}
