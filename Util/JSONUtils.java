package Util;

import Food.Ingredients.Ingredient;
import Food.Ingredients.IngredientNeeded;
import Food.Ingredients.Ingredients;
import Food.Meals.Meal;
import Food.Recipes.Recipe;
import Food.Recipes.Recipes;
import Users.User;
import Users.Users;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class JSONUtils {
    public JSONUtils() {

    }

    public void test() throws IOException, ParseException {
        LocalDate date = LocalDate.of(1998, 7, 10);
        User testUser = new User("TestA", "Josh S", 100, 200, date);
        addUser(testUser);
        User testUser2 = new User("TestB", "Max S", 150, 300, date);
        addUser(testUser2);
        User getUser2 = getSingleUser("TestB");
        removeUser(getUser2);
        createIngredientsJSON();
        ArrayList<IngredientNeeded> ingredientsList = new ArrayList<>();
        ArrayList<String> stepsList = new ArrayList<>();
        stepsList.add("Step1");
        ingredientsList.add(new IngredientNeeded(new Ingredient("Butter", 10,
                10, 10, 10, 10, 10), 10));
        ingredientsList.add(new IngredientNeeded(new Ingredient("Apples", 10,
                10, 10, 10, 10, 10), 10));
        Recipe testRecipe = new Recipe("TestRecipe", 10, 10, 10, 10, 10,
                ingredientsList, stepsList);
        addRecipe(testRecipe);
        testSearch();
    }

    public ArrayList<Ingredient> parseAvailableIngredients() throws FileNotFoundException {
        Gson gson = new Gson();
        ArrayList<Ingredient> ingredientsList = new ArrayList<>();
        File checkFile = new File("Data/Ingredients.json");
        if (checkFile.exists() && checkFile.length() != 0) {
            JsonReader jsonReader = new JsonReader(new FileReader("Data/Ingredients.json"));
            Ingredients ingredientGson = gson.fromJson(jsonReader, Ingredients.class);
            List<Ingredient> ingredients = ingredientGson.getIngredients();
            ingredientsList.addAll(ingredients);
        }
        return ingredientsList;
    }

    private void closeWriter(JsonWriter writer) throws IOException {
        writer.endArray();
        writer.endObject();
        writer.flush();
        writer.close();
    }

    private void writeHeader(String header, JsonWriter writer) throws IOException {
        writer.beginObject();
        writer.name(header);
        writer.beginArray();
    }

    public ArrayList<User> getAllUsers() throws IOException {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-mm-dd")
                .create();
        ArrayList<User> usersList = new ArrayList<>();
        File checkFile = new File("Data/Users.json");
        if (checkFile.exists() && checkFile.length() != 0) {
            JsonReader jsonReader = new JsonReader(new FileReader("Data/Users.json"));
            Users usersGson = gson.fromJson(jsonReader, Users.class);
            List<User> users = usersGson.getUsers();
            usersList.addAll(users);
        }
        return usersList;
    }

    public User getSingleUser(String userName) throws IOException {
        ArrayList<User> allUsers = getAllUsers();
        for (User user : allUsers) {
            if (Objects.equals(user.getUsername(), userName)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) throws IOException {
        ArrayList<User> currentUsers = getAllUsers();
        if (currentUsers.contains(user)) {
            System.out.println("User already exists.");
        } else {
            JsonWriter writer = new JsonWriter(new FileWriter("Data/Users.json"));
            writeHeader("users", writer);
            for (User userInArr : currentUsers) {
                writeUser(userInArr, writer);
            }
            writeUser(user, writer);
            closeWriter(writer);
        }
    }

    public void testSearch() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ingredient to search for:");
        String ingredient = scanner.nextLine();
        ArrayList<Ingredient> ingredients = parseAvailableIngredients();
        for (Ingredient ingredient1 : ingredients) {
            if (ingredient1.getName().toLowerCase().contains(ingredient.toLowerCase())) {
                System.out.println(ingredient1.getName());
            }
        }
    }

    private void writeUser(User user, JsonWriter writer) throws IOException {
        writer.beginObject();
        writer.name("username").value(user.getUsername());
        writer.name("name").value(user.getName());
        writer.name("height").value(user.getHeight());
        writer.name("weight").value(user.getWeight());
        writer.name("birthDate").value(user.getBirthDate());
        writer.endObject();
    }

    public void removeUser(User user) throws IOException {
        ArrayList<User> allUsers = getAllUsers();
        allUsers.remove(user);
        JsonWriter writer = new JsonWriter(new FileWriter("Data/Users.json"));
        writeHeader("users", writer);
        for (User userInArr : allUsers) {
            writeUser(userInArr, writer);
        }
        closeWriter(writer);
    }

    public void createIngredientsJSON() throws IOException {
        File input = new File("Data/ingredients.csv");
        File output = new File("Data/Ingredients.json");
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(output));
        mapper.writerWithDefaultPrettyPrinter().writeValue(g,
                csvMapper.readerFor(Map.class).with(csvSchema).readValues(new InputStreamReader(new FileInputStream(input), "windows-1252")).readAll());
        String fileContents = new String(Files.readAllBytes(Paths.get("Data/Ingredients.json")), StandardCharsets.UTF_8);
        StringBuilder addTopLevel = new StringBuilder(fileContents);
        addTopLevel.insert(0, "{\"ingredients\":");
        addTopLevel.append("}");
        FileWriter writer = new FileWriter(output, false);
        writer.write(addTopLevel.toString());
        writer.flush();
        writer.close();
    }

    public ArrayList<Recipe> getAllRecipes() throws FileNotFoundException {
        Gson gson = new Gson();
        ArrayList<Recipe> recipesList = new ArrayList<>();
        File checkFile = new File("Data/Recipes.json");
        if (checkFile.exists() && checkFile.length() != 0) {
            JsonReader jsonReader = new JsonReader(new FileReader("Data/Recipes.json"));
            Recipes recipesGson = gson.fromJson(jsonReader, Recipes.class);
            List<Recipe> recipes = recipesGson.getRecipes();
            recipesList.addAll(recipes);
        }
        return recipesList;
    }

    public Recipe getSingleRecipe(String recipeName) throws FileNotFoundException {
        ArrayList<Recipe> allRecipes = getAllRecipes();
        for (Recipe recipe : allRecipes) {
            if (Objects.equals(recipe.getName(), recipeName)) {
                return recipe;
            }
        }
        return null;
    }

    public void removeRecipe(Recipe recipe) throws IOException {
        ArrayList<Recipe> allRecipes = getAllRecipes();
        allRecipes.remove(recipe);
        JsonWriter writer = new JsonWriter(new FileWriter("Data/Recipes.json"));
        writeHeader("recipes", writer);
        for (Recipe recipeInArr : allRecipes) {
            writeRecipe(writer, recipeInArr);
        }
        closeWriter(writer);
    }

    public void addRecipe(Recipe recipe) throws IOException {
        ArrayList<Recipe> allRecipes = getAllRecipes();
        if (allRecipes.contains(recipe)) {
            System.out.println("Recipe already exists.");
        } else {
            JsonWriter writer = new JsonWriter(new FileWriter("Data/Recipes.json"));
            writeHeader("recipes", writer);
            for (Recipe recipeInArr : allRecipes) {
                writeRecipe(writer, recipeInArr);
            }
            writeRecipe(writer, recipe);
            closeWriter(writer);
        }
    }

    private void writeRecipe(JsonWriter writer, Recipe recipe) throws IOException {
        writer.beginObject();
        writer.name("name").value(recipe.getName());
        writer.name("ingredients");
        writer.beginArray();
        for (IngredientNeeded ingredient : recipe.getIngredients()) {
            writer.beginObject();
            writer.name("ingredient:").value(ingredient.getIngredient().toString());
            writer.endObject();
        }
        writer.endArray();
        writer.name("steps");
        writer.beginArray();
        for (String step : recipe.getStepsList()) {
            writer.beginObject();
            writer.name("step").value(step);
            writer.endObject();
        }
        writer.endArray();
        writer.name("calories").value(recipe.getCalories());
        writer.name("fat").value(recipe.getFat());
        writer.name("protein").value(recipe.getProtein());
        writer.name("fiber").value(recipe.getFiber());
        writer.name("carbs").value(recipe.getCarbs());
        writer.endObject();
    }

    public Meal[] getAllMeals() {

        return new Meal[0];
    }

    public Meal getSingleMeal(String mealName) {

    }

    public void removeMeal(String mealName) {

    }

    public Workout[] getAllWorkouts() {

    }

    public Workout getSingleWorkout(int workoutId) {

    }

    public void removeWorkout(int workoutId) {

    }

    public List<History> getHistory() {

    }

    public void addActivity() {

    }


}