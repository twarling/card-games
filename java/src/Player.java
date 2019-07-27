import java.util.ArrayList;
public class Player {
    private static ArrayList playerOne = new ArrayList();
    private static ArrayList playerTwo = new ArrayList();

    public static void addCard(int player, Card card){
            if(player == 1){
                playerOne.add(card);
            }

            else {
                playerTwo.add(card);
            }
    }

    public static void printPlayerSizes(){
        System.out.println("Player 1 has " + playerOne.size() + " cards.");
        System.out.println("Player 2 has " + playerTwo.size() + " cards.");
    }

    public static int playerSizes(int player){
        if(player == 1){
            return playerOne.size();
        }

        else{
            return playerTwo.size();
        }
    }

    public static Object getCard(int player){
        if(player == 1){
            return playerOne.remove(0);
        }

        else{
            return playerTwo.remove(0);
        }
    }

    public static void giveCards(int winner, ArrayList reward){
        while(reward.size() != 0){
            if(winner == 1){
                playerOne.add(reward.remove(0));
            }

            else {
                playerTwo.add(reward.remove(0));
            }
        }
    }
}
