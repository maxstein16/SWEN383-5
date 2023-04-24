import com.google.gson.annotations.SerializedName;

public class Food {
    @SerializedName("Energ_Kcal")
    private double calories; // in calories
    @SerializedName("Lipid_Tot_(g)")
    private double fat; // in grams
    @SerializedName("Protein_(g)")
    private double protein; // in grams
    @SerializedName("Fiber_TD_(g)")
    private double fiber; // in grams
    @SerializedName("Carbohydrt_(g)")
    private double carbs; // in grams

    // Constructor for food, implemented in Ingredient, Recipe, and Meal
    // Name is implemented by class because of autocalculation/overloading reasons
    public Food(double calories, double fat, double protein, double fiber, double carbs) {
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
    }

    //Getters

    public double getCalories() {
        return calories;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }
    
    public double getFiber() {
        return fiber;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }



}
