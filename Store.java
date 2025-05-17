package Project_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> products; // список товаров
    private double income = 0; // доход магазина

    private final PrintWriter writer;

    // создание магазина
    public Store() {
        this.products = new ArrayList<>();
        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true);
            writer.println("Магазин создан\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // закупка товара
    public void purchaseProduct(Product product, Cell cell) {
        products.add(product); // добавляем продукт
        cell.removeProduct(product); // удаляем из прошлой яйчейки
        writer.println(product.getName() + " закуплен\n");
    }

    // продажа товара
    public void sellProduct(Product product) {
        products.remove(product); // удаляем продукт
        writer.println(product.getName() + " продан\n");
        income += product.getPrice(); // увеличиваем доход магазина
    }

    // добавление товара в магазин
    public void addProduct(Product product) {
        products.add(product);
        writer.println(product.getName() + " добавлен в магазин\n");
    }

    // закрытие магазина
    public void closeStore() {
        writer.println("Магазин закрыт\n");
        writer.close();
    }

    // информация о магазине
    public void info() {
        writer.println("Информация о магазине:\n");
        for (Product product : products) {
            writer.println(product.getName());
        }
        writer.println("Доход магазина: " + income);
        writer.println();
    }

    // доход магазина
    public double getIncome() {
        return income;
    }

    public List<Product> getProducts() {
        return products;
    }
}
