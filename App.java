import Util.JSONUtils;
import Workout.Workout;
import Workout.Workout.Intensity;

import org.json.simple.parser.ParseException;

import Users.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static User currentUser;
    
    public static void createUser(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your height (in cm): ");
            int height =  Integer.parseInt(scanner.nextLine());
            System.out.println("Enter your weight (in kg): ");
            Double weight = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter your date of birth (yyyy-mm-dd): ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());
            User user = new User(username, name, height, weight, birthDate);
            try {
                jsonUtils.addUser(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void createWorkout(){
            Scanner scanner = new Scanner(System.in); 
            System.out.println("Enter Name of workout: ");
                String enterworkoutname = scanner.nextLine();
            System.out.println("Enter Workout Intensity: ");
            System.out.println("1.Low");
            System.out.println("2.Medium");
            System.out.println("3.High");
                int enterintensity = scanner.nextInt();
            System.out.println("Please Enter Duration");
                int enterduration=scanner.nextInt();
            
            switch(enterintensity){
                case 1:
                Workout workoutlow=new Workout(Intensity.LOW);
                break;
                
                case 2:
                Workout workoutmid=new Workout(Intensity.MEDIUM);
                break;
        
                case 3:
                Workout workouthigh=new Workout(Intensity.HIGH);
                break;
                default:
                System.out.println("thats not an actual option, try again");
                createWorkout();
                break;
            } 
    }

    public static void printAllUsers() {
        try {
            ArrayList<User> usersList = jsonUtils.getAllUsers();
            HashMap mapUserSelection = new HashMap();
            int x = 1;
            for (User user : usersList) {
                mapUserSelection.put(x, user.getUsername());
                x+=1;
            }
            for(Object key : mapUserSelection.keySet()){
                System.out.println(key + ". " + mapUserSelection.get(key));
            }
            selectUser(mapUserSelection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectUser(HashMap map) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a user by number: ");
        String user = scanner.nextLine();
        for(Object key : map.keySet()){
            if(user.contains(String.valueOf(key))){
                currentUser = jsonUtils.getSingleUser(map.get(key).toString());
                break;
            }
        }
    }

    public static void deleteUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user to delete: ");
        String user = scanner.nextLine();
        User userToDelete = jsonUtils.getSingleUser(user);
        jsonUtils.removeUser(userToDelete);
    }

    public static void selectMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to NUTRiAPP! Please selection an option below:\n");
        System.out.println("1. Create account");
        System.out.println("2. Select user");
        System.out.println("3. Delete user\n");

        String option = scanner.nextLine();
        if(option.contains("1")){
            createUser();
        }
        else if(option.contains("2")){
            printAllUsers();
        }
        else if(option.contains("3")){
            deleteUser();
        }
        else{
            System.out.println("Option does not exist. Please enter a different value.");
        }
    }

    private static JSONUtils jsonUtils = new JSONUtils();
    public static void main(String[] args) throws IOException, ParseException {
        // jsonUtils.test();

        selectMenu();

    }
}