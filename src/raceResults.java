public class raceResults {
    private String raceName;
    private String location;
    private String date;
    private Driver driver;
    private Team team;
    private int position;
    private int pointsEarned;
    private boolean winner;
    private boolean topPodium;
    
    /*********************************************************************************************
    Name: race  
    Parameters: String raceId, String raceName, String location, String date, Driver driver, Team team, int position, int pointsEarned
    Purpose: Constructor for Race class
    *******************************************************************************************/
    public raceResults(String raceName, String location, String date, Driver driver, Team team, int position, int pointsEarned) {
        this.raceName = raceName;
        this.location = location;
        this.date = date;
        this.driver = driver;
        this.team = team;
        this.position = position;
        this.pointsEarned = pointsEarned; 
        this.winner = (position == 1); 
        this.topPodium = (position <= 3); 
    }
    /*********************************************************************************************
    Name: getRaceName
    Parameters: none
    Purpose: To get the raceName of the which is the title of each race
    *******************************************************************************************/
    public String getRaceName() {
        return raceName;
    }
    /*********************************************************************************************
    Name: getLocation
    Parameters: none
    Purpose: To get the location of the Race (what country the race is located in)
    *******************************************************************************************/
    public String getLocation() {
        return location;
    }
    /*********************************************************************************************
    Name: getDate
    Parameters: none
    Purpose: To get the date of when the race is held
    *******************************************************************************************/
    public String getDate() {
        return date;
    }
    /*********************************************************************************************
    Name: getDriver
    Parameters: none
    Purpose: To get the driver and list the driver
    *******************************************************************************************/
    public Driver getDriver() {
        return driver;
    } 
    /*********************************************************************************************
    Name: getTeam
    Parameters: none
    Purpose: To get the team of the Race object
    *******************************************************************************************/
    public Team getTeam() {
        return team;
    }
    /*********************************************************************************************
    Name: getPosition
    Parameters: none
    Purpose: To get the position of the Race object
    *******************************************************************************************/
    public int getPosition() {
        return position;
    }
    /*********************************************************************************************
    Name: getPointsEarned
    Parameters: none
    Purpose: To get the pointsEarned of the Race object
    *******************************************************************************************/
    public int getPointsEarned() {
        return pointsEarned;
    }
    /*********************************************************************************************
    Name: isWinner
    Parameters: none
    Purpose: To check if the driver is the winner of the Race
    *******************************************************************************************/
    public boolean isWinner() {
        return winner;
    }
    /*********************************************************************************************
    Name: isTopPodium
    Parameters: none
    Purpose: To check if the driver is in the top podium of the Race
    *******************************************************************************************/
    public boolean isTopPodium() {
        return topPodium;
    }
    /*********************************************************************************************
    Name: addPointsEarned
    Parameters: none
    Purpose: To add pointsEarned to the Driver and Team objects
    *******************************************************************************************/
    public void addPointsEarned() {
        driver.addPoints(pointsEarned);
        team.addPoints(pointsEarned);
        if (winner) {
            driver.addWin();
        }
        if (topPodium) {
            driver.addPodium();
        }
    }
    /***********************************************************************************************
    Name: toString
    Parameter: None
    Purpose: Print results for the leaderboard
    ************************************************************************************************/
    @Override
    public String toString() {
        String label = "";
        if (winner) label = "🏆 WINNER";
        else if (topPodium) label = "🥉 PODIUM";
        return raceName + " - " + driver.getDriverName() + " P" + position + " +" + pointsEarned + "pts " + label;
    }
}