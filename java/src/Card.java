public class Card {

    private String type;
    private String value;

    private static String[] cardType = {"Hearts", "Clubs", "Spades", "Diamonds"};
    private static String[] cardValue = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

   public Card(String type, String value){
       this.type = type;
       this.value = value;
   }

   public static Object createCard(int type, int value){
       return new Card(cardType[type], cardValue[value]);
   }


   public static String returnValue(Card card){
       return card.value;
   }

   public static String returnType(Card card){
       return card.type;
   }
}
