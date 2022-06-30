import java.util.Random;

public class DataManager
{
    private final static int LETTERS = 26;
    private final static Random random = new Random();
    
    // Generate a Car Plate
    public static String carPlateGenerator() {
               
        char firstChar = (char)(random.nextInt(LETTERS) + 'A');
        char secondChar = (char)(random.nextInt(LETTERS) + 'A');
        char thirdChar = (char)(random.nextInt(LETTERS) + 'A');
        
        int firstNumber = random.nextInt(10);
        int secondNumber = random.nextInt(10);
        int thirdNumber = random.nextInt(10);
        int forthNumber = random.nextInt(10);
        
        return "" + firstChar + secondChar + thirdChar + "-" + firstNumber + secondNumber + thirdNumber + forthNumber; // String Builder
    }
    
    // Generate a Car Colour
    public static String carColourGenerator() {
           
        String[] carColours = {"Branco", "Preto", "Prata", "Cinza", "Azul", "Vermelho", "Laranja", "Marrom", "Dourado", "Creme"};
        
        return carColours[random.nextInt(carColours.length)];
    }
    
    // Generate a Driver
    public static String carDriverGenerator() {
        
        String[] firstName = {
            "Daniel", "Ari", "Salomao", "Nelio", "Ayrton", "Lilia", "Milton", "Luis", "Eric", "Gaia", "Clarinha", "Melissa", "Oscar", "Samara", "Mafalda", "Paloma", "Amy", "Virginia",
            "Apolo", "Viviane", "Karen", "Michele", "Nair", "Raul", "Dania", "Joel", "Jimmy", "Helder", "Humberto", "José", "Reginaldo", "Renato", "Elis", "Carlos", "Zeca", "Francisco",
            "Almir", "Maria Rita", "Maria Cristina", "Maria Cecilia", "Maria Eduarda", "Carolina", "Ana", "Paula", "Rubens", "Julio", "Vicenzo", "Sofia", "Gabrielle", "Guilherme", "Michael",
            "Ethan", "Martin", "Ema", "Tais", "Osvaldo", "Rosario", "Rebeca", "Lucas", "Lukas", "Iago", "Nicolas", "Enzo", "Vitor", "Angela", "Andre", "Carol", "Natalia", "Soraia", "Nelson"
        };
        String[] lastName = {
            "Montanha", "Marramarco", "Senna", "Caetano", "Faria", "Andrade", "Souza", "Castilho", "Borges", "Lopes", "Vargas", "Castro", "Moreira", "Macedo", "Vaz", "Morais", "Alves",
            "Carmo", "Dias", "Perez", "Branco", "Portugal", "Franco", "Lisboa", "Ferraz", "Raposo", "Correia", "Neiva", "Neves", "Gutierres", "Penha", "Cunha", "Amoedo", "Pontes", "Maia",
            "Coutinho", "Madeira", "Faro", "Caldeira", "Caldas", "Pinho", "Valverde", "Lobato", "Valin", "Noronha", "Gaspar", "Manso", "Queiroga", "Piquet", "Furquim", "Franca", "Nunes",
            "Amorin", "Nobrega", "Martins", "Rufino", "Coinbra", "Fagundes", "Serra", "Saraiva", "Amaral", "Silva", "Santos", "Escobar", "Cobra", "Passos", "Oliveira", "Barroso", "Silvestre"
        };
        
        return firstName[random.nextInt(firstName.length)] + " " + lastName[random.nextInt(lastName.length)];
    }

}
