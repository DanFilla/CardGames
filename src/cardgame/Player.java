package cardgame;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Player {

	private static int nextId = 0;

	private final int id;
    private String name;
    private final ArrayList<Card> hand = new ArrayList<>();
	private Boolean hasChecked = false;
	private Boolean hasFolded = false;
	private int currentBet = 0;
	private int bank = 500;
	private Map<Integer, Integer> handMap;

	public Player () {
		this.id = nextId;
		nextId++;
	}

    public Player(String name) {
		this();
        this.name = name;
    }

    public void draw(Deck deck, int numCards) {
        for (int i=0; i < numCards; i++) {
            hand.add(deck.draw());
        }
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public Boolean getHasChecked() {
		return this.hasChecked;
	}

	public void resetHasChecked() {
		this.hasChecked = false;
	}

	public Boolean getHasFolded() {
		return this.hasFolded;
	}

	public Map<Integer, Integer> getHandMap() {
		return this.handMap;
	}

	public void setHandMap(Map<Integer, Integer> hMap) {
		this.handMap = hMap;
	}

	public int getCurrentBet() {
		return this.currentBet;
	}

	public void resetCurrentBet() {
		this.currentBet = 0;
	}


	public void bet(Boolean firstRound) {
		Scanner input = new Scanner(System.in);
		System.out.println(this.toString());
		if (!firstRound){
			System.out.println("Your current bet is " + this.currentBet);
		}
		System.out.println("How much would " + this.name + " like to bet?");
		String betNum = input.nextLine();
		if (betNum.equals("fold")) {
			this.hasFolded = true;
			return;
		}
		int betNumInt = Integer.parseInt(betNum);

		if (betNumInt > bank) {
			return;
		}else if (betNumInt == 0) {
			this.hasChecked = true;
		}else {
			this.bank -= betNumInt;
			this.currentBet += betNumInt;
		}
	}

    @Override
    public String toString() {
        String str = this.name + "'s hand is:";
        for (Card acard : hand) {
            str += " " + acard;
        }
        return str;
    }
}
