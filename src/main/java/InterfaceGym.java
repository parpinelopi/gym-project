import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterfaceGym {
    public void writeToFile() {

        File file = new File("hashmap.txt");

        BufferedWriter bf = null;
        ;

        try {

            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            //iterate map entries
            for (Map.Entry<String, Boolean> entry : choosePlace.entrySet()) {

                //put key and value separated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());

                //new line
                bf.newLine();
            }

            bf.flush();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            try {
                //always close the writer
                bf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getChoosePlace(String activity, Boolean place) {
        choosePlace.replace(activity, place);
    }

    public HashMap<String, Boolean> getReturnHashMap() {
        return choosePlace;
    }


    public static void main(String[] args) {
        String menuInput;
        BecomeMember beMember;
        beMember = new BecomeMember();
        LogIn login;
        login = new LogIn();
        BookActivity activity;
        activity = new BookActivity();
        Scanner menu = new Scanner(System.in);

//add positions for each activity in the hashmap
        //System.out.println(choosePlace);
        //System.out.println("is empty? " + choosePlace.isEmpty());


        System.out.println("\n");
        System.out.println("Welcome Gym WakeUp");

        //IntefaceMenu/Choices
        System.out.println("Enter your choice from the menu");
        System.out.println("\n");
        System.out.println(" Menu ");
        System.out.println("1. Become member");
        System.out.println("2. Login");
        System.out.println("3. Book activity");
        System.out.println("4. Quit application");
        System.out.println("\n");

        System.out.println("Enter your choice here: ");
        menuInput = menu.nextLine();

        switch (menuInput) {
            case "1":
                //Call method become member
                beMember.calculateCost();
                break;
            case "2":
                login.logUser();
                break;
            case "3":
                activity.chooseInterface();
                break;
            case "4":
                menu.close();
                System.out.println("Thank you for using Gym WakeUp. See you next time.");
                return;
            default:
                System.out.println("You have entered invalid choice. Please try again");

        }
    }
}

