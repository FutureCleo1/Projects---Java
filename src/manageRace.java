package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class manageRace {

    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Team> teams = new HashMap<>();
    private List<raceResults> results = new ArrayList<>();
    private AVLTree<Driver> driverStandings = new AVLTree<>();
    private Graph trackGraph = new Graph();
    /******************************************************************************
    Name: importDrivers
    Parameters: String csvPath
    Purpose: Imports driver data from a CSV file located at csvPath
    ********************************************************************************/
    public void importDrivers(String csvPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;

                String[] t = line.split(",");
                if (t.length < 7) continue; // basic safety

                String name        = t[0].trim();
                String teamName    = t[1].trim();
                int carNumber      = Integer.parseInt(t[2].trim());
                String nationality = t[3].trim();
                int points         = Integer.parseInt(t[4].trim());
                int wins           = Integer.parseInt(t[5].trim());
                int podiums        = Integer.parseInt(t[6].trim());

                Driver d = new Driver(name, teamName, carNumber, nationality, points, wins, podiums);
                drivers.put(name, d);
                teamExists(teamName);
                teams.get(teamName).addDriver(d);
                teams.get(teamName).addPoints(points);
            }
        }
        rebuildStandings();
    }
    /******************************************************************************
    Name: eamExists
    Parameters: String teamName
    Purpose: Ensure a team exists in the map; if not, create a default one.
    ******************************************************************************/
    private void teamExists(String teamName) {
        teams.putIfAbsent(teamName,
                new Team(teamName, "Unknown Principal", "Unknown Location", 0, 0));
    }
    /******************************************************************************
    Name: addRaceResult
    Parameters: String raceName, String location, String date, String driverName, int position, int pointsEarned   
    Purpose: Add a race result and update driver and team standings.
    ******************************************************************************/
    public void addRaceResult(String raceName, String location, String date, String driverName, int position, int pointsEarned) {
        Driver d = drivers.get(driverName);
        if (d == null) {
            System.out.println("Driver not found: " + driverName);
            return;
        }
        String teamName = d.getTeam();
        teamExists(teamName);
        Team t = teams.get(teamName);

        raceResults rr = new raceResults(raceName, location, date, d, t, position, pointsEarned);
        rr.applyResults();
        results.add(rr);
        rebuildStandings();
    }

    /*******************************************************************************
    Name: rebuildStandings
    Parameters: none
    Purpose: Rebuild the AVL tree for driver standings.
    *******************************************************************************/
    private void rebuildStandings() {
        driverStandings = new AVLTree<>();
        for (Driver d : drivers.values()) {
            driverStandings.insert(d);
        }
    }

    /*******************************************************************************
    Name: getDriverStandings
    Parameters: none
    Purpose: Get driver standings as a list (in-order traversal of AVL).
    *******************************************************************************/
    public List<Driver> getDriverStandings() {
        return driverStandings.inOrder();
    }

    /*******************************************************************************
    Name: getTeamStandings
    Parameters: none
    Purpose: Get team standings sorted by total points (descending).
    *******************************************************************************/
    public List<Team> getTeamStandings() {
        List<Team> list = new ArrayList<>(teams.values());
        list.sort((a, b) -> Integer.compare(b.getTotalPoints(), a.getTotalPoints()));
        return list;
    }

    /*******************************************************************************
    Name: getAllResults
    Parameters: none
    Purpose: Get all race results.
    *******************************************************************************/
    public List<raceResults> getAllResults() {
        return new ArrayList<>(results);
    }

    /*******************************************************************************
    Name: printStandingsToConsole
    Parameters: none
    Purpose: Print driver and team standings to the console.
    *******************************************************************************/
    public void printStandingsToConsole() {
        System.out.println("=== DRIVER STANDINGS (AVL) ===");
        for (Driver d : getDriverStandings()) {
            System.out.println(d);
        }

        System.out.println("\n=== TEAM STANDINGS ===");
        for (Team t : getTeamStandings()) {
            System.out.println(t);
        }
    }

    /*******************************************************************************
    Name: loadDefaultTracks
    Parameters: none
    Purpose: Load a default set of F1 tracks and distances into the graph.
    *******************************************************************************/
    public void loadDefaultTracks() {
        trackGraph = new Graph();

        // Nodes (tracks)
        trackGraph.addNode("Bahrain");
        trackGraph.addNode("Jeddah");
        trackGraph.addNode("Melbourne");
        trackGraph.addNode("Suzuka");
        trackGraph.addNode("Imola");
        trackGraph.addNode("Miami");

        // Example distances (fake but consistent)
        trackGraph.addEdge("Bahrain", "Jeddah", 1400);
        trackGraph.addEdge("Jeddah", "Melbourne", 12000);
        trackGraph.addEdge("Melbourne", "Suzuka", 8000);
        trackGraph.addEdge("Suzuka", "Imola", 9600);
        trackGraph.addEdge("Imola", "Miami", 8300);
        // Direct long edges
        trackGraph.addEdge("Bahrain", "Melbourne", 12000);
        trackGraph.addEdge("Jeddah", "Imola", 3800);
    }

    /****************************************************************************************
    Name: getTrackList
    Parameters: none
    Purpose: Get the list of tracks in the graph
    ****************************************************************************************/
    public Set<String> getTrackList() {
        return trackGraph.getNodes();
    }

    /****************************************************************************************
    Name: getShortestPath
    Parameters: String from, String to
    Purpose: Get shortest path (sequence of track names) using Dijkstra.
    ****************************************************************************************/
    public List<String> getShortestPath(String from, String to) {
        if (!trackGraph.getNodes().contains(from) || !trackGraph.getNodes().contains(to)) {
            return Collections.emptyList();
        }
        return Dijkstra.shortestPath(trackGraph, from, to);
    }

    /****************************************************************************************
    Name: getShortestDistance
    Parameters: String from, String to
    Purpose: Get shortest distance between two tracks using Dijkstra.
    ****************************************************************************************/
    public int getShortestDistance(String from, String to) {
        if (!trackGraph.getNodes().contains(from) || !trackGraph.getNodes().contains(to)) {
            return Integer.MAX_VALUE;
        }
        Map<String, Integer> dist = Dijkstra.shortestDistances(trackGraph, from);
        return dist.getOrDefault(to, Integer.MAX_VALUE);
    }
}
