/**
 * Created by Lydia Latocki on 4/25/17.
 */
public class Fruit {
    //instance variables (instead of static variables), Fruit arrayList is populated in Products.java class.
    private String name;
    private int sku;
    private String category;
    private String descript;
    private double price;

    // getters and setters of ArrayList<Fruit> fruitList
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSku(int sku){
        return sku;
    }

    public void setSku(int sku){
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Fruit(String name, int sku, String category, String descript, double price) {
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.descript = descript;
        this.price = price;
    }
    @Override
    public String toString() {

        return name + "\t" + category + "\t" + descript + "\t$" + price;
    }

}
