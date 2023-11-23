public class Blackjack {

    // instance variables
    private String decision;

    // color variables!
    final String RED_TEXT = "\u001B[31m";
    final String GREEN_TEXT = "\u001B[32m";
    final String RESET = "\u001B[0m";

    // static variables (shared by all instances of the class)
    private static String playerStr = "Your Hand: ";
    private static String botStr = "~(o_o)~: ???, ";
    private static int cardIdx = 0;
    private static int botIdx = 0;
    private static int totalValue = 0;
    private static int botValue = 0;


    //  static arrays (shared by all instances of the class)
    private static final int[] playerHand;
    private static final int[] botHand;
    static { // initializes all arrays as soon as the class loads in
        int arraySize = 8;
        playerHand = new int[arraySize];
        botHand = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            playerHand[i] = rand1to11();
            botHand[i] = rand1to11();
            while ((playerHand[0] == 11 && playerHand[1] == 11)) {
                playerHand[0] = rand1to11(); // ensures the player doesn't bust immediately by chance
            }
            while ((botHand[0] == 11 && botHand[1] == 11)) {
                botHand[0] = rand1to11();
            }
        }
    }

    // constructor
    public Blackjack() {
    }

    public Blackjack(String decision) {
        this.decision = decision;
    }

    // methods
    public void gameP1() throws InterruptedException {
        System.out.println("\nThe dealer distributes the cards ...");
        playerStr += playerHand[0] + ", " + playerHand[1];
        botStr += botHand[1];
        totalValue += playerHand[0] + playerHand[1];
        botValue += botHand[0] + botHand[1];
        cardIdx++;
        botIdx++;
        Thread.sleep(1500);
        System.out.println(playerStr);
        Thread.sleep(1500);
        System.out.println(botStr);
    }

    public void gameP2() throws InterruptedException {
        if (decision.equals("Hit")) {
            Thread.sleep(1000);
            System.out.println("You hit. A card has been added to your hand");
            playerStr += ", " + playerHand[cardIdx + 1];
            totalValue += playerHand[cardIdx + 1];
            cardIdx++;
            Thread.sleep(1000);
            System.out.println(playerStr);
            Thread.sleep(1000);
            if (totalValue > 21) {
                System.out.println(RED_TEXT + "Over 21! You bust! Defeat. :<" + RESET);
                System.exit(0);
            } else if (totalValue == 21) {
                System.out.println(GREEN_TEXT + "Blackjack! You win!!! :D" + RESET);
                System.exit(0);
            }
        } else {
            System.out.println("You stay. No changing your card values now.");
            Thread.sleep(1500);
            System.out.println("\nIt's the dealer's turn.");
            if (botValue <= 16) {
                while (botValue <= 16) {
                    botStr += ", " + botHand[botIdx + 1];
                    botValue += botHand[botIdx + 1];
                    botIdx++;
                    Thread.sleep(1500);
                    System.out.println("~(o_o)~: Hit me");
                    Thread.sleep(1500);
                    System.out.println(botStr);
                }
            }
            Thread.sleep(1500);
            System.out.println("\nIt's time for the final comparison");
            Thread.sleep(1500);
            System.out.println(playerStr);
            Thread.sleep(1500);
            System.out.println(botStr);
            Thread.sleep(1500);
            System.out.println("Dealer's unrevealed card: " + botHand[0]);
            Thread.sleep(1500);
            System.out.println("\nYour total: " + totalValue + "\nDealer's total: " + botValue);
            Thread.sleep(1500);
            if (botValue > 21) {
                System.out.println(GREEN_TEXT + "The dealer busts! You automatically win!" + RESET);
            } else if (totalValue > botValue) {
                System.out.println(GREEN_TEXT + "You beat the dealer! Congrats! He'll get you back next time though ..." + RESET);
            } else if (totalValue < botValue) {
                System.out.println(RED_TEXT + "The dealer beat you ... you can hear his laughter as he mocks your failure." + RESET);
            } else {
                System.out.println("Wow! You two got the same score. The dealer is ... perturbed <(-_-)>");
            }
        }
    }


    // helper methods
    public void setDecision(String decision) {
        this.decision = decision;
    }
    public static int rand1to11() {
        return (int) (Math.random() * 11) + 1;
    }
}