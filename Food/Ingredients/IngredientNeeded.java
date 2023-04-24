package Food.Ingredients;

public class IngredientNeeded {
    
    private Ingredient ingredient;
    private double amount;

    public IngredientNeeded(Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ingredient.getName() + " " + amount;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else{
            if (!(other instanceof IngredientNeeded)) {
                return false;
            } else{
                IngredientNeeded otherIngredientNeeded = (IngredientNeeded) other;
                return this.amount == otherIngredientNeeded.amount && this.ingredient.equals(otherIngredientNeeded.ingredient);
            }
        }
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
