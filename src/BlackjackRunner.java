import java.util.Scanner;

public class BlackjackRunner {
    public static void main(String[] args) {
        // creating scanner object for receiving user input
        Scanner scan = new Scanner(System.in);
        Blackjack obj = new Blackjack();

        // introduction
        System.out.print("Welcome to Blackjack\n\nYour objective is to win against the dealer, a randomized bot. Cards will be labeled 1-11.\n\"Hit\" to get another card. \"Stay\" to stay with your hand.\nIf the value of your cards go over 21, or is less than the bot's hand, then you bust (lose).\nIf you get a 21, or a value greater than the bot's hand, then you win!\n~(o_o)~  <--- This is the dealer");
        System.out.print("\n\nAre you ready? ");
        String readyOrNot = scan.nextLine();
        while (!(readyOrNot.equals("Yes") || readyOrNot.equals("yes"))) {
            System.out.print("I said. Are. You. Ready. ");
            readyOrNot = scan.nextLine();
        }

        // start game
        obj.gameP1();
        System.out.print("\nDo you want to \"Hit\" or \"Stay\"? ");
        String decision = scan.nextLine();
        while (!(decision.equals("Hit") || decision.equals("Stay"))) {
            System.out.print("Hit or Stay? ");
            decision = scan.nextLine();
        }
        Blackjack obj2 = new Blackjack(decision);
        while (!(decision.equals("Stay"))) {
            obj2.gameP2();
            System.out.print("Hit or Stay? ");
            decision = scan.nextLine();
        }
        obj2.gameP2();
    }
}
