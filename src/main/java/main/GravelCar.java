package main;

public class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsePower, double suspensionTravel) {
        super(make, model, horsePower);
        this.suspensionTravel = suspensionTravel;
        //TODO Auto-generated constructor stub
    }

    @Override
    public double calculatePerformance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePerformance'");
    }

    public double getSuspensionTravel() {
        return this.suspensionTravel;
    }
    
}
