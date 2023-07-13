import java.util.ArrayList;
import java.util.Scanner;

public class ratingsCalc {
    Scanner myScanner = new Scanner(System.in);
    ArrayList<Integer> ratings = new ArrayList<Integer>();

    public void gatherUserInput() {
        System.out.println();
        System.out.println("Please enter your ratings one at a time and in order from most recent to least recent, or press 1 to calculate your rating. Press 0 to quit the application.");
        System.out.print("> ");
        int userInput = myScanner.nextInt();

        if (userInput == 1) {
            calculate();
        } else if (userInput == 0) {
            
        } else {
            ratings.add(userInput);
            System.out.println();
            System.out.println("Your ratings are now: " + ratings);
            gatherUserInput();
        }
    }

    public void calculate() {
        double numOfDoubledRatings;
        if (ratings.size() >= 9) {
            numOfDoubledRatings = Math.round(ratings.size() * 0.25);
            //System.out.println(numOfDoubledRatings);
        } else {
            numOfDoubledRatings = 0;
        }

        for (int i = 0; i < numOfDoubledRatings; i++) {
            int doubled = ratings.get(i);
            ratings.set(i, doubled * 2);
        }

        /*System.out.println();
        System.out.println("Your ratings including the doubled values are: " + ratings);*/

        int total = 0;
        for (int i = 0; i < ratings.size(); i++) {
            total += ratings.get(i);
        }
        double playerRating = Math.ceil(total / (ratings.size() + numOfDoubledRatings));

        System.out.println();
        System.out.println("Your PDGA player rating is: ~" + playerRating);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        ratingsCalc calculator = new ratingsCalc();
        calculator.gatherUserInput();
    }
}