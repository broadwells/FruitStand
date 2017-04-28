import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Grand Circus Tech Java Bootcamp Midterm Project
 * Created by Team DetroitRock: Stephanie Broadwell, Lydia Latocki and Mike Riley.
 *
 * This user of this applications is a Shopper at The DetroitRock Fruit Stand selecting fruit for purchase.
 * The Shopper is presented with a full list of Products available to purchase,
 * which includes: Fruit Name, Sku, Produce Category, Description and Price. The array index item number is also presented.
 *
 * The Shopper is prompted to select an item from the product list using the index item number.
 * The corresponding item is printed to screen and user is prompted to update the quantity desired for this item.
 * Action is confirmed with screen print of Product Name, Quantity and Total item price.
 * This action also stores the item and total price in a Shopping Cart Array for future calculations and print.
 *
 * The Shopper is prompted to Continue Shopping, or exit to Checkout.
 * Continue Shopping loops Shopper back to view inventory, select item, indicate quantity, confirm - then continue or checkout.
 * Upon selecting Checkout, Shopper will be presented with full list of items within the shopping cart.
 * Shopper is then prompted to modify shopping list, return to shopping, and move to payment processing.
 *
 * The payment processing collects Shopper profile before presenting payment type choices.
 * Payment validation occurs at collection of credit card number and validation code.
 *
 * Additionally, the fruit list is printed to a text file once, then updated when store makes inventory modifications.
 *
 */
public class StandApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileString = "FruitInventory.txt";
        FruitInventory.CreateFile(fileString);
        FruitInventory.ReadFile();
        //FruitInventory.WriteFile(scan);

        // direct to ManagerFruit class instead of FruitInventory Class then all list functions will be in same place

        System.out.println("Welcome to Detroit Rock Fruit Stand!\n");

        boolean shop = true;
        while (shop) {
            PromptUser.FruitSelection(scan);

            //ManageFruit.ListAllFruit();
            scan.nextLine();
            System.out.println("Would you like to shop again? ('y'/'n'): ");
            String yesNo = scan.nextLine();

            if (yesNo.equalsIgnoreCase("n")){
                System.out.println("Goodbye!");
                shop = false;
            }
        }



        }

    }

