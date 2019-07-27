import com.sun.jdi.IntegerValue;

import java.util.ArrayList;

public class War {
    private static ArrayList battleCards = new ArrayList();

    public static void main(){
        distributeCards();
        battle();
    }


    private static void distributeCards(){
        for(int i = 0; i < 52; i = i + 2){
            Player.addCard(1, (Card)Deck.returnCard(i));
            Player.addCard(2, (Card)Deck.returnCard(i + 1));
        }

    }

    private static void battle(){
        String playerOneCard;
        String playerTwoCard;
        while(Player.playerSizes(1) != 0 && Player.playerSizes(2) != 0){
            playerOneCard = takeTopCard(1);
            playerTwoCard = takeTopCard(2);

            determineRoundWinner(playerOneCard, playerTwoCard);

            Player.printPlayerSizes();
            System.out.println();

            /*try{
                Thread.sleep(3000);
            }

            catch (InterruptedException x){

            }*/

        }

        declareWinner();
    }

    private static String takeTopCard(int player){
        Card card;
        if(Player.playerSizes(player) == 0){
            declareWinner();
        }
        card = (Card) Player.getCard(player);

        System.out.println("Player " + player + " has played the " + Card.returnValue(card) + " of " + Card.returnType(card));

        battleCards.add(card);

        return Card.returnValue(card);
    }

    private static void determineRoundWinner(String playerOneCard, String playerTwoCard){
        int playerOne;
        int playerTwo;
        int winner;

        if(playerOneCard.equals("Ace")){
            playerOne = 1;
        }

        else if(playerOneCard.equals("Jack")){
            playerOne = 11;
        }

        else if(playerOneCard.equals("Queen")){
            playerOne = 12;
        }

        else if(playerOneCard.equals("King")){
            playerOne = 13;
        }

        else {
            playerOne = Integer.parseInt(playerOneCard);
        }

        if(playerTwoCard.equals("Ace")){
            playerTwo = 1;
        }

        else if(playerTwoCard.equals("Jack")){
            playerTwo = 11;
        }

        else if(playerTwoCard.equals("Queen")){
            playerTwo = 12;
        }

        else if(playerTwoCard.equals("King")){
            playerTwo = 13;
        }

        else {
            playerTwo = Integer.parseInt(playerTwoCard);
        }

        winner = checkHigherCard(playerOne, playerTwo);
        giveCards(winner);
    }

    private static int checkHigherCard(int playerOne, int playerTwo){
        if(playerOne == playerTwo){
            warBattle();
        }

        if(playerOne < playerTwo){
            return 2;
        }

        else {
            return 1;
        }
    }

    private static void warBattle(){
        String playerOneCard;
        String playerTwoCard;

        for(int i = 0; i < 3; i++){
            takeTopCard(1);
            takeTopCard(2);
        }

        playerOneCard = takeTopCard(1);
        playerTwoCard = takeTopCard(2);

        determineRoundWinner(playerOneCard, playerTwoCard);
    }

    private static void giveCards(int winner){
        if(winner == 1){
            Player.giveCards(1, battleCards);
        }

        else {
            Player.giveCards(2, battleCards);
        }
    }

    private static void declareWinner(){
        if(Player.playerSizes(1) == 0){
            System.out.println("Player two has won!");
            System.exit(0);
        }

        else {
            System.out.println("Player one has won!");
            System.exit(0);
        }
    }
}
