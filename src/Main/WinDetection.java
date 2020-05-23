package Main;

import Hands.*;
import java.util.*;

public class WinDetection {

	private static ArrayList<Integer> kickerSet = new ArrayList<>();
	private static ArrayList<Integer> requiredCards = new ArrayList<>();

	private static final Map<Integer, String> reverseHandMap = Map.of(
			1, "Straight Flush",
			2, "Four of a Kind",
			3, "Full House",
			4, "Flush",
			5, "Straight",
			6, "Three of a Kind",
			7, "Two Pair",
			8, "One Pair",
			9, "High Card"
	);

	private static void getKickerSet(ArrayList<Integer> reqCards, ArrayList<Integer> hand) {
		kickerSet.clear();
		for (int i=hand.size()-1; i>=0; i--) {
			if (kickerSet.size() > 4-requiredCards.size()) {
				return;
			}
			if (!reqCards.contains(hand.get(i))) {
				kickerSet.add(hand.get(i));
			}
		}
	}

	//TODO HighCard outputs the cards in reverse order.
	private static void createHighCardSet(ArrayList<Integer> hand) {
		requiredCards.clear();

		int counter = 0;
		for (int i=hand.size()-1; counter<5; i--) {
			requiredCards.add(hand.get(i));
			counter++;
		}
	}

	private static Boolean isOnePair(ArrayList<Integer> hand) {
		requiredCards.clear();

		for (int i=0; i<hand.size()-1; i++) {
			if (hand.subList(i+1, hand.size()).contains(hand.get(i))) {
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				return true;
			}
		}
		return false;
	}

	private static Boolean isTwoPair(ArrayList<Integer> hand) {
		requiredCards.clear();

		int count = 0;

		for (int i=0; i<hand.size()-1; i++) {
			if (hand.subList(i+1, hand.size()).contains(hand.get(i))) {
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				count++;
			}
		}
		return count > 1;
	}

	private static Boolean isThreeOfAKind(ArrayList<Integer> hand) {
		requiredCards.clear();

		int count = 0;

		for (int i=1; i<hand.size(); i++) {
			if (hand.get(i).equals(hand.get(i - 1))) {
				count += 1;
			}else {
				count = 0;
			}
			if (count > 1){
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				return true;
			}
		}
		return false;
	}

	private static Boolean isStraight(ArrayList<Integer> hand) {
		requiredCards.clear();

		int count = 0;

		for (int i=1; i<hand.size(); i++) {
			if (hand.get(i) - hand.get(i - 1) == 1) {
				if (count == 0) {
					requiredCards.add(hand.get(i-1));
				}
				requiredCards.add(hand.get(i));
				count += 1;
			}else {
				requiredCards.clear();
				count = 0;
			}
			if (count > 3){
				return true;
			}
		}
		return false;

	}

	private static void parseAndAdd(ArrayList<Card> reqCards) {
		for (Card card : reqCards) {
			requiredCards.add(card.getCardNumberAsInt());
		}
	}

	private static Boolean isFlush(ArrayList<Card> hand) {
		requiredCards.clear();

		ArrayList<Card> hearts = new ArrayList<>();
		ArrayList<Card> diamonds = new ArrayList<>();
		ArrayList<Card> spades = new ArrayList<>();
		ArrayList<Card> clubs = new ArrayList<>();

		for (Card card : hand) {
			if (card.getSuite().equals("H")) {
				hearts.add(card);
			}else if (card.getSuite().equals("D")) {
				diamonds.add(card);
			}else if (card.getSuite().equals("S")) {
				spades.add(card);
			}else if (card.getSuite().equals("C")) {
				clubs.add(card);
			}

			if (hearts.size() >= 5) {
				parseAndAdd(hearts);
				return true;
			}else if (diamonds.size() >= 5) {
				parseAndAdd(diamonds);
				return true;
			}else if (spades.size() >= 5) {
				parseAndAdd(spades);
				return true;
			}else if (clubs.size() >= 5) {
				parseAndAdd(clubs);
				return true;
			}
		}

		return false;
	}

