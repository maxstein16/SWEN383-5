public class IngredientNeeded {
    
    private Ingredient ingredient;
    private double amount;

    public IngredientNeeded(Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    //Getters
    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getAmount() {
        return amount;
    }

    //Setters
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
