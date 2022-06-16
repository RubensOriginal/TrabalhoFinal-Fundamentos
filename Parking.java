import java.util.Random;

public class Parking {

    private ParkingSpot[][] parkingSpot;

    private int numberOfParkingSpot = 0;

    // Create Parking
    public Parking() {
        parkingSpot = new ParkingSpot[10][];

        for (int i = 0; i < parkingSpot.length; i++) {
            int spotCount = 0;

            if (i < 7)
                spotCount = 8;
            else
                spotCount = 11;

            parkingSpot[i] = new ParkingSpot[spotCount];

            for (int j = 0; j < parkingSpot[i].length; j++) {
                String spotName = (char)(i + 65) + "" + (j + 1);
                parkingSpot[i][j] = new ParkingSpot(spotName);
            }

            numberOfParkingSpot += spotCount;
        }
    }

    public void fillParking() {
        Random random = new Random();

        int numberSpotsToBeFilled = ((numberOfParkingSpot * 70) / 100) + 1;

        int column = 0;
        int line = 0;

        while (numberSpotsToBeFilled > 0) {
            int futureSpotStatus = random.nextInt(2);
            
            ParkingSpot spot = parkingSpot[column][line];
            
            if (spot.getVacancy() && futureSpotStatus == 1) {
                spot.setVacancy(false);
                spot.setCarPlate(DataManager.carPlateGenerator());
                spot.setCarColour(DataManager.carColourGenerator());
                spot.setCarDriver(DataManager.carDriverGenerator());
                numberSpotsToBeFilled--;
            }

            if (column == 9 && line == 10) {
                column = 0;
                line = 0;
            } else if ((column < 8 && line == 7) || (column >= 8 && line == 10)) {
                column++;
                line = 0;
            } else {
                line++;
            }
        }
    }

}
