import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MichaelRiley on 4/25/17.
 */
public class FruitInventory {
    public static void CreateFile(String fileString) {
        Path filePath = Paths.get(fileString);//strings above

        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.out.println("There was an error: " + e);
            }
        }
    }

    public static void ReadFile() {
        Path filePath = Paths.get("FruitInventory.txt");
        File file = filePath.toFile();

        try {
            FileReader r = new FileReader(file);
            BufferedReader reader = new BufferedReader(r);
            try {
                String line = reader.readLine();

                while (line != null){
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   public static void WriteFile(Scanner scan) {

        System.out.println("Please add fruit:  ");
        String countryName = scan.nextLine();

        Path filePath = Paths.get("FruitInventory.txt");
        File file = filePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
            out.println(countryName);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printFruitList(ArrayList <Fruit> listFruit){
        int j = 1;  //counter

        for (Fruit i : listFruit) {
            System.out.println(j + ". " + i);
            j++;
        }
    }

}
