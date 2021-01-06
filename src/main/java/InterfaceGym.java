import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterfaceGym {
    HashMap<String, Boolean> choosePlace = new HashMap<>() {{
        put("Aero1a", true);
        put("Aero1b", true);
        put("Aero1c", true);
        put("Aero2a", true);
        put("Aero2b", true);
        put("Aero2c", true);
        put("Aero3a", true);
        put("Aero3b", true);
        put("Aero3c", true);
        put("Spin1a", true);
        put("Spin1b", true);
        put("Spin1c", true);
        put("Spin2a", true);
        put("Spin2b", true);
        put("Spin2c", true);
        put("Spin3a", true);
        put("Spin3b", true);
        put("Spin3c", true);
        put("Yoga1a", true);
        put("Yoga1b", true);
        put("Yoga1c", true);
        put("Yoga2a", true);
        put("Yoga2b", true);
        put("Yoga2c", true);
        put("Yoga3a", true);
        put("Yoga3b", true);
        put("Yoga3c", true);
    }};
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

