import java.util.Scanner;

public class BlackjackRunner {
    public static void main(String[] args) {
        // creating scanner object for receiving user input
        Scanner scan = new Scanner(System.in);

        // introduction
        System.out.print("Welcome to Blackjack\n\nYour objective is to win against the dealer, a randomized bot. Cards will be labeled 1-11.\n\"Hit\" to get another card. \"Stay\" to stay with your hand.\nIf the value of your cards go over 21, or is less than the bot's hand, then you bust (lose).\nIf you get a 21, or a value over the bot's hand, then you win!");
        System.out.print("Au ready? ");
        String readyOrNot = scan.nextLine();
        while (!(readyOrNot.equals("Yes") && readyOrNot.equals("yes"))) {
            System.out.print("I said. Are. You. Ready. ");
            readyOrNot = scan.nextLine();
        }
    }
}
