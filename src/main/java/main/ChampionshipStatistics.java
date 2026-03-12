package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        int sum = 0;
        for (Driver driver: drivers){
            sum += driver.getPoints();
        }
        double averagePoints = sum/drivers.size();
        return averagePoints;
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>(); // A hashmap to put all countries and the sum of their points
        String mostSuccessfulCountry = "";
        int maxpoints = 0;

        //filling the hashmap
        for (Driver driver: drivers){
            countryPoints.put(
                driver.getCountry(), 
                countryPoints.getOrDefault(driver.getCountry(), 0) + driver.getPoints()
            );
        }

        //finding the most successful country
        for (String country: countryPoints.keySet()) {
            if (maxpoints < countryPoints.get(country)) {
                maxpoints = countryPoints.get(country);
                mostSuccessfulCountry = country;
            }
        }
        
        return mostSuccessfulCountry;
    }

    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRacesHeld();
    }
}
