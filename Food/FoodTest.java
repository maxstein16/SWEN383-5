package Food;

import Food.Ingredients.Ingredient;
import Food.Ingredients.IngredientNeeded;
import Food.Meals.Meal;
import Food.Recipes.Recipe;

import java.util.ArrayList;

public class FoodTest {
    
    public static void main(String[] args) {
        //Ingredient Test Code
        Ingredient potato = new Ingredient("Potato", 10, 1, 2, 3, 4, 3);
        Ingredient butter = new Ingredient("Butter", 100, 10, 20, 30, 40, 5);
        System.out.println(potato.toString());
        System.out.println(butter.toString());

        IngredientNeeded potatosNeeded = new IngredientNeeded(potato, 2);
        IngredientNeeded butterNeeded = new IngredientNeeded(butter, 1);

        ArrayList<IngredientNeeded> ingredientsList = new ArrayList<IngredientNeeded>();
        
        System.out.println(ingredientsList.add(potatosNeeded));
        System.out.println(ingredientsList.add(butterNeeded));

        System.out.println(ingredientsList.get(0).getIngredient().toString());

        //Recipe Test Code
        ArrayList<String> instructions = new ArrayList<String>();
        instructions.add("boil potatos");
        instructions.add("mash potatos");

        Recipe mashedPotatoes = new Recipe("Mashed Potatoes", ingredientsList, instructions);
        System.out.println(mashedPotatoes.toString());

        System.out.println(mashedPotatoes.isMakeable());

        mashedPotatoes.setIngredientsAmount(potato, 5);

        System.out.println(mashedPotatoes.isMakeable());

        mashedPotatoes.setIngredientsAmount(potato, 3);

        //Meal Test Code
        Ingredient steak = new Ingredient("Steak", 12, 3, 4, 5, 6, 3);
        IngredientNeeded steakNeeded = new IngredientNeeded(steak, 1);
        IngredientNeeded butterNeeded2 = new IngredientNeeded(butter, 1);
        ArrayList<IngredientNeeded> steakList = new ArrayList<IngredientNeeded>();
        steakList.add(steakNeeded);
        steakList.add(butterNeeded2);

        ArrayList<String> steakInstructions = new ArrayList<String>();
        instructions.add("butter steak");
        instructions.add("cook steak");

        Recipe steakRecipe = new Recipe("Steak", steakList, steakInstructions);

        ArrayList<Recipe> steakDinnerRecipes = new ArrayList<Recipe>();
        steakDinnerRecipes.add(mashedPotatoes);
        steakDinnerRecipes.add(steakRecipe);

        Meal steakDinner = new Meal("Steak Dinner", steakDinnerRecipes);
        System.out.println(steakDinner.toString());
        steakDinner.isMakeable();

        //Shopping List Test Code
        ArrayList<IngredientNeeded> ingredientsINeed = new ArrayList<IngredientNeeded>();
        ingredientsINeed.add(potatosNeeded);
        ingredientsINeed.add(butterNeeded);
        System.out.println(ingredientsINeed);

        ShoppingList shoppingList = new ShoppingList(ingredientsINeed);
        System.out.println(shoppingList.toString());

        shoppingList.addingredient(butterNeeded2);
        shoppingList.generateListRecipe(steakRecipe);
        System.out.println(shoppingList.toString());

        shoppingList.removeIngredient(butterNeeded2);
        System.out.println(shoppingList.toString());

    }
}
