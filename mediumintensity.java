public class mediumintensity implements workoutinterface {

    @Override
    public int CalcCals(int duration) {
        int calsburned=7;
        int totalcalsburned=calsburned*duration;
        
        
        return totalcalsburned;       
    }
    
}
