package Workout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LowIntensity implements Workout{
    @Override
    public String CalcCals(int duration) {
        int calsburned=5;
        int totalcalsburned=calsburned*duration;
        Calendar now = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmm");
        String result = df.format(now.getTime());
        return "Total calories burned: "+totalcalsburned +"on "+result;       
    }
}
