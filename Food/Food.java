public class Food {
    private double calories; // in calories
    private double fat; // in grams
    private double protein; // in grams
    private double fiber; // in grams
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
