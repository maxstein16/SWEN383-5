public class lowIntensity implements workoutinterface{

    @Override
    public int CalcCals(int duration) {
        int calsburned=5;
        int totalcalsburned=calsburned*duration;
        
        
        return totalcalsburned;       
    }
    
}
