/**
 * Created by MichaelRiley on 4/26/17.
 */
public class ShoppingCart {

    private String fruitType;

    private int quantity;

    private double totalPrice;

    private double price;


//    public ShoppingCart(String fruitType, int quantity, double price) {
//        this.fruitType = fruitType;
//        this.quantity = quantity;
//        this.totalPrice = totalPrice;
//        this.price = price;
//
////    }

//    public ShoppingCart(String fruitType, int quantity, double total) {
//        this.fruitType = fruitType;
//        this.quantity = quantity;
//        this.total = total;
//    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotalPrice(int quanity, double price) {
        totalPrice = quanity * price;
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // use this one
    public double getPrice(int quanity, double price) {
        price *= quanity;
        return  price;

    }

    public void setPrice(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "you added " + quantity + " " + fruitType + "(s)" + " = " + getPrice(quantity,price);
    }
}
