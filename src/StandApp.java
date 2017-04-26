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


    }


}
