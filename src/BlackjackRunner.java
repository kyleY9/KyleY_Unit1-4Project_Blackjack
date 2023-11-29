import java.util.Scanner;

public class BlackjackRunner {
    public static void main(String[] args) throws InterruptedException  {
        // color variables!
        final String BLACK_TEXT = "\u001B[30m";
        final String RED_BK = "\u001B[41m";
        final String RESET = "\u001B[0m";

        // creating scanner object for receiving user input
        Scanner scan = new Scanner(System.in);
        Blackjack obj1 = new Blackjack(); // first object instantiation

        // introduction
        System.out.print(BLACK_TEXT + RED_BK + "Welcome to Blackjack" + RESET);
        System.out.print("\n\nYour objective is to win against the dealer, a randomized bot. Cards will be labeled 1-11.\n\"Hit\" to get another card. \"Stay\" to stay with your hand.\nIf the value of your cards go over 21, or is less than the bot's hand, then you bust (lose).\nIf you get a 21, or a value greater than the bot's hand, then you win!\n~(o_o)~  <--- This is the dealer");
        System.out.print("\n\nAre you ready? ");
        String readyOrNot = scan.nextLine();
        while (!(readyOrNot.equals("Yes") || readyOrNot.equals("yes"))) {
            System.out.print("I said. Are. You. Ready. ");
            readyOrNot = scan.nextLine();
        }

        // start game
        obj1.gameP1();
        Thread.sleep(1500);
        System.out.print("\nDo you want to \"Hit\" or \"Stay\"? ");
        String decision = scan.nextLine();
        while (!(decision.equals("Hit") || decision.equals("Stay"))) {
            System.out.print("Hit or Stay? ");
            decision = scan.nextLine();
        }
        Blackjack obj2 = new Blackjack(decision); // second object instantiation
        while (!(decision.equals("Stay"))) {
            obj2.gameP2();
            System.out.print("Hit or Stay? ");
            decision = scan.nextLine();
            while (!(decision.equals("Hit") || decision.equals("Stay"))) {
                System.out.print("Hit or Stay? ");
                decision = scan.nextLine();
            }
            obj2.setDecision(decision);
        }
        obj2.gameP2();
        Thread.sleep(1500);
        obj2.gameP3();
    }
}
