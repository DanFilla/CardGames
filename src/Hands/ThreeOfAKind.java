package Hands;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeOfAKind implements Hand {


    static final int handId = 6;
    private ArrayList<Integer> requiredHand = new ArrayList<>();
    private ArrayList<Integer> kickers = new ArrayList<>();

    public ThreeOfAKind(ArrayList<Integer> aRequiredHand, ArrayList<Integer> aKickers) {
        this.requiredHand = new ArrayList<Integer>(aRequiredHand);
        this.kickers = new ArrayList<Integer>(aKickers);

        Collections.sort(this.requiredHand);
    }

    @Override
    public int compareTo(Hand o) {
        if (handId > o.getHandId()) {
            return -1;
        }else if(handId < o.getHandId()) {
            return 1;
        }else {
            if (this.requiredHand.get(0) > o.getRequiredHand().get(0)) {
                return -1;
            }else if (this.requiredHand.get(0) < o.getRequiredHand().get(0)) {
                return 1;
            }else {
                for (int i=this.kickers.size()-1; i>=0; i--) {
                    if (this.kickers.get(i) > o.getKickers().get(i)) {
                        return -1;
                    } else if (this.kickers.get(i) < o.getKickers().get(i)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String temp = "RequiredHand: ";

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
