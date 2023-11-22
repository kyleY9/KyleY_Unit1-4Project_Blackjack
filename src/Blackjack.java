public class Blackjack {

    // instance variables
    private String decision;

    // regular variables
    String playerStr = "Your Hand: ";
    String botStr = "~(o_o)~: ???, ";
    int cardIdx;
    int botIdx;
    int totalValue;
    int botValue;

    // arrays
    int[] playerHand = {rand1to11(), rand1to11(), rand1to11(), rand1to11(), rand1to11(), rand1to11()};
    int[] botHand = {rand1to11(), rand1to11(), rand1to11(), rand1to11(), rand1to11(), rand1to11()};

    // constructor
    public Blackjack() {
    }
    public Blackjack(String decision) {
        this.decision = decision;
    }

    // methods
    public void gameP1() {
        System.out.println("\nThe dealer distributes the cards ...");
        playerStr += playerHand[0] + ", " + playerHand[1];
        botStr += botHand[1];
        totalValue += playerHand[0] + playerHand[1];
        botValue += botHand[0] + botHand[1];
        cardIdx = 1;
        botIdx = 1;
        System.out.println(playerStr);
        System.out.println(botStr);
    }

    public void gameP2() {
        if (decision.equals("Hit")) {
            System.out.println("You hit. A card has been added to your hand");
            playerStr += ", " + playerHand[cardIdx + 1];
            totalValue += playerHand[cardIdx + 1];
            cardIdx++;
            if (totalValue > 21) {
                System.out.println("Over 21! You bust! Defeat. :<");
                return;
            }
        } else {
            System.out.println("You stay. No changing your card values now.");
            System.out.println("It's the dealer's turn now.");
            if (botValue <= 16) {
                while (botValue <= 16) {
                    System.out.println("~(o_o)~: Hit me");
                    botStr += botHand[botIdx + 1];
                    botValue += botHand[botIdx + 1];
                    botIdx++;
                }
            }
        }
    }



    // helper methods
    public int rand1to11() {
        return (int) (Math.random() * 11) + 1;
    }

    public int rand1to2() {
        return (int) (Math.random() * 2) + 1;
    }
}
