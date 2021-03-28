import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BookActivity {

    String activityInput;
    String activityPositionAero;
    String activityPositionSpin;
    String activityPositionYoga;
    InterfaceGym interGym = new InterfaceGym();

    public void aerobicsPosition() {
        if (activityPositionAero.equals("Aero1a")) {
            interGym.getChoosePlace("Aero1a", false);
            System.out.println("The place 1a has been booked");
        } else if (activityPositionAero.equals("Aero1b")) {
            interGym.getChoosePlace("Aero1b", false);
            System.out.println("The place 1b has been booked");
        } else if (activityPositionAero.equals("Aero1c")) {
            interGym.getChoosePlace("Aero1c", false);
            System.out.println("The place 1c has been booked");
        } else if (activityPositionAero.equals("Aero2a")) {
            interGym.getChoosePlace("Aero2a", false);
            System.out.println("The place 2a has been booked");
        } else if (activityPositionAero.equals("Aero2b")) {
            interGym.getChoosePlace("Aero2b", false);
            System.out.println("The place 2b has been booked");
        } else if (activityPositionAero.equals("Aero2c")) {
            interGym.getChoosePlace("Aero2c", false);
            System.out.println("The place 2c has been booked");
        } else if (activityPositionAero.equals("Aero3a")) {
            interGym.getChoosePlace("Aero3a", false);
            System.out.println("The place 3a has been booked");
        } else if (activityPositionAero.equals("Aero3b")) {
            interGym.getChoosePlace("Aero3b", false);
            System.out.println("The place 3b has been booked");
        } else if (activityPositionAero.equals("Aero3c")) {
            interGym.getChoosePlace("Aero3c", false);
            System.out.println("The place 3c has been booked");
        } else {
            System.out.println("This seat is not available try booking another one");
        }
        //System.out.println("You can also choose another activity");
        System.out.println(interGym.getReturnHashMap());
        interGym.writeToFile();
    }


    public void spinningPosition() {
        if (activityPositionSpin.equals("Spin1a")) {
            interGym.getChoosePlace("Spin1a", false);
            System.out.println("The place 1a has been booked");
        } else if (activityPositionAero.equals("Spin1b")) {
            interGym.getChoosePlace("Spin1b", false);
            System.out.println("The place 1b has been booked");
        } else if (activityPositionAero.equals("Spin1c")) {
            interGym.getChoosePlace("Spin1c", false);
            System.out.println("The place 1c has been booked");
        } else if (activityPositionAero.equals("Spin2a")) {
            interGym.getChoosePlace("Spin2a", false);
            System.out.println("The place 2a has been booked");
        } else if (activityPositionAero.equals("Spin2b")) {
            interGym.getChoosePlace("Spin2b", false);
            System.out.println("The place 2b has been booked");
        } else if (activityPositionAero.equals("Spin2c")) {
            interGym.getChoosePlace("Spin2c", false);
            System.out.println("The place 2c has been booked");
        } else if (activityPositionAero.equals("Spin3a")) {
            interGym.getChoosePlace("Spin3a", false);
            System.out.println("The place 3a has been booked");
        } else if (activityPositionAero.equals("Spin3b")) {
            interGym.getChoosePlace("Spin3b", false);
            System.out.println("The place 3b has been booked");
        } else if (activityPositionAero.equals("Spin3c")) {
            interGym.getChoosePlace("Spin3c", false);
            System.out.println("The place 3c has been booked");
        } else {
            System.out.println("This seat is not available try booking another one");
        }
        System.out.println(interGym.getReturnHashMap());
        interGym.writeToFile();
    }

    public void yogaPosition() {
        if (activityPositionYoga.equals("Yoga1a")) {
            interGym.getChoosePlace("Yoga1a", false);
            System.out.println("The place 1a has been booked");
        } else if (activityPositionAero.equals("Yoga1b")) {
            interGym.getChoosePlace("Yoga1b", false);
            System.out.println("The place 1b has been booked");
        } else if (activityPositionAero.equals("Yoga1c")) {
            interGym.getChoosePlace("Yoga1c", false);
            System.out.println("The place 1c has been booked");
        } else if (activityPositionAero.equals("Yoga2a")) {
            interGym.getChoosePlace("Yoga2a", false);
            System.out.println("The place 2a has been booked");
        } else if (activityPositionAero.equals("Yoga2b")) {
            interGym.getChoosePlace("Yoga2b", false);
            System.out.println("The place 2b has been booked");
        } else if (activityPositionAero.equals("Yoga2c")) {
            interGym.getChoosePlace("Yoga2c", false);
            System.out.println("The place 2c has been booked");
        } else if (activityPositionAero.equals("Yoga3a")) {
            interGym.getChoosePlace("Yoga3a", false);
            System.out.println("The place 3a has been booked");
        } else if (activityPositionAero.equals("Yoga3b")) {
            interGym.getChoosePlace("Yoga3b", false);
            System.out.println("The place 3b has been booked");
        } else if (activityPositionAero.equals("Yoga3c")) {
            interGym.getChoosePlace("Yoga3c", false);
            System.out.println("The place 3c has been booked");
        } else {
            System.out.println("This seat is not available try booking another one");
        }
        System.out.println(interGym.getReturnHashMap());
        interGym.writeToFile();
    }


    public void chooseInterface() throws IOException {
        //interGym.readFromFile();
        BufferedReader loginExists = new BufferedReader(new FileReader("user.txt"));
        if (loginExists.readLine() != null) {
            Scanner activitymenu = new Scanner(System.in);
            System.out.println("Choose one of the following activities: ");
            System.out.println("\n");
            System.out.println("1. Aerobics");
            System.out.println("2. Spinning");
            System.out.println("3. Yoga");
            System.out.println("\n");
            activityInput = activitymenu.nextLine();


            try {
                switch (activityInput) {
                    case "1" -> {
                        Scanner position = new Scanner(System.in);
                        System.out.println("Choose one of the following spaces: ");
                        System.out.println("\n");
                        System.out.println("1a");
                        System.out.println("1b");
                        System.out.println("1c");
                        System.out.println("2a");
                        System.out.println("2b");
                        System.out.println("2c");
                        System.out.println("3a");
                        System.out.println("3b");
                        System.out.println("3c");
                        System.out.println("\n");
                        activityPositionAero = "Aero" + position.next();
                        aerobicsPosition();
                        //position.close();
                        System.out.println(activityPositionAero);
                        //aerobicsPosition();
                        break;
                    }
                    case "2" -> {
                        Scanner position = new Scanner(System.in);
                        System.out.println("Choose one of the following spaces: ");
                        System.out.println("\n");
                        System.out.println("1a");
                        System.out.println("1b");
                        System.out.println("1c");
                        System.out.println("2a");
                        System.out.println("2b");
                        System.out.println("2c");
                        System.out.println("3a");
                        System.out.println("3b");
                        System.out.println("3c");
                        System.out.println("\n");
                        activityPositionSpin = "Spin" + position.next();
                        spinningPosition();
                        //position.close();
                        System.out.println(activityPositionSpin);
                        //spinningPosition();
                        break;
                    }
                    case "3" -> {
                        Scanner position = new Scanner(System.in);
                        System.out.println("Choose one of the following spaces: ");
                        System.out.println("\n");
                        System.out.println("1a");
                        System.out.println("1b");
                        System.out.println("1c");
                        System.out.println("2a");
                        System.out.println("2b");
                        System.out.println("2c");
                        System.out.println("3a");
                        System.out.println("3b");
                        System.out.println("3c");
                        System.out.println("\n");
                        activityPositionYoga = "Yoga" + position.next();
                        yogaPosition();
                        //position.close();
                        System.out.println(activityPositionYoga);
                        //yogaPosition();
                        break;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + activityInput);

                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        } else {
            LogIn login;
            login = new LogIn();
            System.out.println("Please, login first!");
            login.logUser();

        }
    }
}



