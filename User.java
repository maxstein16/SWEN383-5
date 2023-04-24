import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class User {
    String username;
    private String name;
    private int height; // in centimeters
    private double weight; // in kilograms
    private String birthDate;

    public User(String username, String name, int height, double weight, LocalDate birthDate) {
        this.username = username;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate.toString();
    }

    public String getUsername(){
        return username;
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

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(LocalDate.parse(birthDate), today).getYears();
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.birthDate = birthDate.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        User otherUser = (User) obj;

        return Objects.equals(username, otherUser.username);
    }
}
