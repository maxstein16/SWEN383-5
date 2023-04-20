public enum Goal {
    MAINTAIN_WEIGHT("Maintain Weight"),
    LOSE_WEIGHT("Lose Weight"),
    GAIN_WEIGHT("Gain Weight");

    private final String name;

    Goal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
