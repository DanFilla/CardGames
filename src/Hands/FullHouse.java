package Hands;

import java.util.ArrayList;
import java.util.Collections;

public class FullHouse implements Hand {


    static final int handId = 3;
    private ArrayList<Integer> requiredHand = new ArrayList<>();
    private ArrayList<Integer> kickers = new ArrayList<>();

    public FullHouse(ArrayList<Integer> aRequiredHand, ArrayList<Integer> aKickers) {
        this.requiredHand = new ArrayList<Integer>(aRequiredHand);
        this.kickers = new ArrayList<Integer>(aKickers);

        Collections.sort(this.requiredHand);
    }

    //TODO horribly inefficient
    @Override
    public int compareTo(Hand o) {

        int reqHandSize = this.requiredHand.size();
        int pairLocation;
        int threeOfAKindLocation;

        if (handId < o.getHandId()) {
            return -1;
        }else if(handId > o.getHandId()) {
            return 1;
        }else {
            if (this.requiredHand.get(0).equals(this.requiredHand.get(2))) {
                pairLocation = reqHandSize-1;
                threeOfAKindLocation = 0;
            }else {
                pairLocation = 0;
                threeOfAKindLocation = reqHandSize-1;
            }
            if (this.requiredHand.get(threeOfAKindLocation) > o.getRequiredHand().get(threeOfAKindLocation)) {
                return -1;
            }else if (this.requiredHand.get(threeOfAKindLocation) < o.getRequiredHand().get(threeOfAKindLocation)) {
                return 1;
            } else {
                //check pair
                if (this.requiredHand.get(pairLocation) > o.getRequiredHand().get(pairLocation)) {
                    return -1;
                } else if (this.requiredHand.get(pairLocation) < o.getRequiredHand().get(pairLocation)) {
                    return 1;
                }
            }
        }
        return 0;
//
//        if (handId > o.getHandId()) {
//            return -1;
//        }else if(handId < o.getHandId()) {
//            return 1;
//        }else {
//            if (this.requiredHand.get(0).equals(this.requiredHand.get(2))) {
//                pairLocation = reqHandSize-1;
//                if (this.requiredHand.get(0) > o.getRequiredHand().get(0)) {
//                    return -1;
//                } else if (this.requiredHand.get(0) < o.getRequiredHand().get(0)) {
//                    return 1;
//                }else {
//                    //check the pair
//                    if (this.requiredHand.get(pairLocation) > o.getRequiredHand().get(pairLocation)) {
//                        return -1;
//                    } else if (this.requiredHand.get(pairLocation) < o.getRequiredHand().get(pairLocation)) {
//                        return 1;
//                    }
//                }
//            }else {
//                pairLocation = 0;
//                if (this.requiredHand.get(reqHandSize-1) > o.getRequiredHand().get(this.requiredHand.get(reqHandSize-1))) {
//                    return -1;
//                }else if (this.requiredHand.get(reqHandSize-1) < o.getRequiredHand().get(this.requiredHand.get(reqHandSize-1))) {
//                    return 1;
//                } else {
//                    //check pair
//                    if (this.requiredHand.get(pairLocation) > o.getRequiredHand().get(pairLocation)) {
//                        return -1;
//                    } else if (this.requiredHand.get(pairLocation) < o.getRequiredHand().get(pairLocation)) {
//                        return 1;
//                    }
//                }
//            }
//        }
//        return 0;
    }

    @Override
    public String toString() {
        String temp = "Full House\nRequiredHand: ";

        for (Integer card : this.requiredHand) {
            temp += card.toString() + " ";
        }
        temp += "\nKickerCards: ";

        for (Integer acard : this.kickers) {
            temp += acard.toString() +  " ";
        }
        return temp;
    }

    public boolean equals(Hand o) {
        for (int j=0; j<this.requiredHand.size(); j++) {
            if (!this.requiredHand.get(j).equals(o.getRequiredHand().get(j))) {
                return false;
            }
        }
        for (int k=0; k<this.kickers.size(); k++) {
            if (!this.kickers.get(k).equals(o.getKickers().get(k))) {
                return false;
            }
        }
        return true;
    }

    public int getHandId() {
        return handId;
    }

    public ArrayList<Integer> getRequiredHand() {
        return this.requiredHand;
    }

    public ArrayList<Integer> getKickers() {
        return this.kickers;
    }
}