	//TODO Not working properly. See notes.
	private static Boolean isFullHouse(ArrayList<Integer> hand) {
		requiredCards.clear();
		boolean includesThreeOfAKind = false;
		boolean includesPair = false;

		int handSize = hand.size()-1;

		int count = 0;
		for (int i=1; i<hand.size(); i++) {
			if (hand.get(i-1).equals(hand.get(i))){
				count++;
			}else {
				if (count == 1) {
					requiredCards.add(hand.get(i-1));
					requiredCards.add(hand.get(i-1));
					includesPair = true;
				}else if (count == 2) {
					requiredCards.add(hand.get(i-1));
					requiredCards.add(hand.get(i-1));
					requiredCards.add(hand.get(i-1));
					includesThreeOfAKind = true;
				}
				count = 0;
			}
		}
		if (count == 1) {
			requiredCards.add(hand.get(handSize));
			requiredCards.add(hand.get(handSize));
			includesPair = true;
		}else if (count == 2) {
			requiredCards.add(hand.get(handSize));
			requiredCards.add(hand.get(handSize));
			requiredCards.add(hand.get(handSize));
			includesThreeOfAKind = true;
		}
		return includesPair && includesThreeOfAKind;
	}

	private static Boolean isFourOfAKind(ArrayList<Integer> hand) {
		requiredCards.clear();

		int count = 0;

		for (int i=1; i<hand.size(); i++) {
			if (hand.get(i).equals(hand.get(i - 1))) {
				count += 1;
			}else {
				count = 0;
			}
			if (count > 2){
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				requiredCards.add(hand.get(i));
				return true;
			}
		}
		return false;

	}

	private static Boolean isStraightFlush(ArrayList<Card> hand) {
		requiredCards.clear();

		ArrayList<Integer> hearts = new ArrayList<>();
		ArrayList<Integer> diamonds = new ArrayList<>();
		ArrayList<Integer> spades = new ArrayList<>();
		ArrayList<Integer> clubs = new ArrayList<>();

		for (Card card : hand) {
			if (card.getSuite().equals("H")) {
				hearts.add(card.getCardNumberAsInt());
			}else if (card.getSuite().equals("D")) {
				diamonds.add(card.getCardNumberAsInt());
			}else if (card.getSuite().equals("S")) {
				spades.add(card.getCardNumberAsInt());
			}else if (card.getSuite().equals("C")) {
				clubs.add(card.getCardNumberAsInt());
			}
		}

		if (hearts.size() >= 5) {
			Collections.sort(hearts);
			if (isStraight(hearts)) {
				requiredCards.addAll(hearts);
				return true;
			}
		}else if (diamonds.size() >= 5) {
			Collections.sort(diamonds);
			if (isStraight(diamonds)) {
				requiredCards.addAll(diamonds);
				return true;
			}
		}else if (spades.size() >= 5) {
			Collections.sort(spades);
			if (isStraight(spades)) {
				requiredCards.addAll(spades);
				return true;
			}
		}else if (clubs.size() >= 5) {
			Collections.sort(clubs);
			if (isStraight(clubs)) {
				requiredCards.addAll(clubs);
				return true;
			}
		}
		return false;
	}

	public static Hand bestPokerHand(ArrayList<Card> hand) {
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

		kickerSet.clear();
		requiredCards.clear();

		ArrayList<Integer> parsedHand = new ArrayList<>();
		for (Card card : hand) {
			parsedHand.add(card.getCardNumberAsInt());
		}

		Collections.sort(parsedHand);

		if(isStraightFlush(hand)) {
			getKickerSet(requiredCards, parsedHand);
			return new StraightFlush(requiredCards, kickerSet);
		}else if(isFourOfAKind(parsedHand)) {
			getKickerSet(requiredCards, parsedHand);
			return new FourOfAKind(requiredCards, kickerSet);
		}else if(isFullHouse(parsedHand)) {
			getKickerSet(requiredCards, parsedHand);
			return new FullHouse(requiredCards, kickerSet);
		}else if(isFlush(hand)) {
			getKickerSet(requiredCards, parsedHand);
			return new Flush(requiredCards, kickerSet);
		}else if(isStraight(parsedHand)) {
			getKickerSet(requiredCards, parsedHand);
			return new Straight(requiredCards, kickerSet);
		}else if(isThreeOfAKind(parsedHand)) {
			getKickerSet(requiredCards, parsedHand);
			return new ThreeOfAKind(requiredCards, kickerSet);
		}else if (isTwoPair(parsedHand)) {
			getKickerSet(requiredCards, parsedHand);
			return new TwoPair(requiredCards, kickerSet);
		}else if(isOnePair(parsedHand)) {
			getKickerSet(requiredCards, parsedHand);
			return new OnePair(requiredCards, kickerSet);
		}else {
			kickerSet.clear();
			createHighCardSet(parsedHand);
			return new HighCard(requiredCards, kickerSet);
		}

	}

	public static String getHandName(int id) {
		return reverseHandMap.get(id);
	}

}
