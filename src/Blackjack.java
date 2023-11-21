public class Blackjack {

    // instance variables
    private String decision;

    // regular variables
    int playerCard1 = rand1to11();
    int playerCard2 = rand1to11();
    int playerCard3 = rand1to11();
    int playerCard4 = rand1to11();
    int playerCard5 = rand1to11();

    int unrevealedBotCard = rand1to11();
    int botCard2 = rand1to11();
    int botCard3 = rand1to11();
    int botCard4 = rand1to11();

    // constructor
    public Blackjack() {
    }
    public Blackjack(String decision) {
        this.decision = decision;
    }

    // methods
    public void gameP1() {
        System.out.println("\nThe dealer distributes the cards ...");
        System.out.println("Your hand: " + rand1to11() + ", " + rand1to11());
        System.out.println("~(o_o)~: ???, " + rand1to11());
    }

    public void gameP2() {

    }


    // helper methods
    public int rand1to11() {
        return (int) (Math.random() * 11) + 1;
    }

    public int rand1to2() {
        return (int) (Math.random() * 2) + 1;
    }
}
