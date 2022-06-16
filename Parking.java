import java.util.Random;
import java.util.Scanner;
public class Parking {

    private ParkingSpot[][] parkingSpot;

    private int numberOfParkingSpot = 0;
    private Scanner in = new Scanner (System.in);

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

    public ParkingSpot getSpotByName(String spotName) {

        int column = (int)(spotName.charAt(0)) - 'A';
        int line = ((int) spotName.charAt(1)) - '1';

        return parkingSpot[column][line];
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
    public void takeAVacancy(ParkingSpot spot) {

        if(!spot.getVacancy()) {
            System.out.printf("Erro, a vaga %s está ocupada, por favor escolha outra de sua preferência.", spot);
        } else{
            System.out.println("Por favor digite as informações abaixo para que possamos colocar seus dados na vaga selecionada");
            
            System.out.println("1- Por favor, digitar seu nome completo (Ex.: Erik Adamastor Leoncio):");
            String name = in.nextLine().trim();
            
            System.out.println("2- Agora, digite a placa do seu carro (Ex.: IOS-2456):");
            String plate = in.nextLine().trim().toUpperCase();

            System.out.println("3- Por ultimo, mas nao menos importante, digite a cor do seu carro:");
            String colour = in.nextLine().trim();

            spot.setVacancy(false);
            spot.setCarDriver(name);
            spot.setCarPlate(plate);
            spot.setCarColour(colour);
        }
    }

    public String releaseAVacancy(String spot)
    {
        ParkingSpot requestedSpot = getSpotByName(spot);
        requestedSpot.setCarDriver("");
        requestedSpot.setCarPlate("");
        requestedSpot.setCarColour("");
        
        return spot;
    }

    public String firstFreeSpot() {
        boolean freeVacancy = false;
        ParkingSpot spot = parkingSpot[0][0];

        int column = 0;
        int line = 0;

        while (!freeVacancy && (column <= 9 && line <= 10)) {
            spot = parkingSpot[column][line];
            
            if (spot.getVacancy()) {
                freeVacancy = true;
                takeAVacancy(spot);
            }

            if ((column < 8 && line == 7) || (column >= 8 && line == 10)) {
                column++;
                line = 0;
            } else {
                line++;
            }
        }
        
        if (freeVacancy) {
            return spot.getSpotName();
        } else {
            return "PARKING_FULL";
        }
    }
}
    