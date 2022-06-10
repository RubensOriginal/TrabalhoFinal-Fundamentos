public class App
{
    private static ParkingSpot[][] parkingSpot;
    
    public static void createParking() {
        parkingSpot = new ParkingSpot[10][];
        
        for (int i = 0; i < parkingSpot.length; i++) {
            int spotCount = 0;
            
            if (i < 8)
                spotCount = 8;
            else
                spotCount = 11;
            
            parkingSpot[i] = new ParkingSpot[spotCount];
            
            for (int j = 0; j < parkingSpot[i].length; j++) {
                String spotName = (char)(i + 65) + "" + (j + 1);
                parkingSpot[i][j] = new ParkingSpot(spotName);
            }
        }
    }
    
    
    public static void main(String[] args) {
        createParking();
        
        System.out.print("Finished");
    }
}
