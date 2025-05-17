package Project_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployerTest {

    @Test
    void testEmployerCreation() {
        Employer employer = new Employer("Test Employer");
        assertEquals("Test Employer", employer.getName());
    }
}