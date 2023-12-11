/**
 * This class contains the code for a text-based Blackjack game.
 * @author Kyle Yang
 */
public class Blackjack {

    // instance variables
    /** The player's decision to "Hit" or "Stay" */
    private String decision;

    // color variables!
    /** Escape sequence for red text */
    final String RED_TEXT = "\u001B[31m";
    /** Escape sequence for green tect */
    final String GREEN_TEXT = "\u001B[32m";
    /** Escape sequence for color reset */
    final String RESET = "\u001B[0m";

    // static variables (shared by all instances of the class)
    /** The player's card hand as a string, to be printed later */
    private static String playerStr = "Your Hand: ";
    /** The bot's card hand as a string, to be printed later */
    private static String botStr = "~(o_o)~: ???, ";
    /** The current index in the player's hand */
    private static int cardIdx = 0;
    /** The current index in the bot's hand */
    private static int botIdx = 0;
    /** The current total value of the player's cards */
    private static int totalValue = 0;
    /** The current total value of the bot's cards */
    private static int botValue = 0;


    //  static arrays (shared by all instances of the class)
    /** Initializes an array representing the player's card hand */
    private static final int[] playerHand;
    /** Initializes an array reprsenting the bot's card hand */
    private static final int[] botHand;
    /** Initializes the array values randomly and sets their size */
    static { // initializes all arrays as soon as the class loads in
        int arraySize = 10;
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

    // constructor (overloaded)
    /** Instantiates a Blackjack object with no parameters */
    public Blackjack() {
    }

    /** Instantiates a Blackjack object
     *
     * @param decision
     */
    public Blackjack(String decision) {
        this.decision = decision;
    }

    // methods
    //instead of creating one entire game method, I split it into three to reduce clutter
    /** Operates part one of the game, where the first card values are handed out */
    public void gameP1() throws InterruptedException {  //game part 1
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
    /** Operates part two of the game, where the player chooses whether to hit or stay */
    public void gameP2() throws InterruptedException { //game part 2
        if (decision.equals("Hit")) {
            Thread.sleep(1000);
            System.out.println(this);
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
            System.out.println(this);
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
            System.out.println("~(o_o)~: I'm going to stay.");
        }
    }
    /** Operates part three of the game, when the final values are set for comparison */
    public void gameP3() throws InterruptedException { //game part 3
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

    // helper methods

    /** Sets the instance variable "decision" to user input
     *
     * @param decision
     */
    public void setDecision(String decision) {
        this.decision = decision;
    }

    /** Returns a random int between 1 and 11, inclusive.
     *
     * @return A random int from 1 to 11.
     */
    public static int rand1to11() {
        return (int) (Math.random() * 11) + 1;
    }

    /** toString method that returns a string based on variable "decision"
     *
     * @return A String
     */
    public String toString() { //toString method: immediately called when an object is printed
        boolean hitOrStay = decision.equals("Hit");
        if (hitOrStay) {
            return decision + ". A card has been added to your hand.";
        } else {
            return decision + ". Your hand is set. No changing your card values now.";
        }
    }
}