public class highintensity implements workoutinterface {

    @Override
    public int CalcCals(int duration) {
        int calsburned=10;
        int totalcalsburned=calsburned*duration;
        return totalcalsburned;       
    }
    
}
