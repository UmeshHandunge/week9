package main;

public abstract class RallyCar {
    private String make;
    private String model;
    private int horsePower;

    public RallyCar(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public abstract double calculatePerformance();
}
