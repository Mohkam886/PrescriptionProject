import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private float axis;
    private Date examinationDate;
    private String optometrist;
    private ArrayList<String> postRemarks;

    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address,
                        float sphere, float cylinder, float axis, Date examinationDate,
                        String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
        this.postRemarks = new ArrayList<>();
    }

    // Method to add prescription to presc.txt with print statements for debugging
    public boolean addPrescription() {
        if (firstName.length() >= 4 && firstName.length() <= 15) {
            System.out.println("First name validation passed.");
        } else {
            System.out.println("First name validation failed.");
            return false;
        }

        if (lastName.length() >= 4 && lastName.length() <= 15) {
            System.out.println("Last name validation passed.");
        } else {
            System.out.println("Last name validation failed.");
            return false;
        }

        if (address.length() >= 20) {
            System.out.println("Address validation passed.");
        } else {
            System.out.println("Address validation failed.");
            return false;
        }

        if (sphere >= -20.00 && sphere <= 20.00) {
            System.out.println("Sphere validation passed.");
        } else {
            System.out.println("Sphere validation failed.");
            return false;
        }

        if (cylinder >= -4.00 && cylinder <= 4.00) {
            System.out.println("Cylinder validation passed.");
        } else {
            System.out.println("Cylinder validation failed.");
            return false;
        }

        if (axis >= 0 && axis <= 180) {
            System.out.println("Axis validation passed.");
        } else {
            System.out.println("Axis validation failed.");
            return false;
        }

        if (optometrist.length() >= 8 && optometrist.length() <= 25) {
            System.out.println("Optometrist validation passed.");
        } else {
            System.out.println("Optometrist validation failed.");
            return false;
        }

        // Add to a TXT file
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            writer.write(toString() + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Method to add a remark to remark.txt
    public boolean addRemark(String remark, String remarkType) {
        if (remark.split(" ").length >= 6 && remark.split(" ").length <= 20 &&
                (remarkType.equalsIgnoreCase("client") || remarkType.equalsIgnoreCase("optometrist")) &&
                postRemarks.size() < 2) {

            // Add remark to a TXT file
            try (FileWriter writer = new FileWriter("remark.txt", true)) {
                writer.write(remarkType + ": " + remark + "\n");
                postRemarks.add(remark);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Prescription [ID: " + prescID + ", Name: " + firstName + " " + lastName +
                ", Address: " + address + ", Sphere: " + sphere +
                ", Cylinder: " + cylinder + ", Axis: " + axis +
                ", Exam Date: " + examinationDate + ", Optometrist: " + optometrist + "]";
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample prescription with a valid last name and add it
        Prescription presc = new Prescription(1, "John", "DoeSmith",  // Valid last name
                "1234 Elm Street, Suburb, Country",
                2.0f, -1.0f, 90, new Date(),
                "Dr. Smith");
        boolean result = presc.addPrescription();
        System.out.println("Prescription added: " + result);

        // Add a remark
        result = presc.addRemark("This is a valid remark from client.", "client");
        System.out.println("Remark added: " + result);

        result = presc.addRemark("Another valid remark from optometrist.", "optometrist");
        System.out.println("Remark added: " + result);

        // Try adding another remark (should fail because only 2 are allowed)
        result = presc.addRemark("This remark should fail", "client");
        System.out.println("Additional remark added: " + result);
    }
}
