package Project_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
    }

    @AfterEach
    void tearDown() throws IOException {
        warehouse.closeWarehouse();
        Files.deleteIfExists(Paths.get("info.txt"));
    }

    @Test
    void testAddCell() throws IOException {
        Cell cell = new Cell();
    }

    @Test
    void testCloseWarehouse() throws IOException {
        warehouse.closeWarehouse();
        String fileContent = Files.readString(Paths.get("info.txt"));
        assertTrue(fileContent.contains("Склад закрыт"));
    }
}