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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        File checkFile = new File("./Users.json");
        if (checkFile.exists()) {
            File fileCheck = new File("./Users.json");
            JsonReader jsonReader = new JsonReader(new FileReader("./Users.json"););
            if (fileCheck.length() != 0) {
                Users usersGson = gson.fromJson(jsonReader, Users.class);
                List<User> users = usersGson.getUsers();
                usersList.addAll(users);
            }
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
            JsonWriter writer = new JsonWriter(new FileWriter("./Users.json"));
            writeHeader("users", writer);
            for (User userInArr : currentUsers) {
                writeUser(userInArr, writer);
            }
            writeUser(user, writer);
            closeWriter(writer);
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
        JsonWriter writer = new JsonWriter(new FileWriter("./Users.json"));
        writeHeader("users", writer);
        for (User userInArr : allUsers) {
            writeUser(userInArr, writer);
        }
        closeWriter(writer);
    }

    public void createIngredientsJSON() throws IOException {
        File input = new File("./ingredients.csv");
        File output = new File("Ingredients.json");
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writerWithDefaultPrettyPrinter().writeValue(output,
                csvMapper.readerFor(Map.class).with(csvSchema).readValues(new InputStreamReader(new FileInputStream(input), "windows-1252")).readAll());
    }

    public ArrayList<Recipe> getAllRecipes() {

    }

    public Recipe getSingleRecipe(String recipeName) {

    }

    public void removeRecipe(Recipe recipe) throws IOException {
        ArrayList<Recipe> allRecipes = getAllRecipes();
        allRecipes.remove(recipe);
        JsonWriter writer = new JsonWriter(new FileWriter("./Users.json"));
        writeHeader("recipes", writer);
        for (Recipe recipeInArr : allRecipes) {
            writeRecipe();
        }
        closeWriter(writer);
    }

    public void addRecipe(Recipe recipe) {

    }

    private void writeRecipe(JsonWriter writer, Recipe recipe) {
        writer.beginObject();
        writer.name("name").value(recipe.getName());
        writer.name("ingredients").value(recipe.getIngredientsList);
        writer.name("stepsList").value(user.getHeight());
        writer.name("calories").value(user.getWeight());
        writer.name("far").value(user.getBirthDate());
        writer.name("protein").value(user.getWeight());
        writer.name("fiber").value(user.getBirthDate());
        writer.name("carbs").value(user.getWeight());
        writer.endObject();
    }

    public Meal[] getAllMeals() {

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

    } */


}