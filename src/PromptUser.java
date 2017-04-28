import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Michael Riley on 4/25/17.
 */
public class PromptUser {


    public static void FruitSelection(Scanner scan) {
        int userInput;
        ArrayList<CartItem> shoppingCart = new ArrayList<>();   //storing cart items from user data
        Products fruit = new Products();    //calling ArrayList from products

        // This loop prints a full list of products with index ArrayList number for Shopper to view and select
        int j = 1;  //counter
        for (Fruit i : fruit.listFruit()) {
            System.out.println(j + ". " + i);
            j++;
        }

        String userDecision;

        do {
            System.out.println("\nPlease choose your fruit: ");
            userInput = scan.nextInt();
            Fruit fruitChoice = fruit.listFruit().get(userInput - 1);
            System.out.println("How many " + fruitChoice.getName() + "(s) would you like to add to your cart? ");
            int quantity = scan.nextInt();

            CartItem cartItem = new CartItem(fruitChoice.getName(), quantity, (fruitChoice.getPrice() * quantity));
            //storing data in shoppingCart ArrayList
            shoppingCart.add(cartItem);
            System.out.println("You added: " + cartItem.toString());
            scan.nextLine();
            System.out.println("Would you like to add more fruit or check out? more/checkout");
            userDecision = scan.nextLine();
            if (userDecision.equalsIgnoreCase("checkout")) {
                System.out.println("Proceeding to checkout!");
            }
        }
        while (userDecision.equalsIgnoreCase("more"));

        CheckOut readyToLeave = new CheckOut();
        readyToLeave.promptPayment(scan, shoppingCart);
        readyToLeave.printReceipt(shoppingCart);
    }
}
