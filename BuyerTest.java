package Project_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {
    private Store store;
    private Buyer buyer;
    private Product product;

    @BeforeEach
    void setUp() {
        store = new Store();
        buyer = new Buyer("Test Buyer");
        product = new Product("Test Product", 100);
        store.addProduct(product);
    }

    @AfterEach
    void tearDown() {
        store.closeStore();
        new File("info.txt").delete();
    }

    @Test
    void testBuyProduct() {
        // Покупаем товар
        buyer.buyProduct(product, store);

        // Проверяем, что товар удалён из магазина
        assertFalse(store.getProducts().contains(product));
    }

    @Test
    void testReturnProduct() {
        // Возвращаем товар (в реальной системе нужно сначала купить)
        buyer.returnProduct(product, store);

        // Проверяем, что товар добавлен обратно в магазин
        assertTrue(store.getProducts().contains(product));
    }
}