import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MichaelRiley on 4/25/17.
 */
public class PromptUser {

    public static void FruitSelection() {
        Scanner scan = new Scanner(System.in);
        int userInput;
        String userDecision = null;
        int counter = 0;
        String fruitChoice;
        double fruitPrice;

        ArrayList<Fruit> fruitList = new ArrayList<>();
        ArrayList<ShoppingCart> shoppingCart = new ArrayList<>();
        Products fruit = new Products(fruitList);
        int j = 1;  //counter
        for (Fruit i : fruit.listFruit()) {
            System.out.println(j + ". " + i);
            j++;
        }



        do {
            System.out.println("Please choose your fruit: ");
            userInput = scan.nextInt();
            for (int i = 0; i < fruit.listFruit().size(); i++) {

                if (userInput == i) {
                    fruitChoice = fruit.listFruit().get(i - 1).getName();
                    fruitPrice = fruit.listFruit().get(i - 1).getPrice();
                    System.out.println(fruitChoice + " " + fruitPrice);
                    System.out.println("How many " + fruitChoice + "'s would you like to add to your" +
                            " cart? ");
                    int quantity = scan.nextInt();
                    if (quantity > 1) {
                        counter += quantity;
                        /*there needs to be a loop here.  In order to change the index from 0 to i, there needs to be a loop that will continue to store
                        information.  then we ask the questions if we want continue or checkout.  Please call me 586-489-7310, if you need clarification.

                        */
                        shoppingCart.add(new ShoppingCart());
                        shoppingCart.get(0).setFruitType(fruitChoice);
                        shoppingCart.get(0).setQuantity(counter);
                        shoppingCart.get(0).setPrice(fruitPrice, counter);
                        System.out.println(shoppingCart.get(0));
                        scan.nextLine();
                        System.out.println("Would you like to add more fruit or check out? more/checkout");
                        userDecision = scan.nextLine();

                        if (userDecision.equalsIgnoreCase("checkout")) {
                            System.out.println("Goodbye");
                        } else if (quantity == 1) {
                            counter += quantity;
                            System.out.println("you added " + counter + " " + fruit.listFruit().get(i - 1).getPrice());
                        }
                    }
                }
            }
        } while (userDecision.equalsIgnoreCase("more"));



    }
}

