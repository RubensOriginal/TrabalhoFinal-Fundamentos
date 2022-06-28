import java.util.Scanner;

public class App {

    public static Parking parking;

    public static final Scanner in = new Scanner(System.in);

    public static void consoleController() {
        String option = "0";
        String spot = "";
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
            
            //Fazer metodos para cada CASE.
            switch (option) {
                case "1":
                    
                    break;
                case "2":
                    do {
                        System.out.print("Digite a vaga que você deseja ocupar: ");
                        spot = in.nextLine().toUpperCase().replace(" ","");
                        
                        if (spot.length() == 2 || spot.length() == 3) {
                            parking.takeAVacancy(parking.getSpotByName(spot));
                            System.out.printf("A vaga %s foi ocupada com sucesso!\n", spot);
                        } else {
                            hasAnError = true;
                            System.out.printf("Ocorreu um erro. A vaga %s não respeita o padrão letra número. Ex: A1.\n", spot);
                        }
                    } while (!hasAnError);
                    break;
                case "3":
                    System.out.print("Digite a vaga que você deseja liberar: ");
                    spot = in.nextLine().toUpperCase().replace(" ","");

                    parking.releaseAVacancy(spot);
                    System.out.printf("A vaga %s foi liberada com sucesso!\n ", spot);
                    break;
                case "4":
                    spot = parking.firstFreeSpot();
                    if (spot.equals("PARKING_FULL")) {
                        System.out.println("O estacionamento está cheio. Primeiro, libere uma vaga para que seja possível achar uma vaga livre.");
                    } else {
                        System.out.printf("Parabens! A vaga %s está alocada para voce.\n", spot);
                    }

                    break;
                case "5":

                    break;
                case "6":
                    System.out.println("Escolha uma cor do carro");
                    String carColour = in.nextLine();
                    parking.spotByCarColour(carColour);
                    break;
                case "0":
                    System.out.println("Obrigado pela preferência, tenha um bom dia! ");
                    break;
                default:
                    System.out.println("Ocorreu um erro. A opção escolhida não existe!");
                    break;
            }
        } while (!option.equals("0"));
    }

    public static void main(String[] args) {
        parking = new Parking();
        parking.fillParking();
        
        System.out.println("Seja bem-vindo ao gerenciador de vagas de estacionamento.");

        consoleController();

        System.out.print("Finished");
    }
}
