
# Prescription Management Project

This project is a simple Java application to manage prescriptions and remarks. It allows users to add prescription information, validate the input, and store the data in text files. The application also supports adding remarks to the prescriptions, which are subject to validation.

## Features

- **Add a Prescription**: Prescriptions are added and validated based on predefined conditions such as length of the name, address, and values for sphere, cylinder, and axis.
- **Add Remarks**: Each prescription can have a maximum of two remarks (either from a client or an optometrist). Remarks are stored in a text file and validated before adding.
- **Validation**: Both prescriptions and remarks are validated according to strict conditions to ensure valid data entry.
  
## Project Structure

```
/PrescriptionProject
    ├── src
    │   ├── Prescription.java      # Main Java class for managing prescriptions and remarks
    │   ├── PrescriptionTest.java  # Unit tests for Prescription class 
    ├── presc.txt                  # Automatically generated file storing prescription data
    ├── remark.txt                 # Automatically generated file storing remarks
    ├── README.md                  # Project documentation (this file)
    └── .gitignore                 # Git ignore file (optional)
```

### Key Files:
- **`Prescription.java`**: Contains the logic for adding and validating prescriptions and remarks.
- **`presc.txt`**: Stores all valid prescriptions.
- **`remark.txt`**: Stores all valid remarks related to prescriptions.
- **`PrescriptionTest.java`**: JUnit tests for validating the functionality of the `Prescription.java` class.

## How to Run the Project

1. **Clone or Download the Project**:
   - Clone the repository or download the project folder to your local machine.

2. **Compile and Run the Project**:
   - Open the project in IntelliJ IDEA (or your preferred Java IDE).
   - Run the `Prescription.java` file's `main()` method to test adding a prescription and remarks.

3. **Files Generated**:
   - After running, you will find two new files generated:
     - `presc.txt`: Contains the prescription data.
     - `remark.txt`: Contains the remarks for the prescriptions.
   
## Example Usage

Here’s a sample of how you can use the application in `main()`:

```java
Prescription presc = new Prescription(1, "John", "DoeSmith", 
                                      "1234 Elm Street, Suburb, Country", 
                                      2.0f, -1.0f, 90, new Date(), 
                                      "Dr. Smith");

boolean result = presc.addPrescription();
System.out.println("Prescription added: " + result);

result = presc.addRemark("This is a valid remark from client.", "client");
System.out.println("Remark added: " + result);

result = presc.addRemark("Another valid remark from optometrist.", "optometrist");
System.out.println("Remark added: " + result);
```

## Requirements

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA (or any Java IDE)
- JUnit 5 (for unit testing)

## Running Unit Tests

You can run the unit tests located in `PrescriptionTest.java` to verify the functionality of the prescription and remark validation:

1. Right-click on `PrescriptionTest.java`.
2. Select **Run 'PrescriptionTest'**.
3. The tests will run, and the results will be displayed in the console.


