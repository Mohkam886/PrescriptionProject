import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class PrescriptionTest {

    private Prescription prescription;

    @BeforeEach
    public void setUp() {
        prescription = new Prescription(1, "John", "Doe",
                "1234 Elm Street, Suburb, Postcode, Country",
                2.0f, -1.0f, 90, new Date(),
                "Dr. Smith");
    }

    @Test
    public void testAddPrescriptionValid() {
        assertTrue(prescription.addPrescription());
    }

    @Test
    public void testAddPrescriptionInvalidName() {
        Prescription invalidPrescription = new Prescription(2, "Jo", "Smith",
                "123 Elm Street, Suburb, Postcode",
                2.0f, -1.0f, 90,
                new Date(),
                "Dr. Smith");
        assertFalse(invalidPrescription.addPrescription());
    }

    @Test
    public void testAddRemarkValid() {
        assertTrue(prescription.addRemark("This is a valid client remark.", "client"));
    }

    @Test
    public void testAddRemarkInvalidLength() {
        assertFalse(prescription.addRemark("Short", "client"));
    }

    @Test
    public void testAddRemarkInvalidType() {
        assertFalse(prescription.addRemark("This is a valid client remark.", "nurse"));
    }

    @Test
    public void testAddMultipleRemarks() {
        prescription.addRemark("First valid remark from client.", "client");
        prescription.addRemark("Second valid remark from optometrist.", "optometrist");
        assertFalse(prescription.addRemark("This remark should fail", "client"));
    }
}
