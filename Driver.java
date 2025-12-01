public class  Driver {
    private String driverid;
    private String driverName;
    private String team;
    private int carNumber;
    private String nationality;
    private int points;
    private int wins;
    private int podiums;
    //Contrustors
    public Driver(String driverid, String driverName, String team, int carNumber, String nationality, int points, int wins, int podiums) {
        this.driverid = driverid;
        this.driverName = driverName;
        this.team = team;
        this.carNumber = carNumber;
        this.nationality = nationality;
        this.points = points;
        this.wins = wins;
        this.podiums = podiums;
    }
    public String getDriverid() {
        return driverid;
    }
    public String getDriverName() {
        return driverName;
    }
    public String getTeam() {
        return team;
    }
    public int getCarNumber() {
        return carNumber;
    }
    public String getNationality() {
        return nationality; 
    }
    public int getPoints() {
        return points;
    }
    public int getWins() {
        return wins;                
    }
    public int getPodiums() {
        return podiums;
    }

}