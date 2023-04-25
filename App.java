import Food.Ingredients.Ingredient;
import Food.Ingredients.IngredientNeeded;
import Food.Meals.Meal;
import Food.Recipes.Recipe;
import Food.ShoppingList;
import Util.JSONUtils;
import org.json.simple.parser.ParseException;

import Users.User;
import Workout.Workout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    static User currentUser;
    static ShoppingList shoppingList = new ShoppingList();

    public static void createUser(Scanner scanner) throws IOException {
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
        selectMenu();
    }

    public static void printAllUsers() {
        try {
            ArrayList<User> usersList = jsonUtils.getAllUsers();
            if(usersList.isEmpty()) {
                System.out.println("No users found. Press enter to return to menu:");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                selectMenu();
            }
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
                showMenu();
                break;
            }
        }
    }

    public static void AddShoppingList() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingredient Name:");
        String IngredientName = scanner.nextLine();
        System.out.println("Ingredient Amount:");
        Double IngredientAmount = Double.parseDouble(scanner.nextLine());
        IngredientNeeded ingredientNeeded = new IngredientNeeded(jsonUtils.getSingleIngredient(IngredientName), IngredientAmount);
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addingredient(ingredientNeeded);
        App.shoppingList = shoppingList;
    }

    public static void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to NUTRiAPP! Please selection an option below:\n");
        System.out.println("1. Go To Food Menu");
        System.out.println("2. Add to Shopping List");
        System.out.println("3. View the Shopping List");
        System.out.println("4. Show History");
        System.out.println("5. Add workout");
        System.out.println("6. Exit");

        String option = scanner.nextLine();
        if(option.contains("1")){
            FoodMenu();

        }
        else if(option.contains("2")){
            AddShoppingList();
            showMenu();
        }
        else if(option.contains("3")){
            if((!shoppingList.getShopList().isEmpty())) {
                ArrayList<IngredientNeeded> shopList = shoppingList.getShopList();
                for (IngredientNeeded ingredientNeeded : shopList) {
                    System.out.println(ingredientNeeded.getIngredient().getName() + ":  " + ingredientNeeded.getAmount());
                }
            } else {
                System.out.println("Shopping list empty. Press enter to continue:");
                scanner.nextLine();
            }
            showMenu();
        }
        else if(option.contains("4")){
            for(Workout workout: jsonUtils.getAllWorkouts()) {
                System.out.println(workout.getName() + ":  " + workout.getCalsBurned());
            }
            System.out.println("Press enter to return to menu:");
            scanner.nextLine();
            showMenu();
        }
        else if(option.contains("5")){
            createWorkout();
            showMenu();
        }
        else if(option.contains("6")){
            System.out.println("Goodbye!");
            System.exit(0);
        }
        else{
            System.out.println("Option does not exist. Please enter a different value.");
        }
    }

    public static void FoodMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select Food Option:\n");
        System.out.println("0. Return to Menu");
        System.out.println("1. Add Meal");
        System.out.println("2. Show All Meals");
        System.out.println("3. Delete Meal");
        System.out.println("4. Add Recipe");
        System.out.println("5. Show All Recipes");
        System.out.println("6. Delete Recipe");
        System.out.println("7. Exit");

        String option = scanner.nextLine();
        if(option.contains("0")){
            showMenu();
        }
        else if(option.contains("1")){
            ArrayList<Recipe> recipes = new ArrayList<>();
            System.out.println("Enter Meal Name:");
            String mealName = scanner.nextLine();

            do{
                System.out.println("Enter Recipe Name (EXACT):");
                String recipeName = scanner.nextLine();
                Recipe recipe = jsonUtils.getSingleRecipe(recipeName);
                recipes.add(recipe);
                System.out.println("Type Stop to stop writing ingredients, otherwise press any button:");
            }while(scanner.nextLine() != "stop");

            Meal newMeal = new Meal(mealName, recipes);
            jsonUtils.addMeal(newMeal);
            FoodMenu();
        }
        else if(option.contains("2")){
            Meal[] newMeal = jsonUtils.getAllMeals().toArray(new Meal[0]);
            for (Meal meal : newMeal) {
                System.out.println(meal.toString());
            }
            FoodMenu();
        }
        else if(option.contains("3")){
            System.out.println("Enter a meal to delete:");
            String mealInput = scanner.nextLine();
            Meal newMeal = jsonUtils.getSingleMeal(mealInput);
            jsonUtils.removeMeal(jsonUtils.getSingleMeal(mealInput));
            FoodMenu();
        }
        else if(option.contains("4")){
            ArrayList<IngredientNeeded> ingredients = new ArrayList<>();
            ArrayList<String> steps = new ArrayList<>();
            System.out.println("Enter Recipe Name:");
            String recipeName = scanner.nextLine();
            while(true){
                System.out.println("Enter Ingredient Name (EXACT):");
                String ingredientName = scanner.nextLine();
                System.out.println("Enter Ingredient Amount:");
                double ingredientAmount = scanner.nextDouble();
                Ingredient ingredientObject = jsonUtils.getSingleIngredient(ingredientName);
                IngredientNeeded ingredientNeeded = new IngredientNeeded(ingredientObject, ingredientAmount);
                ingredients.add(ingredientNeeded);
                System.out.println("Type Stop to stop writing ingredients, otherwise press any button:");
                scanner = new Scanner(System.in);
                if(scanner.nextLine().equalsIgnoreCase("stop")){
                    break;
                }
            }

            while(true) {
                System.out.println("Enter Step Directions:");
                String step = scanner.nextLine();
                steps.add(step);
                System.out.println("Type Stop to stop writing steps, otherwise press any button:");
                scanner = new Scanner(System.in);
                if(scanner.nextLine().equalsIgnoreCase("stop")){
                    break;
                }
            }

            Recipe newRecipe = new Recipe(recipeName, ingredients, steps);
            jsonUtils.addRecipe(newRecipe);
            FoodMenu();
        }
        else if(option.contains("5")){
            ArrayList<Recipe> newRecipe = jsonUtils.getAllRecipes();
            if(newRecipe.isEmpty()) {
                System.out.println("No Recipes. Press enter to return to menu:");
                scanner.nextLine();
            } else {
                for (Recipe recipe : newRecipe) {
                    System.out.println(recipe.toString());
                }
                System.out.println("Press enter to continue:");
                String wait = scanner.nextLine();
            }
            FoodMenu();
        }
        else if(option.contains("6")){
            System.out.println("Enter Recipe to delete:");
            String RecipeInput = scanner.nextLine();
            Recipe gotRecipe = jsonUtils.getSingleRecipe(RecipeInput);
            jsonUtils.removeRecipe(gotRecipe);
            FoodMenu();
        }
        else if(option.contains("7")){
            System.out.println("Goodbye!");
            System.exit(0);
        }
        else{
            System.out.println("Option does not exist. Please enter a different value.");
            FoodMenu();
        }
    }

    public static void deleteUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user to delete: ");
        String user = scanner.nextLine();
        User userToDelete = jsonUtils.getSingleUser(user);
        jsonUtils.removeUser(userToDelete);
        selectMenu();
    }

    public static void createWorkout() throws IOException {
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
                Workout workoutLow=new Workout(Workout.Intensity.LOW,enterworkoutname,enterduration);
                jsonUtils.addWorkout(workoutLow);
                break;

            case 2:
                Workout workoutMid=new Workout(Workout.Intensity.MEDIUM,enterworkoutname,enterduration);
                jsonUtils.addWorkout(workoutMid);
                break;

            case 3:
                Workout workoutHigh=new Workout(Workout.Intensity.HIGH,enterworkoutname,enterduration);
                jsonUtils.addWorkout(workoutHigh);
                break;
            default:
                System.out.println("thats not an actual option, try again");
                createWorkout();
                break;
        }
    }

    public static void selectMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to NUTRiAPP! Please selection an option below:\n");
        System.out.println("1. Create account");
        System.out.println("2. Select user");
        System.out.println("3. Delete user");
        System.out.println("4. Exit\n");

        String option = scanner.nextLine();
        if(option.contains("1")){
            createUser(scanner);
        }
        else if(option.contains("2")){
            printAllUsers();
        }
        else if(option.contains("3")){
            deleteUser();
        }
        else if(option.contains("4")){
            System.out.println("Goodbye!");
            System.exit(0);
        }
        else{
            System.out.println("Option does not exist. Please enter a different value.");
        }
    }

    private static JSONUtils jsonUtils = new JSONUtils();
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        // jsonUtils.test();

         selectMenu();

    }
}