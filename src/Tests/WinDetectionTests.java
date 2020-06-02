package Tests;
import Hands.*;
import Main.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WinDetectionTests {

    @Test
    public void testHighCardCompareTo() {
        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(11);
        reqCards.add(9);
        reqCards.add(7);
        reqCards.add(5);
        reqCards.add(2);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new HighCard(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(11);
        reqCards2.add(9);
        reqCards2.add(7);
        reqCards2.add(5);
        reqCards2.add(3);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();

        Hand expected2 = new HighCard(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected);
        handList.add(expected2);

        Collections.sort(handList);


        assertSame(expected2, handList.get(0));
    }

    @Test
    public void testOnePairConstruction() {

        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("2", "H"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("9", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(9);
        reqCards.add(9);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(11);
        kickerSet.add(10);
        kickerSet.add(6);

        Hand expected = new OnePair(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<expected.getRequiredHand().size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testOnePairCompareTo() {
        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(9);
        reqCards.add(9);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(11);
        kickerSet.add(10);
        kickerSet.add(6);

        Hand expected = new OnePair(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(10);
        reqCards2.add(10);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();
        kickerSet2.add(11);
        kickerSet2.add(9);
        kickerSet2.add(6);

        Hand expected2 = new OnePair(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected);
        handList.add(expected2);

        Collections.sort(handList);


        assertSame(expected2, handList.get(0));
    }

    @Test
    public void testTwoPairConstruction() {

        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "H"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("10", "H"));
        flop.add(new Card("K", "D"));
        flop.add(new Card("5", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(5);
        reqCards.add(5);
        reqCards.add(10);
        reqCards.add(10);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(13);

        Hand expected = new TwoPair(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<2; i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        assertEquals(expected.getKickers().get(0), actual.getKickers().get(0));
    }

    @Test
    public void testTwoPairCompare() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(10);
        reqCards.add(10);
        reqCards.add(13);
        reqCards.add(13);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(9);

        Hand expected = new TwoPair(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(5);
        reqCards2.add(5);
        reqCards2.add(10);
        reqCards2.add(10);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();
        kickerSet2.add(13);

        Hand expected2 = new TwoPair(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected2);
        handList.add(expected);

        Collections.sort(handList);


        assertSame(expected, handList.get(0));
    }

    @Test
    public void testThreeOfAKindConstruction() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(5);
        reqCards.add(5);
        reqCards.add(5);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(11);
        kickerSet.add(10);

        Hand expected = new ThreeOfAKind(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testThreeOfAKindCompareTo() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(13);
        reqCards.add(13);
        reqCards.add(13);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(9);
        kickerSet.add(4);

        Hand expected = new ThreeOfAKind(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(10);
        reqCards2.add(10);
        reqCards2.add(10);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();
        kickerSet2.add(13);
        kickerSet2.add(12);

        Hand expected2 = new ThreeOfAKind(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected2);
        handList.add(expected);

        Collections.sort(handList);


        assertSame(expected, handList.get(0));
    }

    @Test
    public void testStraightConstruction() {
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("11", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("8", "D"));
        flop.add(new Card("7", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(5);
        reqCards.add(6);
        reqCards.add(7);
        reqCards.add(8);
        reqCards.add(9);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new Straight(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testStraightConstruction2() {
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("14", "C"));
        flop.add(new Card("2", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("3", "C"));
        flop.add(new Card("4", "H"));
        flop.add(new Card("5", "D"));
        flop.add(new Card("7", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(1);
        reqCards.add(2);
        reqCards.add(3);
        reqCards.add(4);
        reqCards.add(5);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new Straight(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testStraightCompareTo() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(2);
        reqCards.add(3);
        reqCards.add(4);
        reqCards.add(5);
        reqCards.add(6);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new Straight(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(3);
        reqCards2.add(4);
        reqCards2.add(5);
        reqCards2.add(6);
        reqCards2.add(7);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();

        Hand expected2 = new Straight(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected);
        handList.add(expected2);

        Collections.sort(handList);

        assertSame(expected2, handList.get(0));
    }

    @Test
    public void testFlushConstruction() {

        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "H"));
        flop.add(new Card("6", "H"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("K", "C"));
        flop.add(new Card("2", "H"));
        flop.add(new Card("Q", "H"));
        flop.add(new Card("3", "H"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(2);
        reqCards.add(3);
        reqCards.add(5);
        reqCards.add(6);
        reqCards.add(12);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new Flush(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testFlushCompareTo() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(2);
        reqCards.add(6);
        reqCards.add(7);
        reqCards.add(10);
        reqCards.add(12);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new Flush(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(2);
        reqCards2.add(4);
        reqCards2.add(6);
        reqCards2.add(7);
        reqCards2.add(13);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();

        Hand expected2 = new Flush(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected);
        handList.add(expected2);

        Collections.sort(handList);

        assertSame(expected2, handList.get(0));
    }
    //[3H, 8C, 3S, 3C, QS] Q Q
    @Test
    public void testFullHouseConstructionTwo() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("3", "D"));
        flop.add(new Card("3", "S"));
        flop.add(new Card("10", "S"));
        flop.add(new Card("6", "D"));
        flop.add(new Card("Q", "H"));
        flop.add(new Card("Q", "C"));
        flop.add(new Card("Q", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(12);
        reqCards.add(12);
        reqCards.add(12);
        reqCards.add(3);
        reqCards.add(3);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new FullHouse(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testFullHouseConstruction() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("10", "S"));
        flop.add(new Card("J", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(5);
        reqCards.add(5);
        reqCards.add(5);
        reqCards.add(11);
        reqCards.add(11);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new FullHouse(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testFullHouseCompareTo() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(8);
        reqCards.add(8);
        reqCards.add(8);
        reqCards.add(13);
        reqCards.add(13);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new FullHouse(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(9);
        reqCards2.add(9);
        reqCards2.add(9);
        reqCards2.add(10);
        reqCards2.add(10);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();

        Hand expected2 = new FullHouse(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected);
        handList.add(expected2);

        Collections.sort(handList);

        assertSame(expected2, handList.get(0));
    }

    @Test
    public void testFourOfAKindConsruction() {
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("5", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(5);
        reqCards.add(5);
        reqCards.add(5);
        reqCards.add(5);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(11);

        Hand expected = new FourOfAKind(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testFourOfAKindCompareTo() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(13);
        reqCards.add(13);
        reqCards.add(13);
        reqCards.add(13);
        ArrayList<Integer> kickerSet = new ArrayList<>();
        kickerSet.add(9);

        Hand expected = new FourOfAKind(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(10);
        reqCards2.add(10);
        reqCards2.add(10);
        reqCards2.add(10);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();
        kickerSet2.add(13);

        Hand expected2 = new FourOfAKind(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected2);
        handList.add(expected);

        Collections.sort(handList);


        assertSame(expected, handList.get(0));
    }

    @Test
    public void testStraightFlushConstruction() {
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "C"));
        flop.add(new Card("11", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("8", "C"));
        flop.add(new Card("7", "C"));

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(5);
        reqCards.add(6);
        reqCards.add(7);
        reqCards.add(8);
        reqCards.add(9);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new StraightFlush(reqCards, kickerSet);
        Hand actual = WinDetection.bestPokerHand(flop);

        assertEquals(expected.getHandId(), actual.getHandId());

        for (int i=0; i<reqCards.size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }
    }

    @Test
    public void testStraightFlushCompareTo() {

        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(2);
        reqCards.add(3);
        reqCards.add(4);
        reqCards.add(5);
        reqCards.add(6);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new StraightFlush(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(3);
        reqCards2.add(4);
        reqCards2.add(5);
        reqCards2.add(6);
        reqCards2.add(7);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();

        Hand expected2 = new StraightFlush(reqCards2, kickerSet2);

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(expected);
        handList.add(expected2);

        Collections.sort(handList);

        assertSame(expected2, handList.get(0));
    }

    @Test
    public void testStraightFlushEquals() {
        ArrayList<Integer> reqCards = new ArrayList<>();
        reqCards.add(2);
        reqCards.add(3);
        reqCards.add(4);
        reqCards.add(5);
        reqCards.add(6);
        ArrayList<Integer> kickerSet = new ArrayList<>();

        Hand expected = new StraightFlush(reqCards, kickerSet);

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(3);
        reqCards2.add(4);
        reqCards2.add(5);
        reqCards2.add(6);
        reqCards2.add(7);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();

        Hand expected2 = new StraightFlush(reqCards2, kickerSet2);

        assertFalse(expected.equals(expected2));
    }

}
