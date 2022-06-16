import java.util.Scanner;

public class App {

    public static Parking parking;

    public static final Scanner in = new Scanner(System.in);

    public static void consoleController() {
        String option = "0";
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
            
            //Fazer metodos para cada CASE.
            switch (option) {
                case "1":
                    
                    break;
                case "2":
                    System.out.print("Digite a vaga que você deseja ocupar: ");
                    String spot = in.nextLine();

                    parking.takeAVacancy(spot);

                    System.out.printf("A vaga %s foi ocupada com sucesso!\n", spot);
                    break;
                case "3":
                
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "0":
                    System.out.println("Obrigado pela paciência, tenhaa um bom dia! ");
                    break;
                default:
                    System.out.println("Ocorreu um erro. A opção escolhida não existe!");
                    break;
            }
        } while (option != "0");
    }

    public static void main(String[] args) {
        parking = new Parking();
        parking.fillParking();
        
        System.out.println("Seja bem-vindo ao gerenciador de vagas de estacionamento.");

        consoleController();

        System.out.print("Finished");
    }
}