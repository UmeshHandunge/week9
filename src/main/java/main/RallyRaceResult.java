package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String loctaion;
    private Map<Driver, Integer> result;
    private Map<Integer, Driver> ranking;

    public RallyRaceResult(String raceName, String loctaion) {
        this.raceName = raceName;
        this.loctaion = loctaion;
        this.result = new HashMap<>();
        this.ranking = new HashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        driver.addPoints(points);
        this.result.put(driver, points);
        this.ranking.put(position, driver);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return this.result.get(driver);
    }

    @Override
    public List<Driver> getResults() {
        List<Driver> rankedDrivers = new ArrayList<>();

        //ordering the drivers according to their race rank
        for (int i = 1; i <= result.size(); i++) {
            rankedDrivers.add(ranking.get(i));
        }
        
        return rankedDrivers;
    }

    public String getName() {
        return this.raceName;
    }    

    public String getLocation() {
        return this.loctaion;
    }
    
}
