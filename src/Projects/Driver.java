package src.Projects;

public class Driver implements Comparable<Driver>{
    private String driverName;
    private String team;
    private int carNumber;
    private String nationality;
    private int points;
    private int wins;
    private int podiums;
    //Contrustors
    /************************************************************************************
    Name: Driver
    Parameters: String driverid, String driverName, String team, int carNumber, String
    Purpose: To create a Driver object with the given parameters
    *************************************************************************************/
    public Driver(String driverName, String team, int carNumber, String nationality, int points, int wins, int podiums) {
        this.driverName = driverName;
        this.team = team;
        this.carNumber = carNumber;
        this.nationality = nationality;
        this.points = points;
        this.wins = wins;
        this.podiums = podiums;
    }
    /*******************************************************************************************
    Name: getDriverName
    Parameters: none
    Purpose: To get the driverName of the Driver object
    ********************************************************************************************/
    public String getDriverName() {
        return driverName;
    }
    /*********************************************************************************************
    Name: getTeam
    Parameters: none
    Purpose: To get the team of the Driver object
    *******************************************************************************************/
    public String getTeam() {
        return team;
    }
    /**********************************************************************************************
    Name: getCarNumber
    Parameters: none
    Purpose: To get the carNumber of the Driver object
    **********************************************************************************************/
    public int getCarNumber() {
        return carNumber;
    }
    /**********************************************************************************************
    Name: getNationality
    Parameters: none
    Purpose: To get the nationality of the Driver object
    **********************************************************************************************/
    public String getNationality() {
        return nationality; 
    }
    /***********************************************************************************************
    Name: getPoints
    Parameters: none
    Purpose: To get the points of the Driver object
    *************************************************************************************************/
    public int getPoints() {
        return points;
    }
    /***********************************************************************************************
    Name: getWins
    Parameters: none
    Purpose: To get the wins of the Driver object
    *************************************************************************************************/  
    public int getWins() {
        return wins;                
    }
    /***********************************************************************************************
    Name: getPodiums
    Parameters: none                    
    Purpose: To get the podiums of the Driver object
    *************************************************************************************************/
    public int getPodiums() {
        return podiums;
    }
    /***********************************************************************************************
    Name: addPoints
    Parameters: int addPoints
    Purpose: To add points to the Driver object and return the updated points
    *************************************************************************************************/  
    public void addPoints(int addPoints) {
        this.points += addPoints;
    }
    /***********************************************************************************************
    Name: addWin
    Parameters: none
    Purpose: To add a win to the Driver object
    *************************************************************************************************/
    public void addWin() {
        this.wins += 1;
    }
    /***********************************************************************************************
    Name: addPodium
    Parameters: none
    Purpose: To add a podium to the Driver object
    *************************************************************************************************/
    public void addPodium() {
        this.podiums += 1;
    }
    /***********************************************************************************************
    Name: toString
    Parameters: none
    Purpose: To return a string representation of the Driver object
    *************************************************************************************************/
    @Override
    public String toString() {
        return driverName + " (" + team + ") - Points: " + points + ", Wins: " + wins + ", Podiums: " + podiums;
    }  
    @Override
    public int compareTo(Driver other) {
        return Integer.compare(other.points, this.points); 
    }
}