package Project_1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<Warehouse> warehouses = new ArrayList<>();
    private static List<Store> stores = new ArrayList<>();
    private static List<Employer> employers = new ArrayList<>();
    private static List<Product> availableProducts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Инициализация некоторых тестовых данных
        availableProducts.add(new Product("Хлеб", 50));
        availableProducts.add(new Product("Молоко", 80));
        availableProducts.add(new Product("Яйца", 120));
        availableProducts.add(new Product("Сахар", 60));

        employers.add(new Employer("Иванов Иван"));
        employers.add(new Employer("Петров Петр"));

        System.out.println("Система управления складом и магазинами");

        while (true) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageWarehouses();
                    break;
                case 2:
                    manageStores();
                    break;
                case 3:
                    manageEmployers();
                    break;
                case 4:
                    manageProducts();
                    break;
                case 5:
                    System.out.println("Выход из системы");
                    // Закрываем все ресурсы перед выходом
                    for (Warehouse w : warehouses) w.closeWarehouse();
                    for (Store s : stores) s.closeStore();
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Управление складами");
        System.out.println("2. Управление магазинами");
        System.out.println("3. Управление сотрудниками");
        System.out.println("4. Управление товарами");
        System.out.println("5. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void manageWarehouses() {
        while (true) {
            System.out.println("\nУправление складами:");
            System.out.println("1. Открыть новый склад");
            System.out.println("2. Закрыть склад");
            System.out.println("3. Добавить ячейку на склад");
            System.out.println("4. Просмотреть информацию о складе");
            System.out.println("5. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Warehouse warehouse = new Warehouse();
                    warehouses.add(warehouse);
                    System.out.println("Новый склад создан. ID: " + (warehouses.size() - 1));
                    break;
                case 2:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада для закрытия: ");
                    int id = scanner.nextInt();
                    if (id >= 0 && id < warehouses.size()) {
                        warehouses.get(id).closeWarehouse();
                        warehouses.remove(id);
                        System.out.println("Склад закрыт");
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 3:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < warehouses.size()) {
                        Cell cell = new Cell();
                        // В классе Warehouse нужно добавить метод addCell для добавления ячеек
                        // Например: warehouses.get(id).addCell(cell);
                        System.out.println("Ячейка добавлена на склад");
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 4:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < warehouses.size()) {
                        warehouses.get(id).info();
                        System.out.println("Информация записана в файл info.txt");
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    private static void manageStores() {
        while (true) {
            System.out.println("\nУправление магазинами:");
            System.out.println("1. Открыть новый магазин");
            System.out.println("2. Закрыть магазин");
            System.out.println("3. Просмотреть информацию о магазине");
            System.out.println("4. Продать товар");
            System.out.println("5. Вернуть товар");
            System.out.println("6. Закупить товар со склада");
            System.out.println("7. Просмотреть доходность магазина");
            System.out.println("8. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Store store = new Store();
                    stores.add(store);
                    System.out.println("Новый магазин создан. ID: " + (stores.size() - 1));
                    break;
                case 2:
                    if (stores.isEmpty()) {
                        System.out.println("Нет доступных магазинов");
                        break;
                    }
                    System.out.print("Введите ID магазина для закрытия: ");
                    int id = scanner.nextInt();
                    if (id >= 0 && id < stores.size()) {
                        stores.get(id).closeStore();
                        stores.remove(id);
                        System.out.println("Магазин закрыт");
                    } else {
                        System.out.println("Неверный ID магазина");
                    }
                    break;
                case 3:
                    if (stores.isEmpty()) {
                        System.out.println("Нет доступных магазинов");
                        break;
                    }
                    System.out.print("Введите ID магазина: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < stores.size()) {
                        stores.get(id).info();
                        System.out.println("Информация записана в файл info.txt");
                    } else {
                        System.out.println("Неверный ID магазина");
                    }
                    break;
                case 4:
                    if (stores.isEmpty()) {
                        System.out.println("Нет доступных магазинов");
                        break;
                    }
                    System.out.print("Введите ID магазина: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < stores.size()) {
                        sellProduct(stores.get(id));
                    } else {
                        System.out.println("Неверный ID магазина");
                    }
                    break;
                case 5:
                    if (stores.isEmpty()) {
                        System.out.println("Нет доступных магазинов");
                        break;
                    }
                    System.out.print("Введите ID магазина: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < stores.size()) {
                        returnProduct(stores.get(id));
                    } else {
                        System.out.println("Неверный ID магазина");
                    }
                    break;
                case 6:
                    if (stores.isEmpty()) {
                        System.out.println("Нет доступных магазинов");
                        break;
                    }
                    System.out.print("Введите ID магазина: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < stores.size()) {
                        purchaseProductFromWarehouse(stores.get(id));
                    } else {
                        System.out.println("Неверный ID магазина");
                    }
                    break;
                case 7:
                    if (stores.isEmpty()) {
                        System.out.println("Нет доступных магазинов");
                        break;
                    }
                    System.out.print("Введите ID магазина: ");
                    id = scanner.nextInt();
                    if (id >= 0 && id < stores.size()) {
                        System.out.println("Доход магазина: " + stores.get(id).getIncome());
                    } else {
                        System.out.println("Неверный ID магазина");
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    private static void sellProduct(Store store) {
        if (store.getProducts().isEmpty()) {
            System.out.println("В магазине нет товаров для продажи");
            return;
        }

        System.out.println("Товары в магазине:");
        List<Product> storeProducts = store.getProducts();
        for (int i = 0; i < storeProducts.size(); i++) {
            System.out.println(i + ". " + storeProducts.get(i).getName() + " - " + storeProducts.get(i).getPrice() + " руб.");
        }

        System.out.print("Выберите товар для продажи: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        if (productId >= 0 && productId < storeProducts.size()) {
            Product product = storeProducts.get(productId);
            System.out.print("Введите имя покупателя: ");
            String buyerName = scanner.nextLine();
            Buyer buyer = new Buyer(buyerName);
            buyer.buyProduct(product, store);
            System.out.println("Товар продан");
        } else {
            System.out.println("Неверный ID товара");
        }
    }

    private static void returnProduct(Store store) {
        System.out.print("Введите имя покупателя: ");
        String buyerName = scanner.nextLine();
        Buyer buyer = new Buyer(buyerName);

        System.out.print("Введите название возвращаемого товара: ");
        String productName = scanner.nextLine();

        // В реальной системе нужно было бы хранить информацию о покупках
        // Здесь для простоты создаем новый товар с таким же именем
        Product product = new Product(productName, 0); // Цена не важна для возврата

        buyer.returnProduct(product, store);
        System.out.println("Товар возвращен в магазин");
    }

    private static void purchaseProductFromWarehouse(Store store) {
        if (warehouses.isEmpty()) {
            System.out.println("Нет доступных складов");
            return;
        }

        System.out.print("Введите ID склада: ");
        int warehouseId = scanner.nextInt();
        if (warehouseId < 0 || warehouseId >= warehouses.size()) {
            System.out.println("Неверный ID склада");
            return;
        }

        // Здесь нужно получить список ячеек на складе
        // Предположим, что у Warehouse есть метод getCells()
        // List<Cell> cells = warehouses.get(warehouseId).getCells();

        System.out.println("Ячейки на складе:");
        // for (int i = 0; i < cells.size(); i++) {
        //     System.out.println(i + ". Ячейка " + i + ": " + cells.get(i).info());
        // }

        System.out.print("Введите ID ячейки: ");
        int cellId = scanner.nextInt();
        scanner.nextLine();

        // if (cellId < 0 || cellId >= cells.size()) {
        //     System.out.println("Неверный ID ячейки");
        //     return;
        // }

        // Cell cell = cells.get(cellId);
        Cell cell = new Cell(); // Временная заглушка

        if (cell.info().contains("Нет продуктов")) {
            System.out.println("В ячейке нет товаров");
            return;
        }

        System.out.println("Товары в ячейке:");
        // Здесь нужно получить продукты из ячейки
        // List<Product> cellProducts = cell.getProducts();
        // for (int i = 0; i < cellProducts.size(); i++) {
        //     System.out.println(i + ". " + cellProducts.get(i).getName());
        // }

        System.out.print("Выберите товар для закупки: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        // if (productId >= 0 && productId < cellProducts.size()) {
        //     Product product = cellProducts.get(productId);
        //     store.purchaseProduct(product, cell);
        //     System.out.println("Товар закуплен в магазин");
        // } else {
        //     System.out.println("Неверный ID товара");
        // }

        // Временная реализация для демонстрации
        System.out.print("Введите название товара: ");
        String productName = scanner.nextLine();
        System.out.print("Введите цену товара: ");
        double price = scanner.nextDouble();
        Product product = new Product(productName, price);
        store.purchaseProduct(product, cell);
        System.out.println("Товар закуплен в магазин");
    }

    private static void manageEmployers() {
        while (true) {
            System.out.println("\nУправление сотрудниками:");
            System.out.println("1. Нанять сотрудника");
            System.out.println("2. Уволить сотрудника");
            System.out.println("3. Назначить сотрудника на ячейку");
            System.out.println("4. Сменить ответственного за ячейку");
            System.out.println("5. Уволить сотрудника с ячейки");
            System.out.println("6. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя нового сотрудника: ");
                    String name = scanner.nextLine();
                    employers.add(new Employer(name));
                    System.out.println("Сотрудник нанят. ID: " + (employers.size() - 1));
                    break;
                case 2:
                    if (employers.isEmpty()) {
                        System.out.println("Нет доступных сотрудников");
                        break;
                    }
                    System.out.print("Введите ID сотрудника для увольнения: ");
                    int id = scanner.nextInt();
                    if (id >= 0 && id < employers.size()) {
                        employers.remove(id);
                        System.out.println("Сотрудник уволен");
                    } else {
                        System.out.println("Неверный ID сотрудника");
                    }
                    break;
                case 3:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада: ");
                    int warehouseId = scanner.nextInt();
                    if (warehouseId >= 0 && warehouseId < warehouses.size()) {
                        if (employers.isEmpty()) {
                            System.out.println("Нет доступных сотрудников");
                            break;
                        }
                        System.out.print("Введите ID сотрудника: ");
                        int employerId = scanner.nextInt();
                        if (employerId >= 0 && employerId < employers.size()) {
                            Cell cell = new Cell();
                            cell.addEmployer(employers.get(employerId));
                            System.out.println("Сотрудник назначен на ячейку");
                        } else {
                            System.out.println("Неверный ID сотрудника");
                        }
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 4:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада: ");
                    warehouseId = scanner.nextInt();
                    if (warehouseId >= 0 && warehouseId < warehouses.size()) {
                        if (employers.size() < 2) {
                            System.out.println("Необходимо как минимум 2 сотрудника для замены");
                            break;
                        }
                        System.out.print("Введите ID текущего сотрудника: ");
                        int oldEmployerId = scanner.nextInt();
                        System.out.print("Введите ID нового сотрудника: ");
                        int newEmployerId = scanner.nextInt();

                        if (oldEmployerId >= 0 && oldEmployerId < employers.size() &&
                                newEmployerId >= 0 && newEmployerId < employers.size()) {
                            Cell cell = new Cell();
                            cell.addEmployer(employers.get(oldEmployerId));
                            cell.changeEmployer(employers.get(newEmployerId));
                            System.out.println("Ответственный за ячейку изменен");
                        } else {
                            System.out.println("Неверный ID сотрудника");
                        }
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 5:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада: ");
                    warehouseId = scanner.nextInt();
                    if (warehouseId >= 0 && warehouseId < warehouses.size()) {
                        Cell cell = new Cell();
                        if (cell.info().contains("Ответственный работник")) {
                            cell.removeEmployer();
                            System.out.println("Сотрудник уволен с ячейки");
                        } else {
                            System.out.println("На ячейке нет ответственного");
                        }
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }

    private static void manageProducts() {
        while (true) {
            System.out.println("\nУправление товарами:");
            System.out.println("1. Добавить новый товар");
            System.out.println("2. Удалить товар");
            System.out.println("3. Переместить товар между ячейками");
            System.out.println("4. Добавить товар в ячейку");
            System.out.println("5. Просмотреть доступные товары");
            System.out.println("6. Вернуться в главное меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название товара: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите цену товара: ");
                    double price = scanner.nextDouble();
                    availableProducts.add(new Product(name, price));
                    System.out.println("Товар добавлен. ID: " + (availableProducts.size() - 1));
                    break;
                case 2:
                    if (availableProducts.isEmpty()) {
                        System.out.println("Нет доступных товаров");
                        break;
                    }
                    System.out.print("Введите ID товара для удаления: ");
                    int id = scanner.nextInt();
                    if (id >= 0 && id < availableProducts.size()) {
                        availableProducts.remove(id);
                        System.out.println("Товар удален");
                    } else {
                        System.out.println("Неверный ID товара");
                    }
                    break;
                case 3:
                    if (warehouses.size() < 2) {
                        System.out.println("Необходимо как минимум 2 склада для перемещения");
                        break;
                    }
                    System.out.print("Введите ID исходного склада: ");
                    int fromWarehouseId = scanner.nextInt();
                    System.out.print("Введите ID целевого склада: ");
                    int toWarehouseId = scanner.nextInt();

                    if (fromWarehouseId >= 0 && fromWarehouseId < warehouses.size() &&
                            toWarehouseId >= 0 && toWarehouseId < warehouses.size()) {

                        // Получаем ячейки из складов
                        // List<Cell> fromCells = warehouses.get(fromWarehouseId).getCells();
                        // List<Cell> toCells = warehouses.get(toWarehouseId).getCells();

                        System.out.print("Введите ID исходной ячейки: ");
                        int fromCellId = scanner.nextInt();
                        System.out.print("Введите ID целевой ячейки: ");
                        int toCellId = scanner.nextInt();

                        // if (fromCellId >= 0 && fromCellId < fromCells.size() &&
                        //     toCellId >= 0 && toCellId < toCells.size()) {
                        //
                        //     Cell fromCell = fromCells.get(fromCellId);
                        //     Cell toCell = toCells.get(toCellId);
                        //
                        //     System.out.println("Товары в исходной ячейке:");
                        //     List<Product> products = fromCell.getProducts();
                        //     for (int i = 0; i < products.size(); i++) {
                        //         System.out.println(i + ". " + products.get(i).getName());
                        //     }
                        //
                        //     System.out.print("Выберите товар для перемещения: ");
                        //     int productId = scanner.nextInt();
                        //
                        //     if (productId >= 0 && productId < products.size()) {
                        //         Product product = products.get(productId);
                        //         fromCell.replaceProduct(product, toCell);
                        //         System.out.println("Товар перемещен");
                        //     } else {
                        //         System.out.println("Неверный ID товара");
                        //     }
                        // } else {
                        //     System.out.println("Неверные ID ячеек");
                        // }

                        // Временная реализация
                        System.out.print("Введите название товара: ");
                        String productName = scanner.nextLine();
                        Product product = new Product(productName, 0);
                        Cell fromCell = new Cell();
                        fromCell.addProduct(product);
                        Cell toCell = new Cell();
                        fromCell.replaceProduct(product, toCell);
                        System.out.println("Товар перемещен между ячейками");
                    } else {
                        System.out.println("Неверные ID складов");
                    }
                    break;
                case 4:
                    if (warehouses.isEmpty()) {
                        System.out.println("Нет доступных складов");
                        break;
                    }
                    System.out.print("Введите ID склада: ");
                    int warehouseId = scanner.nextInt();
                    if (warehouseId >= 0 && warehouseId < warehouses.size()) {
                        if (availableProducts.isEmpty()) {
                            System.out.println("Нет доступных товаров");
                            break;
                        }

                        System.out.println("Доступные товары:");
                        for (int i = 0; i < availableProducts.size(); i++) {
                            System.out.println(i + ". " + availableProducts.get(i).getName());
                        }

                        System.out.print("Выберите товар: ");
                        int productId = scanner.nextInt();
                        if (productId >= 0 && productId < availableProducts.size()) {
                            Product product = availableProducts.get(productId);
                            Cell cell = new Cell();
                            cell.addProduct(product);
                            System.out.println("Товар добавлен в ячейку");
                        } else {
                            System.out.println("Неверный ID товара");
                        }
                    } else {
                        System.out.println("Неверный ID склада");
                    }
                    break;
                case 5:
                    System.out.println("\nДоступные товары:");
                    for (int i = 0; i < availableProducts.size(); i++) {
                        System.out.println(i + ". " + availableProducts.get(i).getName() +
                                " - " + availableProducts.get(i).getPrice() + " руб.");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }
    }
}