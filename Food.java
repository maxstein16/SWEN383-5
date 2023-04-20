public class Food {
    private String name;
    private double calories; // in calories
    private double fat; // in grams
    private double protein; // in grams
    private double fiber; // in grams
    private double carbs; // in grams

    public Food(String name, double calories, double fat, double protein, double fiber, double carbs) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbs;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public String toString() {
        return name;
    }



}
