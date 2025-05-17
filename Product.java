package Project_1;

public class Product {

    private final String name; // название товара
    private final double price; // цена товара

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
