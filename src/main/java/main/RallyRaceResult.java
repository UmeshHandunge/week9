package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String loctaion;
    private Map<Driver, Integer> result;

    public RallyRaceResult(String raceName, String loctaion) {
        this.raceName = raceName;
        this.loctaion = loctaion;
        this.result = new HashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        // TODO Auto-generated method stub
        driver.addPoints(points);
        result.put(driver, position);
        throw new UnsupportedOperationException("Unimplemented method 'recordResult'");
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return driver.getPoints();
    }

    @Override
    public List<Driver> getResults() {
        //TODO get results
        throw new UnsupportedOperationException("Unimplemented method 'getResults'");
    }

    public String getName() {
        return this.raceName;
    }    

    public String getLocation() {
        return this.loctaion;
    }
    
}
