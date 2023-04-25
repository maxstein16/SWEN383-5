package Food.Recipes;

import Food.Food;
import Food.Ingredients.Ingredient;
import Food.Ingredients.IngredientNeeded;
import Users.User;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe extends Food {
    @SerializedName("ingredientsList")
    ArrayList<IngredientNeeded> ingredientsList;
    private ArrayList<String> stepsList;
    private String step;
    private String name;

    // Constructor for recipes with manually set nutriton, implemented in Meal
    public Recipe(String name, double calories, double fat, double protein, double fiber, double carbs, ArrayList<IngredientNeeded> ingredientsList, ArrayList<String> stepsList) {
        super( calories, fat, protein, fiber, carbs);
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.stepsList = stepsList;
        for(IngredientNeeded ingredientNeeded: ingredientsList) {
            calories += (ingredientNeeded.getIngredient().getCalories() * ingredientNeeded.getAmount());
            fat += (ingredientNeeded.getIngredient().getFat() * ingredientNeeded.getAmount());
            protein += (ingredientNeeded.getIngredient().getProtein() * ingredientNeeded.getAmount());
            fiber += (ingredientNeeded.getIngredient().getFiber() * ingredientNeeded.getAmount());
            carbs += (ingredientNeeded.getIngredient().getCarbs() * ingredientNeeded.getAmount());
        }
    }

    // Constructor for recipes with calculated nutriton, this is recommended, implemented in Meal
    public Recipe(String name, ArrayList<IngredientNeeded> ingredientsList, ArrayList<String> stepsList) {
        super(0, 0, 0, 0, 0);
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.stepsList = stepsList;
        for(IngredientNeeded ingredientNeeded : this.ingredientsList) {
            this.setCalories(this.getCalories() + (ingredientNeeded.getIngredient().getCalories() * ingredientNeeded.getAmount()));
            this.setFat(this.getFat() + (ingredientNeeded.getIngredient().getFat() * ingredientNeeded.getAmount()));
            this.setProtein(this.getProtein() + (ingredientNeeded.getIngredient().getProtein() * ingredientNeeded.getAmount()));
            this.setFiber(this.getFiber() + (ingredientNeeded.getIngredient().getFiber() * ingredientNeeded.getAmount()));
            this.setCarbs(this.getCarbs() + (ingredientNeeded.getIngredient().getCarbs() * ingredientNeeded.getAmount()));
        }
    }

    //Check if the recipe is makeable with stock
    public boolean isMakeable() {
        for(IngredientNeeded ingredientNeeded : this.ingredientsList) {
            if(ingredientNeeded.getAmount() > ingredientNeeded.getIngredient().getStock()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recipe: " + this.name + " has " + getIngredients().size() + " ingredients and " + getStepsList().size() + " steps, totaling " + getCalories() + " calories " + getFat() + " fat " + getProtein() + " protein " + getFiber() + " fiber " + getCarbs() + " carbs ";
    }

    //Food.Ingredients.Ingredients List
    public ArrayList<IngredientNeeded> getIngredients() {
        return this.ingredientsList;
    }


    public void setIngredientsAmount(Ingredient newIngredient, double newAmount) {
        //set the ingredient to the new amount
        for(IngredientNeeded ingredientNeeded : this.ingredientsList) {
            if(ingredientNeeded.getIngredient().equals(newIngredient)) {
                ingredientNeeded.setAmount(newAmount);
            }        
        }

        //recalculate nutrition
        for(IngredientNeeded ingredientNeeded : ingredientsList) {
            this.setCalories(this.getCalories() + (ingredientNeeded.getIngredient().getCalories() * ingredientNeeded.getAmount()));
            this.setFat(this.getFat() + (ingredientNeeded.getIngredient().getFat() * ingredientNeeded.getAmount()));
            this.setProtein(this.getProtein() + (ingredientNeeded.getIngredient().getProtein() * ingredientNeeded.getAmount()));
            this.setFiber(this.getFiber() + (ingredientNeeded.getIngredient().getFiber() * ingredientNeeded.getAmount()));
            this.setCarbs(this.getCarbs() + (ingredientNeeded.getIngredient().getCarbs() * ingredientNeeded.getAmount()));
        }

    }

    public void setIngredients(ArrayList<IngredientNeeded> ingredientsList) {
        //Set ingredients to new list
        this.ingredientsList = ingredientsList;
        for(IngredientNeeded ingredientNeeded : ingredientsList) {
            this.setCalories(this.getCalories() + (ingredientNeeded.getIngredient().getCalories() * ingredientNeeded.getAmount()));
            this.setFat(this.getFat() + (ingredientNeeded.getIngredient().getFat() * ingredientNeeded.getAmount()));
            this.setProtein(this.getProtein() + (ingredientNeeded.getIngredient().getProtein() * ingredientNeeded.getAmount()));
            this.setFiber(this.getFiber() + (ingredientNeeded.getIngredient().getFiber() * ingredientNeeded.getAmount()));
            this.setCarbs(this.getCarbs() + (ingredientNeeded.getIngredient().getCarbs() * ingredientNeeded.getAmount()));
        }
    }

    public void addingredient(IngredientNeeded ingredient) {
        //Add ingredient to list
        ingredientsList.add(ingredient);
        
        //Update the recipe's nutrition facts
        for(IngredientNeeded ingredientNeeded : ingredientsList) {
            this.setCalories(this.getCalories() + (ingredientNeeded.getIngredient().getCalories() * ingredientNeeded.getAmount()));
            this.setFat(this.getFat() + (ingredientNeeded.getIngredient().getFat() * ingredientNeeded.getAmount()));
            this.setProtein(this.getProtein() + (ingredientNeeded.getIngredient().getProtein() * ingredientNeeded.getAmount()));
            this.setFiber(this.getFiber() + (ingredientNeeded.getIngredient().getFiber() * ingredientNeeded.getAmount()));
            this.setCarbs(this.getCarbs() + (ingredientNeeded.getIngredient().getCarbs() * ingredientNeeded.getAmount()));
        }
    }

    public void removeIngredient(IngredientNeeded ingredient) {
        //Remove ingredient from list
        ingredientsList.remove(ingredient);

        //Update the recipe's nutrition facts
        for(IngredientNeeded ingredientNeeded : ingredientsList) {
            this.setCalories(this.getCalories() + (ingredientNeeded.getIngredient().getCalories() * ingredientNeeded.getAmount()));
            this.setFat(this.getFat() + (ingredientNeeded.getIngredient().getFat() * ingredientNeeded.getAmount()));
            this.setProtein(this.getProtein() + (ingredientNeeded.getIngredient().getProtein() * ingredientNeeded.getAmount()));
            this.setFiber(this.getFiber() + (ingredientNeeded.getIngredient().getFiber() * ingredientNeeded.getAmount()));
            this.setCarbs(this.getCarbs() + (ingredientNeeded.getIngredient().getCarbs() * ingredientNeeded.getAmount()));
        }
    }

    public ArrayList<IngredientNeeded> getIngredientsList() {
        return ingredientsList;
    }

    //Recipe Steps
    public ArrayList<String> getStepsList() {
        return this.stepsList;
    }

    public void setStepsList(ArrayList<String> stepsList) {
        this.stepsList = stepsList;
    }

    public void addStep(String step) {
        this.stepsList.add(step);
    }

    //name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Recipe)) {
            return false;
        }

        Recipe otherRecipe = (Recipe) obj;

        return Objects.equals(name, otherRecipe.getName());
    }
}
