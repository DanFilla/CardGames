package Main;

public class Card {
    private final String number;
    private final String suite;
	private int parsedNumber;

    public Card(String number, String suite) {
        this.number = number;
        this.suite = suite;
    }

    public String getCard() {
        return this.number.toString() + this.suite;
    }

	public int getCardNumberAsInt() {

		if (this.number.equals("J")) {
			this.parsedNumber = 11;
		}else if (this.number.equals("Q")) {
			this.parsedNumber = 12;
		}else if (this.number.equals("K")) {
			this.parsedNumber = 13;
		}else if (this.number.equals("A")) {
			this.parsedNumber = 14;
		}else {
			parsedNumber = Integer.parseInt(this.number);
		}
		return parsedNumber;
	}

	public String getSuite() {
		return this.suite;
	}

    @Override
    public String toString() {
        return this.getCard();
    }
}
