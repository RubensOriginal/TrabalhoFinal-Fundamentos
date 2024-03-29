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
    
    public void setCarPlate(String plate){
        if (plate.length() == 7) {
            this.carPlate = plate.substring(0, 3) + "-" + plate.substring(3, 7);
        } else {
            this.carPlate = plate;
        }
    }
    
    public String getCarPlate() {
        return carPlate;
    }
    
    public void setCarColour(String colour) {
        this.carColour = colour;
    }
    
    public String getCarColour() {
        return carColour;
    }
    
    public void setCarDriver(String name) {
        this.carDriver = name;
    }
    
    public String getCarDriver() {
        return carDriver;
    }
    
    public ParkingSpot takeSpot(String carDriver, String carColour, String carPlate) {
        if (this.getVacancy()) {
            setCarColour(carColour);
            setCarDriver(carDriver);
            setCarPlate(carPlate);
            setVacancy(false);
        }
        return this;
    }
    
    public ParkingSpot releaseSpot() {
        if (!this.getVacancy()) {
            setCarColour("");
            setCarDriver("");
            setCarPlate("");
            setVacancy(true);            
        }
        return this;
    }
}
