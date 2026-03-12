package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers;
    private static int totalRaces;

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    private ChampionshipManager() {
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
        totalDrivers = 0;
        totalRaces = 0;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers ++;
    }

    public void  addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces ++;
    }

    public List<Driver> getDriverSatndings() {
        //TODO driver standings
        return drivers;
    }

    public static Driver  getLeadingDriver() {
        int leadingPoints = 0;
        Driver leadingDriver = null;
        
        for (Driver driver: getInstance().drivers) { 
            if (leadingPoints < driver.getPoints()) {
                leadingPoints = driver.getPoints();
                leadingDriver = driver;
            }
        }
        return leadingDriver; 
    }

    public static int getTotalChampionshipPoints() {
        int totalPoints = 0;

        // trick used to access non static attributes of the same sigleton class
        for (Driver driver: getInstance().drivers) { 
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }
    
    // not in UML but it is needed to get the number into ChampionshipStatistics
    public static int getTotalRacesHeld() {
        return totalRaces;
    }

    // not in UML but it is needed to display as shown in the example output
    public static int getTotalDrivers() {
        return totalDrivers;
    }
}
