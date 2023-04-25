# NUTRiAPP SWEN383-5

The app will allow users to enter their personal information and goals, track their food intake and exercise, and receive suggestions to achieve their weight and fitness goals.

# User Information
The app will allow users to enter the following information:

• Name
• Height
• Weight
• Birth-date

This information will be used to calculate the user's age.

# Goals
The user may choose from one of several different goals:

• Maintain weight: sets a target number of calories so that the user maintains their current weight.
• Lose weight: sets a target number of calories based on the user's stats such that they lose an average of 1-2 pounds per week until reaching a target weight goal.
• Gain weight: sets a target number of calories based on the user's stats such that they gain an average of 1-2 pounds per week until reaching a target weight goal.

The user may choose to combine maintaining/losing/gaining weight with improving physical fitness. This will adjust the target calories per day based on the recommended amount of exercise and the user's weight goal.

In some circumstances, the app will automatically transition from one goal to another:

• When reaching a target weight goal, the app will transition from lose/gain weight to maintaining weight.
• If the user's weight changes by +/-5 or more pounds, the app will transition from the maintain weight goal to the lose/gain weight goals respectively.

# Food Tracking

The app will keep track of various forms of food. All food has the following properties:

• A name.
• A number of calories per unit (e.g., per gram or per fluid ounce).
• Grams of fat, protein, fiber, and carbohydrates per unit.

Ingredients are the most basic food type. In addition to the basic properties above, ingredients also have an amount in stock (e.g., grams or fluid ounces).

The app will maintain a searchable database of ingredients. The stock of any ingredient is 0 unless the user indicates that they have purchased some amount of the ingredient.

Recipes are also a type of food. The user may create a new recipe by specifying:

• A unique name for the new recipe.
• The ingredients (and amount of each) required to make the recipe.
• The preparation instructions for the recipe.

Meals are also a type of food. The user may create a meal by specifying:

• A unique name for the meal.
• The recipes included in the meal, e.g., salad, soup, entree, dessert, etc.

The app helps users to prepare meals when the user chooses recipes to combine.

• The user is guided through the steps to prepare each recipe.
• Ingredients are automatically deducted from the current stock.
• Calories are automatically deducted from the user's daily target.
• The user is warned if they try to prepare a meal, but the ingredients are not in stock or if they will exceed their daily target of calories by consuming the meal.

The app helps users to create shopping lists based on specific criteria:

• Ingredients that are low in stock/out of stock
• Ingredients required by a specific recipe such that are low/out of stock
• Additional criteria may be added in a future release

# Exercise Tracking

The app allows users to track workouts (which add calories to the daily target) including:

• A whole number of minutes
• Intensity
    • High: 10 calories/minute
    • Medium: 7.5 calories/minute (rounded down)
    • Low: 5 calories/minute
• The time/date of the exercise is recorded automatically at the time of entry.

If the user exceeds their daily target for calories, the app will suggest an amount of exercise based on their previously recorded workouts.