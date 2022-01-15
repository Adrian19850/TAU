import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    @BeforeAll
    public void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFirstName() {
        new ().setId(1L).setLastName("Adams").setFirstName("Jill")
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getPhoneNumber() {
    }

    @Test
    void setPhoneNumber() {
    }

    @Test
    void validateFirstName() {
    }

    @Test
    void validateLastName() {
    }

    @Test
    void validatePhoneNumber() {
    }
}
