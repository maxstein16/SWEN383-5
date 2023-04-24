package Food;

import Food.Ingredients.IngredientNeeded;
import Food.Recipes.Recipe;

import java.util.ArrayList;

public class ShoppingList {

    private ArrayList<IngredientNeeded> shopList = new ArrayList<IngredientNeeded>();
    

    ShoppingList(ArrayList<IngredientNeeded> inList) {
        //If you want to start the list with recipes
        for(IngredientNeeded ingredient : inList) {
            this.shopList.add(ingredient);
        }
    }

    ShoppingList() {
        //If you want to start the list empty
    }

    public void generateListRecipe(Recipe recipe){
            //adds all ingreidents to the shopping list
            for(IngredientNeeded ingredientNeeded : recipe.getIngredientsList()) {
                if(!this.shopList.contains(ingredientNeeded)){
                    //Needs to be double checked by for loop because of the way IngredientNeeded is built
                    boolean found = false;
                    for(IngredientNeeded ingredient : this.shopList){
                        if(ingredientNeeded.getIngredient().equals(ingredient.getIngredient())){
                            ingredient.setAmount(ingredient.getAmount() + ingredientNeeded.getAmount());
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                    this.shopList.add(ingredientNeeded);
                    }
                } else{
                    for(IngredientNeeded ingredient : this.shopList){
                        if(ingredientNeeded.getIngredient().equals(ingredient.getIngredient())){
                            ingredient.setAmount(ingredient.getAmount() + ingredientNeeded.getAmount());
                        }
                    }
                }
            }
    }

    public void addingredient(IngredientNeeded ingredientNeeded) {
        //adds an ingredient to the list
        if(!this.shopList.contains(ingredientNeeded)){
            //Needs to be double checked by for loop because of the way IngredientNeeded is built
            boolean found = false;
            for(IngredientNeeded ingredient : this.shopList){
                if(ingredientNeeded.getIngredient().equals(ingredient.getIngredient())){
                    ingredient.setAmount(ingredient.getAmount() + ingredientNeeded.getAmount());
                    found = true;
                    break;
                }
            }
            if(!found){
            this.shopList.add(ingredientNeeded);
            }
        } 
        else{
            for(IngredientNeeded ingredient : this.shopList){
                if(ingredientNeeded.getIngredient().equals(ingredient.getIngredient())){
                    ingredient.setAmount(ingredient.getAmount() + ingredientNeeded.getAmount());
                }
            }
        }
    }

    public void removeIngredient(IngredientNeeded ingredientNeeded) {
        //removes an ingredient from the list
        if(!this.shopList.contains(ingredientNeeded)){
            //Needs to be double checked by for loop because of the way IngredientNeeded is built
            boolean found = false;
            for(IngredientNeeded ingredient : this.shopList){
                if(ingredientNeeded.getIngredient().equals(ingredient.getIngredient())){
                    if(ingredient.getAmount() < ingredientNeeded.getAmount()){
                        shopList.remove(ingredient);
                    } else{
                    ingredient.setAmount(ingredient.getAmount() - ingredientNeeded.getAmount());
                    }
                    found = true;
                    break;
                }
            }
            if(!found){
            System.out.println("Ingredient not found");
            }
        } else{
            for(IngredientNeeded ingredient : this.shopList){
                if(ingredientNeeded.getIngredient().equals(ingredient.getIngredient())){
                    if(ingredient.getAmount() < ingredientNeeded.getAmount()){
                        shopList.remove(ingredient);
                    } else{
                    ingredient.setAmount(ingredient.getAmount() - ingredientNeeded.getAmount());
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Food.ShoppingList: " + shopList.toString();
    }


}
