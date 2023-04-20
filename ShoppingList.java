import java.util.ArrayList;

public class ShoppingList {

    private ArrayList<IngredientNeeded> shopList;
    

    ShoppingList(ArrayList<IngredientNeeded> inList) {
        //If you want to start the list with recipes
        for(IngredientNeeded ingredient : inList) {
            shopList.add(ingredient);
        }
    }

    ShoppingList() {
        //If you want to start the list empty
    }

    public void generateListRecipe(Recipe recipe){
            //adds all ingreidents to the shopping list
            for(IngredientNeeded ingredientNeeded : recipe.getIngredientsList()) {
                shopList.add(ingredientNeeded);
            }
    }

    public void removeIngredient(IngredientNeeded ingredient) {
        //removes an ingredient from the list
        shopList.remove(ingredient);
    }


    @Override
    public String toString() {
        return "ShoppingList: " + shopList.toString();
    }


}
