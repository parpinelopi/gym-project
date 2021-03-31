import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterfaceGym {


    HashMap<String, Boolean> choosePlace;

    public InterfaceGym(HashMap<String, Boolean> map) {
        choosePlace = map;
    }

    public static HashMap<String, Boolean> HashMapFromTextFile() {
        HashMap<String, Boolean> returnChoosePlace = new HashMap<>();
        BufferedReader readFile = null;
        try {

            // create file object
            File file = new File("hashmap.txt");

            // create BufferedReader object from the File
            readFile = new BufferedReader(new FileReader(file));

            String line ;

            // read file line by line
            while ((line = readFile.readLine()) != null) {

                // split the line by :
                String[] parts = line.split(":");

                // first part is activity, second is place
                String activity = parts[0].trim();
                Boolean place = Boolean.valueOf(parts[1].trim());

                //put name, boolean in HashMap if they are not empty
                if (!activity.equals(""))
                    returnChoosePlace.put(activity, place);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // close the BufferedReader
            if (readFile != null) {
                try {
                    readFile.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return returnChoosePlace;
    }


    public void writeToFile() {

        File file = new File("hashmap.txt");

        BufferedWriter bf = null;

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
                //close the writer
               bf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getChoosePlace(String activity, Boolean place) {
        choosePlace.replace(activity, place);
    }

    public  HashMap<String, Boolean> getReturnHashMap() {
        return choosePlace;
    }

    public static void start() throws IOException {

        //create hashmap 'map' which will store the hashmap read from the file hashmap.txt
        HashMap<String, Boolean> map = HashMapFromTextFile();
        String menuInput;
        BecomeMember beMember;
        beMember = new BecomeMember();
        LogIn login;
        login = new LogIn();
        Logout logout;
        logout= new Logout();
        //create interface constructor
        InterfaceGym gym = new InterfaceGym(map);
        BookActivity activity;
        activity = new BookActivity(gym);
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
                try {
                    beMember.calculateCost();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                logout.Logout();
                return;
            default:
                System.out.println("You have entered invalid choice. Please try again");

        }
    }

    public static void main(String[] args) throws IOException {
        start();
        HashMapFromTextFile();
    }
}


