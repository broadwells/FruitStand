/**
 * Created by MichaelRiley on 4/26/17.
 */
public class CartItem {

    private String fruitType;
    private int quantity;
    private double price;


    public CartItem(String fruitType, int quantity, double price) {
        this.fruitType = fruitType;
        this.quantity = quantity;
        this.price = price;
    }


    public double getPrice() {
        return  price;

    }


    @Override
    public String toString() {
        return quantity + " " + fruitType + "(s)" + " = " + getPrice();
    }
}
