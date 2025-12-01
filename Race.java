public class Race {
    private String raceId;
    private String raceName;
    private String location;
    private String date;
    private Driver driver;
    private Team team;
    private int position;
    private int pointsEarned;
    
    /*********************************************************************************************
    Name: race  
    Parameters: String raceId, String raceName, String location, String date, Driver driver, Team team, int position, int pointsEarned
    Purpose: Constructor for Race class
    *******************************************************************************************/
    public race (String raceId, String raceName, String location, String date, Driver driver, Team team, int position, int pointsEarned) {
        this.raceId = raceId;
        this.raceName = raceName;
        this.location = location;
        this.date = date;
        this.driver = driver;
        this.team = team;
        this.position = position;
        this.pointsEarned = pointsEarned;   
    }
    /*********************************************************************************************
    Name: getRaceId
    Parameters: none
    Purpose: To get the raceId of the Race object
    *******************************************************************************************/
    public String getRaceId() {
        return raceId;
    }
    /*********************************************************************************************
    Name: getRaceName
    Parameters: none
    Purpose: To get the raceName of the Race object
    *******************************************************************************************/
    public String getRaceName() {
        return raceName;
    }
    /*********************************************************************************************
    Name: getLocation
    Parameters: none
    Purpose: To get the location of the Race object
    *******************************************************************************************/
    public String getLocation() {
        return location;
    }
    /*********************************************************************************************
    Name: getDate
    Parameters: none
    Purpose: To get the date of the Race object
    *******************************************************************************************/
    public String getDate() {
        return date;
    }
    /*********************************************************************************************
    Name: getDriver
    Parameters: none
    Purpose: To get the driver of the Race object
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
    Name: addPointsEarned
    Parameters: none
    Purpose: To add pointsEarned to the Driver and Team objects
    *******************************************************************************************/
    public void addPointsEarned() {
        driver.addPoints(pointsEarned);
        team.addPoints(pointsEarned);
        if(position == 1) {
            driver.addWin();
        }   
        if(position <= 3) {
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
        return raceName + " - " + driver.getDriverName() + " (" + team.getTeamName() + ") "
               + " P" + position + " +" + pointsEarned + "pts";
    }
}