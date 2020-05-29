package Hands;

import java.util.ArrayList;

public class HighCard implements Hand {


    static final int handId = 9;
    private ArrayList<Integer> requiredHand = new ArrayList<>();
    private ArrayList<Integer> kickers = new ArrayList<>();


    public HighCard(ArrayList<Integer> aRequiredHand, ArrayList<Integer> aKickers) {
        this.requiredHand = new ArrayList<Integer>(aRequiredHand);
        this.kickers = new ArrayList<Integer>(aKickers);
    }

    @Override
    public int compareTo(Hand o) {
        if (handId < o.getHandId()) {
            return -1;
        }else if(handId > o.getHandId()) {
            return 1;
        }else {
            for (int i=this.requiredHand.size()-1; i>=0; i--) {
                if (this.requiredHand.get(i) < o.getRequiredHand().get(i)) {
                    return 1;
                }else if (this.requiredHand.get(i) > o.getRequiredHand().get(i)) {
                    return -1;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String temp = "High Card\nRequiredHand: ";

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
        for (int j=0; j<requiredHand.size(); j++) {
            if (!requiredHand.get(j).equals(o.getRequiredHand().get(j))) {
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
