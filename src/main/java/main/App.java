package main;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    
        //Have extra cars to show that cars can be swithced between races
        GravelCar toyotaYaris = new GravelCar("Toyota", "GR Yaris Rally1", 380, 270.0);
        GravelCar fordPuma = new GravelCar("Ford", "Puma Rally1", 380, 265.0);
        GravelCar audiQuattro = new GravelCar("Audi", "Sport Quattro S1", 470, 230.0);
        GravelCar mitsubishiEvo = new GravelCar("Mitsubishi", "Lancer Evolution VI", 280, 245.0);

        AsphaltCar porsche911 = new AsphaltCar("Porsche", "911 GT3 RGT", 410, 150.0);
        AsphaltCar citroenC3 = new AsphaltCar("Citroën", "C3 WRC", 380, 185.0);
        AsphaltCar hyundaiI20 = new AsphaltCar("Hyundai", "i20 N Rally2", 290, 115.0);
        AsphaltCar subaruImpreza = new AsphaltCar("Subaru", "Impreza WRC99", 300, 140.0);

        //5 drivers
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", toyotaYaris);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", hyundaiI20);
        Driver ogier = new Driver("Sébastien Ogier", "France", citroenC3);
        Driver makinen = new Driver("Tommi Mäkinen", "Finland", mitsubishiEvo);
        Driver burns = new Driver("Richard Burns", "United Kingdom", subaruImpreza);
        
        //the races
        RallyRaceResult finlandResult = new RallyRaceResult("Secto Rally Finland", "Jyväskylä");
        RallyRaceResult monteCarloResult = new RallyRaceResult("Rallye Automobile Monte-Carlo", "Monaco");
        RallyRaceResult acropolisResult = new RallyRaceResult("EKO Acropolis Rally Greece", "Lamia");
        
        //creating 1 ChampionshipManager
        ChampionshipManager manager = ChampionshipManager.getInstance();

        //Register drivers
        manager.registerDriver(rovanpera);
        manager.registerDriver(neuville);
        manager.registerDriver(ogier);
        manager.registerDriver(makinen);
        manager.registerDriver(burns);

        //Register race results
        manager.addRaceResult(finlandResult);
        manager.addRaceResult(monteCarloResult);
        manager.addRaceResult(acropolisResult);

        // add all the race results and car changes
        finlandResult.recordResult(rovanpera, 1, 27); 
        finlandResult.recordResult(makinen, 2, 19);
        finlandResult.recordResult(neuville, 3, 15);
        finlandResult.recordResult(ogier, 4, 14);
        finlandResult.recordResult(burns, 5, 8);

        neuville.setCar(fordPuma); //change car

        monteCarloResult.recordResult(ogier, 1, 28);
        monteCarloResult.recordResult(neuville, 2, 18);
        monteCarloResult.recordResult(burns, 3, 17);
        monteCarloResult.recordResult(rovanpera, 4, 13);
        monteCarloResult.recordResult(makinen, 5, 11);

        ogier.setCar(porsche911);   //change car
        burns.setCar(audiQuattro);

        acropolisResult.recordResult(burns, 1, 25);
        acropolisResult.recordResult(makinen, 2, 18);
        acropolisResult.recordResult(rovanpera, 3, 15);
        acropolisResult.recordResult(neuville, 4, 12);
        acropolisResult.recordResult(ogier, 5, 10);

        int rank = 1;
        for (Driver driver: manager.getDriverSatndings()) {
                System.out.println(rank + ". " + driver.getName() + " (" + driver.getName() + ") : " + driver.getPoints() + " points");
                rank ++;
        }

        System.out.println();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leadDriver = ChampionshipManager.getLeadingDriver();
        System.out.println(leadDriver.getName() + " with " + leadDriver.getPoints() + " points");

        System.out.println();

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverSatndings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverSatndings()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());
    
        System.out.println();

        System.out.println("============== RACE RESULTS ==============");
        for (RallyRaceResult race: ChampionshipManager.getRaces()) {
            System.out.println("Race: " + race.getName() + " (" + race.getLocation() + ")");
            List<Driver> drivers = race.getResults();

            int i = 1;
            for(Driver driver: drivers) {
                System.out.println("\tPosition " + i + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
                i++;
            }
            
            System.out.println();
        }

        System.out.println();

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + toyotaYaris.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + porsche911.calculatePerformance());

        System.out.println();

        //Confirming that cars were changed later
        System.out.println("===== CAR CHANGES =====");
        System.out.println(neuville.getName() + ": " + neuville.getRallyCar().getMake());
        System.out.println(ogier.getName() + ": " + ogier.getRallyCar().getMake());
        System.out.println(burns.getName() + ": " + burns.getRallyCar().getMake());
        //The above drivers were originally assigned different cars
    }
}
