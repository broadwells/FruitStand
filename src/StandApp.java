import java.util.Scanner;

/**
 * Created by broadwells on 4/25/17.
 */
public class StandApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileString = "FruitInventory.txt";

        FruitInventory.CreateFile(fileString);
        FruitInventory.ReadFile();
        //FruitInventory.WriteFile(scan);

        PromptUser.FruitSelection();

<<<<<<< HEAD
        System.out.println("Hello World!");
        System.out.println("Group 1 is awesome");
=======
>>>>>>> 75f9aa36da420d858a15731b7023165bb193ab34


    }


}
