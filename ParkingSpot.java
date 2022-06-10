public class ParkingSpot
{
    private String spotName;
    
    private boolean vacancy = true;
    
    private String carPlate = ""; 
    private String carColour = "";
    private String carDriver = "";
    
    public ParkingSpot(String spotName) {
        this.spotName = spotName;
    }
    
    public String getSpotName() {
        return spotName;
    }
    
    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
    }
    
    public boolean getVacancy() {
        return vacancy;
    }
}
