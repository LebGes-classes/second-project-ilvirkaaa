package Project_1;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void testStoreCreation() {
        Store store = new Store();
        assertTrue(store.getProducts().isEmpty());
        assertEquals(0, store.getIncome());
    }

    @Test
    void testPurchaseAndSellProduct() throws Exception {
        Store store = new Store();
        Cell cell = new Cell();
        Product product = new Product("Test Product", 100);

        cell.addProduct(product);
        store.purchaseProduct(product, cell);

        assertTrue(store.getProducts().contains(product));
        assertFalse(cell.info().contains("Test Product"));

        store.sellProduct(product);
        assertFalse(store.getProducts().contains(product));
        assertEquals(100, store.getIncome());

        // Clean up
        store.closeStore();
        cell.closeCell();
        new File("info.txt").delete();
    }

    @Test
    void testAddProduct() throws Exception {
        Store store = new Store();
        Product product = new Product("Test Product", 100);

        store.addProduct(product);
        assertTrue(store.getProducts().contains(product));

        // Clean up
        store.closeStore();
        new File("info.txt").delete();
    }
}
