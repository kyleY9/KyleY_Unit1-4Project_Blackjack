public class Blackjack {

    // instance variables
    private String decision;

    // constructor
    public Blackjack() {
    }
    public Blackjack(String decision) {
        this.decision = decision;
    }

    // methods




    // helper methods
    public int rand1to11() {
        return (int) (Math.random() * 11) + 1;
    }

    public int rand1to2() {
        return (int) (Math.random() * 2) + 1;
    }
}
