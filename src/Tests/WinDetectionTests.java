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
    public void testOnePair() {
        //test for three of a kind.
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

        for (int i=0; i<expected.getRequiredHand().size(); i++) {
            assertEquals(expected.getRequiredHand().get(i), actual.getRequiredHand().get(i));
        }

        for (int j=0; j<expected.getKickers().size(); j++) {
            assertEquals(expected.getKickers().get(j), actual.getKickers().get(j));
        }

        ArrayList<Card> flop2 = new ArrayList<>();
        flop2.add(new Card("2", "H"));
        flop2.add(new Card("6", "C"));
        flop2.add(new Card("10", "S"));
        flop2.add(new Card("10", "C"));
        flop2.add(new Card("9", "H"));
        flop2.add(new Card("J", "D"));
        flop2.add(new Card("5", "D"));

        ArrayList<Integer> reqCards2 = new ArrayList<>();
        reqCards2.add(10);
        reqCards2.add(10);
        ArrayList<Integer> kickerSet2 = new ArrayList<>();
        kickerSet2.add(11);
        kickerSet2.add(9);
        kickerSet2.add(6);

        Hand expected2 = new OnePair(reqCards2, kickerSet2);
        Hand actual2 = WinDetection.bestPokerHand(flop2);

        for (int i=0; i<2; i++) {
            assertEquals(expected2.getRequiredHand().get(i), actual2.getRequiredHand().get(i));
        }

        for (int j=0; j<3; j++) {
            assertEquals(expected2.getKickers().get(j), actual2.getKickers().get(j));
        }

        ArrayList<Hand> handList = new ArrayList<>();
        handList.add(actual2);
        handList.add(actual);

        Collections.sort(handList);


        assertSame(handList.get(0), actual);


    }

    @Ignore
    @Test
    public void testTwoPair() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "H"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("10", "H"));
        flop.add(new Card("K", "D"));
        flop.add(new Card("5", "D"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 7);
        expectedMap.put("highCard", 13);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }

    @Ignore
    @Test
    public void testThreeOfAKind() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 6);
        expectedMap.put("highCard", 11);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }

    @Ignore
    @Test
    public void testStraight() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "H"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("8", "C"));
        flop.add(new Card("7", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 5);
        expectedMap.put("highCard", 9);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }
    @Ignore
    @Test
    public void testFlush() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "H"));
        flop.add(new Card("6", "H"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("K", "C"));
        flop.add(new Card("2", "H"));
        flop.add(new Card("Q", "H"));
        flop.add(new Card("3", "H"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 4);
        expectedMap.put("highCard", 12);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }

    @Ignore
    @Test
    public void testFullHouse() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "C"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("10", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("5", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("5", "D"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 3);
        expectedMap.put("highCard", 10);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }

    @Ignore
    @Test
    public void testFourOfAKind() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("10", "S"));
        flop.add(new Card("6", "C"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("10", "C"));
        flop.add(new Card("10", "H"));
        flop.add(new Card("J", "D"));
        flop.add(new Card("10", "D"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 2);
        expectedMap.put("highCard", 10);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }

    @Ignore
    @Test
    public void testStraightFlush() {
        //test for three of a kind.
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(new Card("5", "H"));
        flop.add(new Card("6", "H"));
        flop.add(new Card("9", "S"));
        flop.add(new Card("K", "C"));
        flop.add(new Card("9", "H"));
        flop.add(new Card("7", "H"));
        flop.add(new Card("8", "H"));

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("handId", 1);
        expectedMap.put("highCard", 9);

        assertEquals(expectedMap, WinDetection.bestPokerHand(flop));
    }

}
