package main;

public class AsphaltCar extends RallyCar{
    private double downForce;

    public AsphaltCar(String make, String model, int horsePower, double downForce) {
        super(make, model, horsePower);
        this.downForce = downForce;
    }

    @Override
    public double calculatePerformance() {
        return this.getHorsePower() * 1.1 + this.downForce * 0.9;
    }
    public double getDownForce(){
        return this.downForce;
    }
    
}
