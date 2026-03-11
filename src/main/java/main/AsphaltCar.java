package main;

public class AsphaltCar extends RallyCar{
    private double downForce;

    public AsphaltCar(String make, String model, int horsePower, double downForce) {
        super(make, model, horsePower);
        this.downForce = downForce;
        //TODO Auto-generated constructor stub
    }

    @Override
    public double calculatePerformance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePerformance'");
    }
    public double getDownForce(){
        return this.downForce;
    }
    
}
