import java.util.Scanner;

/**
 * Class BecomeMember stores the functionality for when the user needs to choose a membership .
 */

public class BecomeMember {

    int membership = 100;
    int durationA = 400; //1-2 månader – 400 SEK/månad
    int durationB = 350; //3-6 månader – 350 SEK/månad
    int durationC = 300; //7-12 månader – 300 SEK/månad
    int durationD = 250; //Längre än 12 månader – 250 SEK/månad
    int totalCost;
    int months;


    //calculate total membership cost
    public void calculateCost() {
        Scanner enterMonths = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many months will you become a member for? ");

        months = enterMonths.nextInt();
        enterMonths.close();
        if (months >= 1 && months <= 2) {
            totalCost = membership + durationA;
            System.out.println("You have chosen membership between 1-2 months, this will cost " + totalCost);
        }
        // if statements for choosing membership according to months and cost calculation
        else if (months >= 3 && months <= 6) {
            totalCost = membership + durationB;
            System.out.println("You have chosen membership between 3-6 months, this will cost " + totalCost);
        } else if (months >= 7 && months <= 12) {
            totalCost = membership + durationC;
            System.out.println("You have chosen membership between 7-12 months, this will cost " + totalCost);
        } else if (12 < months && months < 36) {
            totalCost = membership + durationD;
            System.out.println("You have chosen membership for over 12 months, this will cost " + totalCost);
        } else
            System.out.println("The number of months is invalid, please try again");
    }
}

