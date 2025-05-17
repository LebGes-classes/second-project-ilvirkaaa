package Project_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Cell {

    private final List<Product> products; // список продуктов в ячейке
    private Employer employer; // работник, ответственный за ячейку

    private final PrintWriter writer;

    // создание ячейки
    public Cell() {
        this.products = new ArrayList<>(); // создание пустого списка продуктов
        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true); // запись в файл
            writer.println("Ячейка создана\n"); //
        } catch (IOException e) { // вывод ошибки
            throw new RuntimeException(e);
        }
    }

    // добавление продукта в ячейку
    public void addProduct(Product product) {
        products.add(product);
        writer.println(product.getName() + " добавлен в ячейку\n");
    }


    // удаление продукта из ячейки
    public void removeProduct(Product product) {
        products.remove(product);
        writer.println(product.getName() + " удален из ячейки\n");
    }

    // перемещение товаров
    public void replaceProduct(Product product, Cell newCell) {
        if (products.contains(product)) { // если есть
            products.remove(product); // удаляем
            newCell.addProduct(product); // добавляеи в новое место
            writer.println(product.getName() + " перемещен в другую ячейку\n");
        }
    }

    // найм сотрудника
    public void addEmployer(Employer employer) {
        this.employer = employer;
        writer.println("Работник " + employer.getName() + " назначен на ячейку\n");
    }

    // смена ответственного лица
    public void changeEmployer(Employer newEmployer) {
        writer.println("Работник " + this.employer.getName() + " заменен на " + newEmployer.getName() + "");
        this.employer = newEmployer;
    }

    // увольнение работника
    public void removeEmployer() {
        writer.println("Работник " + this.employer.getName() + " уволен\n");
        this.employer = null;
    }

    // закрытие ячейки
    public void closeCell() {
        writer.println("Ячейка закрыта\n");
        writer.close();
    }

    // информация о ячейке
    public String info() {
        StringBuilder info = new StringBuilder("Информация о ячейке:\n");
        info.append("Продукты в ячейке:\n");
        for (Product product : products) {
            info.append(product.getName()).append("\n");
        }
        if (employer != null) {
            info.append("Ответственный работник: \n").append(employer.getName()).append("\n");
        } else {
            info.append("Нет ответственного работника\n");
        }
        return info.toString();
    }
}
