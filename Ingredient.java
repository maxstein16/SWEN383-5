public class Ingredient extends Food {
    private int stock;
    
    public Ingredient(String name, double calories, double fat, double protein, double fiber, double carbs, int stock, String unit) {
        super(name, calories, fat, protein, fiber, carbs);
        this.stock = stock;
    }
    
    public double getStock() {
        return stock;
    }
    
    @Override
    public String toString() {
        return getName();
    }


}

