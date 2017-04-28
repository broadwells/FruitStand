import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lydia Latocki on 4/25/17.
 * This class is collection of methods that print Product List to screen and to file, update product list and Read product list from file.
 */
public class ManageFruit {

    public static ArrayList<Fruit> fruitList = new ArrayList<>();

    public ManageFruit(ArrayList<Fruit> fruitList){ // constructor setting fruit into arrayList
        this.fruitList = fruitList;
    }

    public static void ReadFile() { // write to a text file to store inventory list
        Path filePath = Paths.get("src/FruitInventory.txt");
        File textFile = filePath.toFile();

        try {
            FileReader r = new FileReader("src/FruitInventory.txt");
            BufferedReader reader = new BufferedReader(r); // BufferReader saves time in reading files by simplifying the read of test in the file
            try {
                String line = reader.readLine(); // similar to scanner, it is reading each line
                while (line != null) { // this takes care of EOTException, end of file exception
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {     //takes care of FileNotFound exception
            e.printStackTrace();
        }
    }
    //variable name of scanner doesn't have to match first declaration but it has to have Scanner type passed in
    public static void WriteToFile(ArrayList<Fruit> fruitList) {

        //String productList = s.nextLine();
        Path textPath = Paths.get("src/FruitInventory.txt"); // adding the dir/ before the file name will ensure that writing directly in the file
        File textFile = textPath.toFile();
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(textFile, true));  // boolean true so writes to the end of your file and does not replace it.
            out.println(Products.class);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void CreateFile(String dirString, String fileString) {
        Path filePath = Paths.get(dirString, fileString);
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath); //the method will determine if a directory is created or a .doc
            } catch (IOException e) {
                System.out.println("There was an error: " + e);
            }
        }
        System.out.println("File Name: " + filePath.getFileName()); // return file real file name
        System.out.println("File Absolute Path: " + filePath.toAbsolutePath()); //and absolute path to the file
        System.out.println("Is is writable: " + Files.isWritable(filePath));
    }

    public static void CreateDirectory(String dirString) { // to create the file directory
        Path dirPath = Paths.get(dirString);
        if (Files.notExists(dirPath)) {
            try {
                Files.createDirectories(dirPath); // the method will determine if a directory is created or a .doc
            } catch (IOException e) {
                //e.printStackTrace(); // can type your own sentence to users to make exception more clear
                System.out.println("There was an error; " + e);
            }
        }
    }


    public static void ListAllFruit() { // list complete info: name, sku, category, descript, price
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.println(i + fruitList.get(i).getName() + fruitList.get(i).getSku(i) + fruitList.get(i).getCategory() + fruitList.get(i).getDescript() + fruitList.get(i).getPrice());
        }
    }

    public static void FindFruitName(String userInput) { // used for String search - print fruit: name, sku only
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getName().equalsIgnoreCase(userInput)) { // userInput in search for fruit by name
                System.out.println(i + ": " + fruitList.get(i).getName() + fruitList.get(i).getSku(i)); // print fruit: name, sku only
            }
        }
    }

    public void findFruitSku(int userSku) { // used for int search - print fruit: name, sku only
        for (int i = 0; i < fruitList.size(); i++) {
            if (i == userSku) { // userInput in search for fruit by name FIXME to print all fruit w/ that name
                System.out.println(i + ": " + fruitList.get(i).getName() + fruitList.get(i).getSku(i)); //- print fruit: name, sku only
            }
        }
    }

    public void removeFruit(int userInput) { // user input fruit sku
        if (userInput < 0 || userInput > fruitList.size()) {
            System.out.println("Invalid sku number.");
        }
        fruitList.remove(userInput);

    }

}
