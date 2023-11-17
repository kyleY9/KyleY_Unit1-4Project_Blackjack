import java.util.Scanner;

public class BlackjackRunner {
    public static void main(String[] args) {
        // creating scanner object for receiving user input
        Scanner scan = new Scanner(System.in);

        // introduction
        Blackjack obj = new Blackjack();
        System.out.println(obj.rand1to11());
        System.out.println(obj.rand1to2());
    }
}
