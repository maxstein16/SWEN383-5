package Workout;

import Users.User;

import java.util.ArrayList;
import java.util.List;

public class Workouts {
    private List<Workout> workouts = new ArrayList<>();

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
