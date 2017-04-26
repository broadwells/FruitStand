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
        int counter = 0; // this is going to be used to calculate the amount of items our user chooses


        ArrayList<Fruit> fruitList = new ArrayList<>();
        Products fruit = new Products(fruitList);
        int j = 1;  //counter
        for (Fruit i : fruit.listFruit()) {
            System.out.println(j + ". " + i);
            j++;
        }



        //for (int j = 0; j < ArrayList.length; j++){
        do {
            System.out.println("Please choose your fruit: ");
            userInput = scan.nextInt();
            for (int i = 0; i < fruit.listFruit().size(); i++) {
                if (userInput == i) {
                    System.out.println(fruit.listFruit().get(i - 1));
                    System.out.println("How many " + fruit.listFruit().get(i - 1) + "'s would you like to add to your" +
                            " cart? ");
                    int quantity = scan.nextInt();
                    if (quantity > 1) {
                        counter += quantity;
                        System.out.println("you added " + counter + " " + fruit.listFruit().get(i - 1) + "'s.");
                    } else if (quantity == 1) {
                        counter += quantity;
                        System.out.println("you added " + counter + " " + fruit.listFruit().get(i - 1));
                    }
                }
            }
            scan.nextLine();
            System.out.println("Would you like to add more fruit or check out? more/checkout");
            userDecision = scan.nextLine();
            if (userDecision.equalsIgnoreCase("checkout")) {
                System.out.println("Goodbye");
            }
        } while (userDecision.equalsIgnoreCase("more"));
    }

        //blank arrayList.length add for counter + fruit[i-1]
        //[j].add
}

