package main;

import java.util.List;

public class ChampionshipStatistics {
    private static ChampionshipStatistics instance;

    public static ChampionshipStatistics getInstance(){
        if (instance == null) {
            instance = new ChampionshipStatistics();
        }
        return instance;
    }

    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        int sum = 0;
        for (Driver driver: drivers){
            sum += driver.getpoints();
        }
        double averagePoints = sum/drivers.size();
        return averagePoints;
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        for (Driver driver: drivers){
            // TODO egt successful country
        }
        return "placeholder";
    }
}
