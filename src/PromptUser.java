import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Michael Riley on 4/25/17.
 */
public class PromptUser {


    public static void FruitSelection(Scanner scan) {
        int userInput;
        int counter = 0;
        double fruitPrice;


        ArrayList<Fruit> fruitList = new ArrayList<>();//calling ArrayList from products
        ArrayList<CartItem> shoppingCart = new ArrayList<>();//storing cart items from user data
        Products fruit = new Products(fruitList);
        int j = 1;  //counter

        // This loop prints a full list of products with index ArrayList number for Shopper to view and select
        for (Fruit i : fruit.listFruit()) {
            System.out.println(j + ". " + i);
            j++;

        }
        String userDecision = null;
        System.out.println("\nWelcome to Detroit Rock Fruit Stand!");
        do {

            System.out.println("\nPlease choose your fruit: ");
            userInput = scan.nextInt();
            int i = 0;
            Fruit fruitChoice = fruit.listFruit().get(i);
            for (i = 0; i < fruit.listFruit().size(); i++) {//for loop to gather data, calculation and storage in shoppingCart ArrayList

                System.out.println("How many " + fruitChoice.getName() + "'s would you like to add to your" + " cart? ");
                int quantity = scan.nextInt();
                scan.nextLine();

                CartItem cartItem = new CartItem(fruitChoice.getName(), quantity, fruitChoice.getPrice());//storing data in shoppingCart ArrayList
                System.out.println(cartItem);

                shoppingCart.add(cartItem);

                System.out.println("Would you like to add more fruit or check out? more/checkout");
                userDecision = scan.nextLine();
                if (userDecision.equalsIgnoreCase("checkout"))
                    System.out.println("goodbye");//This is where Stephanie takes over

                break;

            }

        } while (userDecision.equalsIgnoreCase("more"));
    }
}
