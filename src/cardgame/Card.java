package cardgame;

public class Card {
    private final String number;
     private final String suite;

     public Card(String number, String suite) {
         this.number = number;
         this.suite = suite;
     }

     public String getCard() {
         return this.number.toString() + this.suite;
     }

     @Override
     public String toString() {
         return this.getCard();
     }
}
