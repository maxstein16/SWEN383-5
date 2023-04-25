package Workout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Workout {

    public enum Intensity {
        LOW, MEDIUM, HIGH
    };
    private String workoutname;
    private Intensity intensity;
    private String dateString;
    private int caloriesBurned;

    public Workout(Intensity intensity) {
        this.intensity = intensity;
        Calendar now = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmm");
        this.dateString = df.format(now.getTime());
        if(intensity == Intensity.LOW){
            caloriesBurned = 5;
        } else if(intensity == Intensity.MEDIUM){
            caloriesBurned = 7;
        } else if(intensity == Intensity.HIGH){
            caloriesBurned = 10;
        } else {
            caloriesBurned = 0;
        }
    }

    public String workoutName(){
        return workoutname;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public String getDate(){
        return dateString;
    }

    public void setDate(String dateString) {
        this.dateString = dateString;
    }


}