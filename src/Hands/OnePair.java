package Hands;

import Main.*;

import java.util.ArrayList;
import java.util.Objects;

public class OnePair implements Hand {

    static final int handId = 8;
    private ArrayList<Integer> requiredHand = new ArrayList<>();
    private ArrayList<Integer> kickers = new ArrayList<>();


    public OnePair(ArrayList<Integer> aRequiredHand, ArrayList<Integer> aKickers) {
        this.requiredHand = new ArrayList<Integer>(aRequiredHand);
        this.kickers = new ArrayList<Integer>(aKickers);
    }

    @Override
    public int compareTo(Hand o) {
        if (handId > o.getHandId()) {
            return 1;
        }else if(handId < o.getHandId()) {
            return -1;
        }else {
            if (requiredHand.get(0) > o.getRequiredHand().get(0)) {
                return 1;
            }else if (requiredHand.get(0) < o.getRequiredHand().get(0)){
                return -1;
            }else {
                for (int i=kickers.size()-1; i>=0; i--) {
                    if (kickers.get(i) > o.getKickers().get(i)) {
                        return 1;
                    }else if (kickers.get(i) < o.getKickers().get(i)) {
                        return -1;
                    }
                }
            }

        }
        return 0;
    }

//    @Override
//    public String toString() {
//        return this.requiredHand.toString();
//    }

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
