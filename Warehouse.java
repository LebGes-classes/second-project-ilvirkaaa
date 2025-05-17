package Project_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private final List<Cell> cells; // список ячеек склада
    private final PrintWriter writer;

    // создание склада
    public Warehouse() {
        this.cells = new ArrayList<>();
        try {
            writer = new PrintWriter(new FileWriter("info.txt", true), true); // запись в файл
            writer.println("Склад создан\n");
        } catch (IOException e) { // вывод ошибки
            throw new RuntimeException(e);
        }
    }

    // закрытие склада
    public void closeWarehouse() {
        writer.println("Склад закрыт\n");
        writer.close();
    }

    // информация о складе
    public void info() {
        writer.println("Информация о складе:\n");
        for (Cell cell : cells) { // проходим по каждой яйцейке и выводим инфу
            writer.println(cell.info() + "\n\n");
        }
    }

    public void addCell(Cell cell) { // метод добавления яйчеек
        cells.add(cell);
        writer.println("Ячейка добавлена на склад\n");
    }

    public List<Cell> getCells() { // метод получения яйчеек для тестов
        return cells;
    }
}

