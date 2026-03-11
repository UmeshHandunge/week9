package main;

import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String loctaion;
    private Map<Driver, Integer> result;

    @Override
    public void recordResult(Driver driver, int position, int points) {
        // TODO Auto-generated method stub
        driver.addPoints(points);
        throw new UnsupportedOperationException("Unimplemented method 'recordResult'");
    }

    @Override
    public int getDriverPoints(Driver driver) {
        // TODO Auto-generated method stub
        return driver.getpoints();
    }

    @Override
    public List<Driver> getResults() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResults'");
    }

    
    
}
