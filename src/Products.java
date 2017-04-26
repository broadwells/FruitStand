import java.util.ArrayList;

/**
 * Created by Pro on 4/25/17.
 */
public class Products {

    public static void main(String[] args) {


        /* List of 14 Fruit ready to sell in Fruit Stand
         */
        ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.add(new Fruit("Apple: Macintosh, 5lb bag", 4019,"Produce", "Michigan grown, red and green skinned apples. Great for baking and eating.", 3.49)); // Fruit index 0
        fruitList.add(new Fruit("Apple: Granny Smith, 4lb bag", 4018, "Produce", "Michigan grown tart green apple. Great for carmel apples and eating.", 3.49)); // index 1
        fruitList.add(new Fruit("Avocados: Haas, 4ct bag", 4225, "Produce","Large Haas avocados perfect for salads and guacamole.",3.99 )); // index 2
        fruitList.add(new Fruit("Bananas: 5-8ct Bunches, 4lb bunch", 4011, "Produce", "Large yellow ripe bunches. Great for Lunches.", 2.79)); // index 3
        fruitList.add(new Fruit("Blueberries: 6oz pack", 4240, "Produce", "Luscious sweet berries eaten plain or added to baked goods.", 3.99)); // index 4
        fruitList.add(new Fruit("Cherries: Sweet Red, 1lb bag", 4045, "Produce", "Firm, sweet, succulent fruit with cherry-red skins.", 6.25)); // index 5
        fruitList.add(new Fruit("Grapes: Green Seedless, 2.5lb bag", 4022, "Produce","Sweet green-white fruit, perfect for snacks.", 7.38)); // index 6
        fruitList.add(new Fruit("Grapes: Red Seedless, 2.5lb bag", 4023, "Produce", "Large glossy fruit with plenty of flavor.", 6.22)); // index 7
        fruitList.add(new Fruit("Melon: Cantaloupe, whole 5lb", 4049, "Produce", "Ambrosia Cantaloupe with luscious sweet flavor.", 2.69)); // index 8
        fruitList.add(new Fruit("Strawberries, 16oz pack", 4028, "Produce", "Large sweet red berries. Great for eating and toppings.", 5.00)); // index 9
        fruitList.add(new Fruit("Peaches: Red Haven, 1lb bag", 4404, "Produce", "Ultra sweet, large, juicy fruit with tender skins.", 2.99)); // index 10
        fruitList.add(new Fruit("Pears: D'Anjou, 1lb bag", 4416, "Produce", "Elegantly sweet pear. Perfect for cheese plates or sliced for lunch.", 1.29)); // index 11
        fruitList.add(new Fruit("Pears: Bartlett, 1lb bag", 4412, "Produce", "Savory juicy sweetness. Great eaten with cheese or sliced in for salads.", 1.29)); // index 12
        fruitList.add(new Fruit("Watermelon: Seeded, whole 8lb", 4031, "Produce", "Best-tasting watermelon available. Sweet and juicy snack melon.", 6.99)); // index 13

    }
}