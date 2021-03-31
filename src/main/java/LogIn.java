import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;

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
    String persNr;
    String userToken;
    String nameUser;

    public void logUser() throws IOException {
        System.out.println("Enter personal number in this format YYMMDD-XXXX :");
        Scanner scanner = new Scanner(System.in);
        persNr = scanner.nextLine();
        //trying to check if name of user will be stored
        nameUser = scanner.nextLine();
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
                createUserToken();
            } else {
                System.out.println("The personal number is invalid, try once more");

            }
        } else {
            System.out.println("The personal number has incorrect format, please try again");
        }


    }
    //create user token will save the personal number and the name of the user as a string

    public void createUserToken() {


        BufferedWriter token = null;

        try {
            userToken = persNr;
            //Specify the file name and path here
            File userFile = new File("user.txt");

            /* This logic will make sure that the file
             * gets created if it is not present at the
             * specified location*/
            if (!userFile.exists()) {
                userFile.createNewFile();
            }

            FileWriter tokenWriter = new FileWriter(userFile);
            token = new BufferedWriter(tokenWriter);
            token.write(nameUser + "-" + userToken);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            {
                try {
                    if (token != null)
                        token.close();
                } catch (Exception ex) {
                    System.out.println("Error in closing the BufferedWriter" + ex);
                }

            }


        }
    }

}

