public class TESTING {
    public static void main(String[] args) {
        // THIS FILE IS NOT A PART OF MY PROJECT, IT IS MERELY FOR DEBUGGING PURPOSES
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        String str = "";
        str += nums[0] + ", " + nums[1];
        System.out.println(str);
        int idx = 1;
        str += ", " + nums[idx + 1];
        System.out.println(str);
        System.out.println(Blackjack.rand1to11()); // using static method in another class
    }
}
