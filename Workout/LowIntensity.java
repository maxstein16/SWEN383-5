package Workout;

public class LowIntensity implements Workout{

    @Override
    public int CalcCals(int duration) {
        int calsburned=5;
        int totalcalsburned=calsburned*duration;
        
        
        return totalcalsburned;
    }
    
}
