import java.io.*;
import java.util.*;

/**
 * Utility class for File Handling.
 * Demonstrates basic File I/O in Java.
 */
public class FileManager {
    private static final String FILE_NAME = "patients_data.txt";

    public static void savePatients(Collection<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Patient p : patients) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getAge() + "," + p.getGender() + "," + p.getAilment());
                writer.newLine();
            }
            System.out.println("Patient data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving patient data: " + e.getMessage());
        }
    }

    public static void loadPatients(Hospital hospital) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Patient p = new Patient(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
                    hospital.addPatient(p);
                }
            }
            System.out.println("Patient data loaded successfully from " + FILE_NAME);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading patient data: " + e.getMessage());
        }
    }
}
