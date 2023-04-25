package Workout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Workout {

    public enum Intensity {
        LOW, MEDIUM, HIGH
    };

    private Intensity intensity;
    private String date;
    private int calsBurned;
    private int duration;
    private String name;

    public Workout(Intensity intensity, String name, int duration) {
        this.intensity = intensity;
        Calendar now = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmm");
        this.date = df.format(now.getTime());
        if(intensity == Intensity.LOW){
            calsBurned = 5;
        } else if(intensity == Intensity.MEDIUM){
            calsBurned = 7;
        } else if(intensity == Intensity.HIGH){
            calsBurned = 10;
        } else {
            calsBurned = 0;
        }
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCalsBurned(int calsBurned) { this.calsBurned = calsBurned; }

    public int getCalsBurned() { return this.calsBurned; }

    public void setDuration(int duration) { this.duration = duration; }

    public int getDuration() { return this.duration; }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }
}
