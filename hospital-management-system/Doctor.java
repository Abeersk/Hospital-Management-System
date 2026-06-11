import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Doctor.
 * Extends Staff (Inheritance).
 */
public class Doctor extends Staff {
    private String specialization;
    private List<Patient> currentPatients;

    public Doctor(String id, String name, int age, String gender, String department, double salary, String specialization) {
        super(id, name, age, gender, department, salary);
        this.specialization = specialization;
        this.currentPatients = new ArrayList<>();
    }

    // Encapsulation
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public List<Patient> getCurrentPatients() { return currentPatients; }
    public void assignPatient(Patient patient) { this.currentPatients.add(patient); }

    @Override
    public void displayInfo() {
        System.out.println("----- Doctor Details -----");
        System.out.println(this.toString());
        System.out.println("Specialization: " + specialization);
        System.out.println("Patients count: " + currentPatients.size());
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization;
    }
}
