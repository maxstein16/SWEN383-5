
import java.util.ArrayList;

public class Meal extends Food{
    private ArrayList<Recipe> recipeList;
    private String name;

    public Meal(String name, double calories, double fat, double protein, double fiber, double carbs, ArrayList<Recipe> recipeList) {
        super(calories, fat, protein, fiber, carbs);
        this.recipeList = recipeList;
        this.name = name;
        for(Recipe recipe : recipeList) {
            calories += recipe.getCalories();
            fat += recipe.getFat();
            protein += recipe.getProtein();
            fiber += recipe.getFiber();
            carbs += recipe.getCarbs();
        }
    }

    public Meal(String name, ArrayList<Recipe> recipeList) {
        super(0, 0, 0, 0, 0);
        this.recipeList = recipeList;
        this.name = name;
        for(Recipe recipe : recipeList) {
            this.setCalories(this.getCalories() + recipe.getCalories());
            this.setFat(this.getFat() + recipe.getFat());
            this.setProtein(this.getProtein() + recipe.getProtein());
            this.setFiber(this.getFiber() + recipe.getFiber());
            this.setCarbs(this.getCarbs() + recipe.getCarbs());
        }
    }

    @Override
    public String toString() {
        return "Meal: " + this.name + " has " + getRecipeList().size() + " recipes, totaling " + getCalories() + " calories " + getFat() + " fat " + getProtein() + " protein " + getFiber() + " fiber " + getCarbs() + " carbs ";
    }

    public boolean isMakeable() {
        for(Recipe recipe : recipeList) {
            if(!recipe.isMakeable()) {
                return false;
            }
        }
        return true;
    }
    
    //Recipe List
    public ArrayList<Recipe> getRecipeList() {
        return this.recipeList;
    }

    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);

        //Update the meal's nutrition facts
        this.setCalories(this.getCalories() + recipe.getCalories());
        this.setFat(this.getFat() + recipe.getFat());
        this.setProtein(this.getProtein() + recipe.getProtein());
        this.setFiber(this.getFiber() + recipe.getFiber());
        this.setCarbs(this.getCarbs() + recipe.getCarbs());
    }

    //name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
