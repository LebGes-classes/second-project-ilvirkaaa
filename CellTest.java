package Project_1;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testCellCreation() {
        Cell cell = new Cell();
        assertTrue(cell.info().contains("Информация о ячейке"));
    }

    @Test
    void testAddAndRemoveProduct() throws Exception {
        Cell cell = new Cell();
        Product product = new Product("Test Product", 100);

        cell.addProduct(product);
        assertTrue(cell.info().contains("Test Product"));

        cell.removeProduct(product);
        assertFalse(cell.info().contains("Test Product"));

        cell.closeCell();
        new File("info.txt").delete();
    }

    @Test
    void testReplaceProduct() throws Exception {
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();
        Product product = new Product("Test Product", 100);

        cell1.addProduct(product);
        cell1.replaceProduct(product, cell2);

        assertFalse(cell1.info().contains("Test Product"));
        assertTrue(cell2.info().contains("Test Product"));

        cell1.closeCell();
        cell2.closeCell();
        new File("info.txt").delete();
    }

    @Test
    void testEmployerManagement() throws Exception {
        Cell cell = new Cell();
        Employer employer = new Employer("Test Employer");

        cell.addEmployer(employer);
        assertTrue(cell.info().contains("Test Employer"));

        Employer newEmployer = new Employer("New Employer");
        cell.changeEmployer(newEmployer);
        assertTrue(cell.info().contains("New Employer"));

        cell.removeEmployer();
        assertTrue(cell.info().contains("Нет ответственного работника"));

        cell.closeCell();
        new File("info.txt").delete();
    }
}