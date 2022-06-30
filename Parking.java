import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Parking {

    private ParkingSpot[][] parkingSpot;

    private int numberOfParkingSpot = 0;
    // private Scanner in = new Scanner (System.in);

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
    
    // Fill 70% of Parking with random cars. 
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
    
    // Find the spot using chars from spotName
    public ParkingSpot getSpotByName(String spotName) {

        int column = (int)(spotName.charAt(0)) - 'A';
        int line = 0;

        if (spotName.length() == 2) {
            line = ((int) spotName.charAt(1)) - '1';
        } else {
            line = ((int)spotName.charAt(1) - '0') * 10 + ((int) spotName.charAt(2) - '1') ;
        }

        return parkingSpot[column][line];
    }
    
    // Find the spot using carPlate provided in method
    public ParkingSpot getSpotByPlate(String plate) {
        String carPlate = "";
        if (plate.length() == 7) {
            carPlate = plate.substring(0, 3) + "-" + plate.substring(3, 7);
        } else {
            carPlate = plate;
        }
        
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getCarPlate().equals(carPlate)) {
                    return parkingSpot[i][j];            
                }
            }
        }
        
        return new ParkingSpot("00");
    }
    
    // Find the spot using carColour provided in method
    public ArrayList<ParkingSpot> getSpotsByCarColour(String carColour) {
        ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
        
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getCarColour().equalsIgnoreCase(carColour)) {
                    parkingSpots.add(parkingSpot[i][j]);
                }
            }
        }
            
        return parkingSpots;
    }
    
    // Find the spot using driverName provided in method
    public ParkingSpot getSpotByDriverName(String driverName) {
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getCarDriver().equalsIgnoreCase(driverName)) {
                    return parkingSpot[i][j];            
                }
            }
        }
            
        return new ParkingSpot("00");
    }
    
    // Find first free spot
    public ParkingSpot getFirstFreeParkingSpot() {
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getVacancy()) {
                    return parkingSpot[i][j];            
                }
            }
        }
        return new ParkingSpot("00");
    }
    
    // Print a Map Showing Status of Each spot in Parking
    public void getParkingMap(){
        System.out.println("   A B C D E F G H I J ");
        
        for (int i = 0; i < 11; i++) {
            System.out.printf("%02d ", i + 1);
            for (int j = 0; j < 10; j++) {
                if (i < parkingSpot[j].length) {
                    if(parkingSpot[j][i].getVacancy()) {
                        System.out.print("L ");
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }
    
    // Generate StatisticData to App
    public StatisticData getStatisticData() {
        int freeSpots = 0;
        int occupitedSpots = 0;
        
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getVacancy()) {
                    freeSpots++;
                } else {
                    occupitedSpots++;
                }
                
            }
        }
        return new StatisticData(freeSpots, occupitedSpots);
    }
    
    // Method used by App to take a spot
    public void takeSpot(ParkingSpot spot) {

        if(!spot.getVacancy()) {
            System.out.printf("Ocorreu um erro. A vaga %s já está ocupada.\n", spot.getSpotName());
        } else{
            System.out.println("Por favor digite as informações abaixo para que possamos colocar seus dados na vaga selecionada");
            
            System.out.print("1- Por favor, digitar seu nome completo (Ex.: Erik Adamastor Leoncio): ");
            String driverName = App.in.nextLine().trim();
            
            System.out.print("2- Agora, digite a placa do seu carro (Ex.: IOS-2456): ");
            String carPlate = App.in.nextLine().trim().toUpperCase();

            System.out.print("3- Por ultimo, mas nao menos importante, digite a cor do seu carro: ");
            String carColour = App.in.nextLine().trim();

            spot.takeSpot(driverName, carColour, carPlate);
            System.out.printf("A vaga %s foi ocupada com sucesso!\n", spot.getSpotName());
        }
    }

    // Method used by App to release a spot
    public String releaseSpot(String data)
    {
        ParkingSpot spot;
        
        switch(data.length()) {
            case 2:
            case 3:
                spot = getSpotByName(data);
                if (spot.getSpotName() != "00")
                    break;
            case 7:
            case 8:
                spot = getSpotByPlate(data);
                if (spot.getSpotName() != "00")
                    break;
            default:
                spot = getSpotByDriverName(data);
                if (spot.getSpotName() != "00")
                    break;
        }
        
        if (spot.getSpotName() != "00") {
            spot.releaseSpot();
            return spot.getSpotName();
        } else {
            return "00";
        }
    }
    
    // Method used by App to print all spots a determined colour
    public void spotByCarColour(String carColour) {
        ArrayList<ParkingSpot> spots = getSpotsByCarColour(carColour);
        
        if(spots.size() == 0) {
           System.out.println("Essa cor nao existe.");
        } else {
            for(int i = 0; i < spots.size(); i++) {
                ParkingSpot spot = spots.get(i);
                System.out.println(spot.getCarPlate()+" "+spot.getCarDriver()+" "+spot.getSpotName());
            }
        }
        
    }
}
    