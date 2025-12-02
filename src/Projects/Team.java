package src.Projects;
import java.util.List;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private String principal;
    private String location;
    private int championships;
    private int totalPoints;

    private List<Driver> drivers;
    /***********************************************************************
    Name: Team
    Parameters:String teamName, String principal, String location, int championships, int totalPoints
    Purpose: To create a Team object with the given parameters
    ***********************************************************************/
    public Team( String teamName, String principal, String location, int championships, int totalPoints) {
        this.teamName = teamName;
        this.principal = principal;
        this.location = location;
        this.championships = championships;
        this.totalPoints = 0;
        this.drivers = new ArrayList<>();
    }
    /************************************************************************
    Name: getTeamName
    Parameters: none
    Purpose: To get the teamName of the Team object
    ************************************************************************/
    public String getTeamName() {
        return teamName;      
    }
    /************************************************************************
    Name: getPrincipal
    Parameters: none
    Purpose: To get the principal of the Team object
    ************************************************************************/
    public String getPrincipal() {
        return principal;   
    }
    /************************************************************************
    Name: getLocation
    Parameters: none
    Purpose: To get the location of the Team object
    ************************************************************************/
    public String getLocation() {
        return location;    
    }
    /************************************************************************
    Name: getChampionships
    Parameters: none 
    Purpose: To get the championships of the Team object
    ************************************************************************/
    public int getChampionships() {
        return championships;   
    }
    /************************************************************************
    Name: getTotalPoints
    Parameters: none
    Purpose: To get the totalPoints of the Team object
    ************************************************************************/
    public int getTotalPoints() {
        return totalPoints;    
    }
    /************************************************************************
    Name: addDriver
    Parameters: Driver driver
    Purpose: To add a Driver to the Team's driver list
    ************************************************************************/
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }  
    /************************************************************************
    Name: addPoints
    Parameters: int points
    Purpose: To add points to the Team's totalPoints
    ************************************************************************/ 
    public void addPoints(int points) {
        this.totalPoints += points;
    }  
    /************************************************************************
    Name: toString
    Parameters: none
    Purpose: To return a string representation of the Team object
    ************************************************************************/
    @Override
    public String toString() {
        return teamName + " | Principal: " + principal + " | Location: " + location + " | Championships: " + championships + " | Points: " + totalPoints + " | Drivers: " + drivers.size();
    }

}
