package Workout;

public class HighIntensity implements Workout {

    @Override
    public int CalcCals(int duration) {
        int calsburned=10;
        int totalcalsburned=calsburned*duration;
        return totalcalsburned; 
    }
    
}
