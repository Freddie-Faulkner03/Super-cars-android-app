package uk.co.freddiefaulkner.supercars;

public class Card {
    String name;
    int image;
    int topSpeed;
    double engineSize;
    int coolFactor;
    int innovation;
    int yearLaunched;

    public Card(String name, int image, int topSpeed, double engineSize, int coolFactor, int innovation, int yearLaunched) {
        this.name = name;
        this.image = image;
        this.topSpeed = topSpeed;
        this.engineSize = engineSize;
        this.coolFactor = coolFactor;
        this.innovation = innovation;
        this.yearLaunched = yearLaunched;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public int getCoolFactor() {
        return coolFactor;
    }

    public int getInnovation() {
        return innovation;
    }

    public int getYearLaunched() {
        return yearLaunched;
    }
}
