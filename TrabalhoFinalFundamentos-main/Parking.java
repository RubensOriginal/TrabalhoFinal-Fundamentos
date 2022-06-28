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
    
    // Find the parkingSpot using chars from spotName
    public ParkingSpot getSpotByName(String spotName) {

        int column = (int)(spotName.charAt(0)) - 'A';
        int line = 0;

        if (spotName.length() == 2) {
            line = ((int) spotName.charAt(1)) - '1';
        } else {
            line = ((int)spotName.charAt(1)) * 10 + ((int) spotName.charAt(2)) - 1 ;
        }
        

        return parkingSpot[column][line];
    }
    
    // Find the parkingSpot using carPlate provided in method
    public ParkingSpot getSpotByPlate(String carPlate) {
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getCarPlate().equals(carPlate)) {
                    return parkingSpot[i][j];            
                }
            }
        }
        
        return new ParkingSpot("00");
    }
    
    // Find the parkingSpot using carColour provided in method
    public ParkingSpot[] getSpotByCarColour(String carColour) 
    {
        ParkingSpot[] vet = new ParkingSpot[100];
        int cont = 0;
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getCarColour().equalsIgnoreCase(carColour)) {
                    vet[cont] = parkingSpot[i][j];
                    cont++;
                }
            }
        }
            
        return vet;
    }
    
    // Find the parkingSpot using driverName provided in method
    public ParkingSpot getSpotByDriverName(String driverName) {
        for (int i = 0; i < parkingSpot.length; i++) {
            for (int j = 0; j < parkingSpot[i].length; j++) {
                if (parkingSpot[i][j].getCarDriver().equals(driverName)) {
                    return parkingSpot[i][j];            
                }
            }
        }
            
        return new ParkingSpot("00");
    }
    
    // Find first free 
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

    
    public void takeAVacancy(ParkingSpot spot) {

        if(!spot.getVacancy()) {
            System.out.printf("Erro, a vaga %s está ocupada, por favor escolha outra de sua preferência.", spot);
        } else{
            System.out.println("Por favor digite as informações abaixo para que possamos colocar seus dados na vaga selecionada");
            
            System.out.println("1- Por favor, digitar seu nome completo (Ex.: Erik Adamastor Leoncio):");
            String driverName = in.nextLine().trim();
            
            System.out.println("2- Agora, digite a placa do seu carro (Ex.: IOS-2456):");
            String carPlate = in.nextLine().trim().toUpperCase();

            System.out.println("3- Por ultimo, mas nao menos importante, digite a cor do seu carro:");
            String carColour = in.nextLine().trim();

            spot.takeParkingSpot(driverName, carPlate, carColour);
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
        
        ParkingSpot spot = getFirstFreeParkingSpot();
        
        if (spot.getSpotName().equals("00")) {
            return "PARKING_FULL";
        } else {
            takeAVacancy(spot);
        }
        return spot.getSpotName();
    }
    
    public void spotByCarColour(String carColour)
    {
        ParkingSpot[] spot = getSpotByCarColour(carColour);
        
        if(spot.length == 0)
        {
           System.out.println("this doesn't exist colour");
        }
        else{
            for(int i = 0; i < spot.length; i++)
            {
                if(spot[i]==null)
                   break;
                else
                   System.out.println(spot[i].getCarPlate()+" "+spot[i].getCarDriver()+" "+spot[i].getSpotName());
            }
        }
        
    }
}
    