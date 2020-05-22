package Hands;

import java.util.ArrayList;
import java.util.Collections;

public class Flush implements Hand {


    static final int handId = 8;
    private ArrayList<Integer> requiredHand = new ArrayList<>();
    private ArrayList<Integer> kickers = new ArrayList<>();


    public Flush(ArrayList<Integer> aRequiredHand, ArrayList<Integer> aKickers) {
        this.requiredHand = new ArrayList<Integer>(aRequiredHand);
        this.kickers = new ArrayList<Integer>(aKickers);

        Collections.sort(requiredHand);
    }

    @Override
    public int compareTo(Hand o) {
        if (handId > o.getHandId()) {
            return -1;
        }else if(handId < o.getHandId()) {
            return 1;
        }else {
            if (requiredHand.get(requiredHand.size()-1) > o.getRequiredHand().get(requiredHand.size()-1)) {
                return -1;
            }else if (requiredHand.get(requiredHand.size()-1) < o.getRequiredHand().get(requiredHand.size()-1)){
                return 1;
            }else {
                return 0;
            }

        }
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
        for (int j=0; j<requiredHand.size(); j++) {
            if (!requiredHand.get(j).equals(o.getRequiredHand().get(j))) {
                return false;
            }
        }
        for (int k=0; k<kickers.size(); k++) {
            if (!kickers.get(k).equals(o.getKickers().get(k))) {
                return false;
            }
        }
        return true;
    }

    public int getHandId() {
        return handId;
    }

    public ArrayList<Integer> getRequiredHand() {
        return requiredHand;
    }

    public ArrayList<Integer> getKickers() {
        return kickers;
    }
}
