package Hands;

import Main.*;

import java.util.ArrayList;

public interface Hand extends Comparable<Hand> {

    @Override
    public int compareTo(Hand o);
//
//    @Override
//    public String toString();

    public boolean equals(Hand o);

    public int getHandId();

    public ArrayList<Integer> getRequiredHand();

    public ArrayList<Integer> getKickers();
}
