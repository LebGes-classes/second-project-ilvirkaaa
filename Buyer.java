package Project_1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final String name; // имя покупателя
    private final List<Product> purchasedProducts; // список купленных товаров

    private final PrintWriter writer;

    public Buyer(String name) {
        this.name = name;
        this.purchasedProducts = new ArrayList<>();

        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true);
            writer.println("Покупатель " + name + " создан\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Покупка товара
    public void buyProduct(Product product, Store store) {
        purchasedProducts.add(product); // добавляем в купленные товары
        store.sellProduct(product); // продаем из магазина
        writer.println(name + " купил " + product.getName());
    }

    // Возврат товара
    public void returnProduct(Product product, Store store) {
        if (purchasedProducts.contains(product)) { // если есть
            purchasedProducts.remove(product); // удаляем из купленных товаров
            store.addProduct(product); // добавляем в магазин обратно
            writer.println(name + " вернул " + product.getName());
        }
    }

    public String getName() {
        return name;
    }
}

