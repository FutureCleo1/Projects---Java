package src.Projects;

import java.io.*;
import java.util.*;

public class manageRace {
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Team> teams = new HashMap<>();
    private List<raceResults> results = new ArrayList<>();

    /******************************************************************************************************
    Name: importDrivers
    Parameter: path
    Purpose: parse through csv file 
    *******************************************************************************************************/
    public void importDrivers(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty() || line.startsWith("#")) continue;

                String[] t = line.split(",");

                String name = t[0].trim();
                String teamName = t[1].trim();
                int carNumber = Integer.parseInt(t[2].trim());
                String nationality = t[3].trim();
                int points = Integer.parseInt(t[4].trim());
                int wins = Integer.parseInt(t[5].trim());
                int podiums = Integer.parseInt(t[6].trim());

                Driver driver = new Driver(name, teamName, carNumber, nationality, points, wins, podiums);
                drivers.put(name, driver);

                // ensure the team exists
                teams.putIfAbsent(teamName, new Team(teamName, "Unknown", "Unknown", 0, 0));
                teams.get(teamName).addDriver(driver);
            }
        }
    }

    /******************************************************************************************************
    Name: getDriver
    Parameter: name
    Purpose: finds the drivers and list them by name
    *******************************************************************************************************/
    public Driver getDriver(String name) {
        return drivers.get(name);
    }

    /******************************************************************************************************
    Name:getTeam
    Parameter: name
    Purpose: finds the team and list them by name
    *******************************************************************************************************/
    public Team getTeam(String name) {
        return teams.get(name);
    }
    /******************************************************************************************************
    Name: getAllDrivers
    Parameter: num
    Purpose: returns a sorted list of drivers up to the specified number
    *******************************************************************************************************/
    public List<Driver> getAllDrivers(int num) {
        List<Driver> list = new ArrayList<>(drivers.values());
        list.sort(null);
        return list.subList(0, Math.min(num, list.size()));
    } 

    /******************************************************************************************************
    Name: addRaceResults
    Parameter: raceResults
    Purpose: records a result and adds the points from the race
    *******************************************************************************************************/
    public void addRaceResults(raceResults rr) {
        results.add(rr);
        rr.addPointsEarned(); // applies points to driver/team
    }
    /******************************************************************************************************
    Name: getListTeams
    Parameter: none
    Purpose: returns a list of all teams
    *******************************************************************************************************/
    public List<Team> getListTeams() {
        return new ArrayList<>(teams.values());
    }
    /******************************************************************************************************
    Name: pollStanding
    Parameter: none
    Purpose: prints the current standings for drivers and teams
    *******************************************************************************************************/
    public void pollStanding() {
        System.out.println("Driver Standings:");
        for (Driver d : getAllDrivers(drivers.size())) {
            System.out.println(d);
        }

        System.out.println("\nTeam Standings:");
        for (Team t : teams.values()) {
            System.out.println(t);
        }
    }
}