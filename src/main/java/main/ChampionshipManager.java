package main;

import java.util.ArrayList;
import java.util.Comparator;
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
        this.drivers.add(driver);
        totalDrivers ++;
    }

    public void  addRaceResult(RallyRaceResult result) {
        this.races.add(result);
        totalRaces ++;
    }

    public List<Driver> getDriverSatndings() {
        this.sortDrivers();
        return this.drivers;
    }

    public static Driver  getLeadingDriver() {
        /**int leadingPoints = 0;
        Driver leadingDriver = null;

        for (Driver driver: getInstance().drivers) { 
            if (leadingPoints < driver.getPoints()) {
                leadingPoints = driver.getPoints();
                leadingDriver = driver;
            }
        }**/

        getInstance().sortDrivers();
        List<Driver> drivers = getInstance().drivers;
        return drivers.getFirst(); 
    }

    public static int getTotalChampionshipPoints() {
        int totalPoints = 0;

        // trick used to access non static attributes of the same sigleton class
        for (Driver driver: getInstance().drivers) { 
            totalPoints += driver.getPoints();
        }
        return totalPoints;
    }
    
    // not in uml 
    // sort drivers based on points
    private void sortDrivers() {
        this.drivers.sort(Comparator.comparing(Driver::getPoints).reversed()); //reversed to get it in descending order
    }

    // not in UML but it is needed to get the number into ChampionshipStatistics
    public static int getTotalRacesHeld() {
        return totalRaces;
    }

    // not in UML but it is needed to display as shown in the example output
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    //not in UML but needed for displaying races
    public static List<RallyRaceResult> getRaces() {
        return getInstance().races;
    }
    
}
