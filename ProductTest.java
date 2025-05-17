package Project_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductCreation() {
        Product product = new Product("Test Product", 100);
        assertEquals("Test Product", product.getName());
        assertEquals(100, product.getPrice());
    }
}