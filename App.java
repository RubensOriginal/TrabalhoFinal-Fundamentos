import java.util.Scanner;

public class App {

    public static Parking parking;

    public static final Scanner in = new Scanner(System.in);

    // Method which control all inputs from main menu
    public static void consoleController() {
        String option = "0";
        String spot = "";
        
        System.out.println("Seja bem-vindo ao gerenciador de vagas de estacionamento.");
        
        do {
            System.out.println("--------------------------------------");
            System.out.println("Escolha uma das opções a seguir:\n");

            System.out.println("\t1) Visualizar o mapa do estacionamento");
            System.out.println("\t2) Ocupar uma vaga");
            System.out.println("\t3) Liberar uma vaga");
            System.out.println("\t4) Encontrar a primeira vaga livre");
            System.out.println("\t5) Exibir estatísticas");
            System.out.println("\t6) Localizar veículo\n");

            System.out.println("\t0) Sair do Aplicativo\n");
            
            System.out.print("Digite a opção desejada: ");
            option = in.nextLine();
            
            boolean hasAnError = false;
            
            switch (option) {
                case "1": 
                    // Present to user a Map showing free and occupied spots
                    System.out.println("Mapa de Vagas Livres e Ocupadas:");
                    parking.getParkingMap();
                    System.out.print("\nLegenda:\nL - Livre\nO - Ocupada\n");
                    break;
                case "2":
                    // Take a spot chosen by user
                    do {
                        System.out.print("Digite a vaga que você deseja ocupar: ");
                        spot = in.nextLine().toUpperCase().replace(" ","");
                        
                        if (spot.length() == 2) {
                            if ((spot.charAt(0) >= 'A' && spot.charAt(0) <= 'Z') && (spot.charAt(1) >= '0' && spot.charAt(1) <= '9')) {
                                parking.takeSpot(parking.getSpotByName(spot));
                            } else {
                                hasAnError = true;
                                System.out.printf("Ocorreu um erro. A vaga %s não respeita o padrão letra número. Ex: A1.\n", spot);
                            }
                        } else if (spot.length() == 3) {
                            if ((spot.charAt(0) >= 'A' && spot.charAt(0) <= 'Z') && (spot.charAt(1) >= '0' && spot.charAt(1) <= '9') && (spot.charAt(2) >= '0' && spot.charAt(2) <= '9')) {
                                parking.takeSpot(parking.getSpotByName(spot));
                            } else {
                                hasAnError = true;
                                System.out.printf("Ocorreu um erro. A vaga %s não respeita o padrão letra número. Ex: A1.\n", spot);
                            }
                        } else {
                            hasAnError = true;
                            System.out.printf("Ocorreu um erro. A vaga %s não respeita o padrão letra número. Ex: A1.\n", spot);
                        }
                    } while (hasAnError);
                    break;
                case "3":
                    // Release this spot
                    System.out.print("Digite a vaga, a placa do carro ou o motorista do veículo que você deseja liberar: ");
                    String externalData = in.nextLine().toUpperCase().trim();

                    String releasedSpot = parking.releaseSpot(externalData);
                    if (releasedSpot.equals("00")) {
                        System.out.printf("Nao conseguimos encontrar nenhuma vaga utilizando %s como parametro de busca", externalData);
                    } else {
                        System.out.printf("A vaga %s foi liberada com sucesso!\n ", releasedSpot);
                    }
                    break;
                case "4":
                    // Find the first free spot and ask if user would like to occupy this spot 
                    ParkingSpot freeParkingSpot = parking.getFirstFreeParkingSpot();
        
                    if (freeParkingSpot.getSpotName().equals("00")) {
                        System.out.println("O estacionamento esta cheio. Primeiro, libere uma vaga para que seja possivel achar uma vaga livre.");
                    } else {
                        System.out.printf("A vaga %s foi encontrada. Voce deseja ocupa-la ([S]im / [N]ao)? ", freeParkingSpot.getSpotName());
                        String confirmation = in.nextLine();
                        if (confirmation.equalsIgnoreCase("S") || confirmation.equalsIgnoreCase("Sim")) {
                            parking.takeSpot(freeParkingSpot);
                        } else if (confirmation.equalsIgnoreCase("N") || confirmation.equalsIgnoreCase("Nao")) {
                            System.out.println("Ok. Fica para a proxima.");
                        } else {
                            System.out.println("Sua resposta nao parece com nenhuma das anteriormente apresentadas. Sendo assim, estamos voltando ao menu principal.");
                        }
                    }
                    break;
                case "5":
                    // Present some data related to Parking to user
                    StatisticData statistics = parking.getStatisticData();
                    System.out.println("Dados estatisticos do estacionamento:");
                    System.out.printf("Vagas ocupadas: %d de %d (%.1f%%)\n", statistics.getNumberOccupiedSpots(), statistics.getNumberTotalSpots(), statistics.getPercentageOccupiedSpots());
                    System.out.printf("Vagas livres: %d de %d (%.1f%%)\n", statistics.getNumberFreeSpots(), statistics.getNumberTotalSpots(), statistics.getPercentageFreeSpots());
                    break;
                case "6":
                    // Print all cars with a determined colour chosen by user
                    System.out.print("Escolha a cor do carro que voce deseja localizar: ");
                    String carColour = in.nextLine();
                    parking.spotByCarColour(carColour);
                    break;
                case "0":
                    // Finish the session
                    System.out.println("Obrigado pela preferência, tenha um bom dia! ");
                    break;
                default:
                    // Anything else
                    System.out.println("Ocorreu um erro. A opção escolhida não existe!");
                    break;
            }
        } while (!option.equals("0"));
    }

    public static void main(String[] args) {
        parking = new Parking();
        parking.fillParking();

        consoleController();
    }
}
