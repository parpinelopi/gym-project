import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class Login stores the functionality for the user's login,
 * validating the personalnumber's format and also its overall validity with the Luhn algorithm.
 */

//Validate with Luhn algorithm

//1. Multiplicera varje siffra i det niosiffriga personnumret (personnummer utan kontrollsiffra) med varannan gång
//1 och 2. Börja från vänster, med 2. Om produkten skulle bli tvåsiffrig summeras de två siffrorna ihop och resultatet används istället. (.length-1)
//2. Addera samtliga dessa produkter till en stor summa.
//3. Om man adderar kontrollsiffran till denna summa ska man få ett tal jämnt delbart med 10.

public class LogIn {

    public void logUser() {
        System.out.println("Enter personal number in this format YYMMDD-XX :");
        Scanner scanner = new Scanner(System.in);
        String persNr = scanner.nextLine();
        System.out.println(persNr);
        boolean matchPattern = Pattern.matches("\\d\\d\\d\\d\\d\\d-\\d\\d\\d\\d", persNr);

        scanner.close();
        if (matchPattern) {
            System.out.println("Personal number format is correct");

            //Parse scanner input in array
            persNr = persNr.replaceAll("[^a-zA-Z0-9]", "");
            char[] numberInput = persNr.toCharArray();
            int[] persnrArray = new int[persNr.length()];

            for (int i = 0; i < persNr.length(); i++) {
                persnrArray[i] = Character.getNumericValue(numberInput[i]);
            }

            int sum = 0;
            for (int i = 0; i <= persnrArray.length - 2; i = i + 1) {
                int j = persnrArray[i];
                if (i % 2 == 0) {
                    j = j * 2;
                }
                int next = 0;
                if (j > 9) {
                    int small = j % 10;
                    int big = j / 10;
                    sum += small + big;
                    next = small + big;
                } else {
                    sum += j;
                    next = j;
                }

            }
            System.out.println(sum);
            if ((sum + persnrArray[persnrArray.length - 1]) % 10 == 0) {
                System.out.println("Personal number is valid, you have successfully logged in");
            } else {
                System.out.println("The personal number is invalid, try once more");

            }
        } else {
            System.out.println("The personal number has incorrect format, please try again");
        }


    }


}

