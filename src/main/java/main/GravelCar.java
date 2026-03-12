package main;

public class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsePower, double suspensionTravel) {
        super(make, model, horsePower);
        this.suspensionTravel = suspensionTravel;
    }

    @Override
    public double calculatePerformance() {
        return this.getHorsePower() * 0.85 + this.suspensionTravel * 1.2;
    }

    public double getSuspensionTravel() {
        return this.suspensionTravel;
    }
    
}
