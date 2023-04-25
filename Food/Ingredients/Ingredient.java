package Food.Ingredients;

import Food.Food;
import com.google.gson.annotations.SerializedName;

public class Ingredient extends Food {
    private double stock;
    @SerializedName("Shrt_Desc")
    private String name;

    // Constructor for ingredients
    public Ingredient(String name, double calories, double fat, double protein, double fiber, double carbs, double stock){
        super(calories, fat, protein, fiber, carbs);
        this.name = name;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Ingredient: " + this.name + " has " + this.stock + " in stock, each contains: "  + getCalories() + " calories " + getFat() + " fat " + getProtein() + " protein " + getFiber() + " fiber " + getCarbs() + " carbs ";
    }

    //Getters 
    
    public double getStock() {
        return this.stock;
    }
    
    public String getName() {
        return name;
    }

    //Setters
    public void setStock(double stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

}

