import java.time.LocalDate;
import java.time.Period;

public class User {
    private String name;
    private int height; // in centimeters
    private double weight; // in kilograms
    private LocalDate birthDate;

    public User(String name, int height, double weight, LocalDate birthDate) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
