package Food.Meals;


import java.util.ArrayList;
import java.util.List;

public class Meals {
    private List<Meal> meals = new ArrayList<>();

    public List<Meal> getMeals() {
        return meals;
    }

    public void setUsers(List<Meal> meals) {
        this.meals = meals;
    }
}
