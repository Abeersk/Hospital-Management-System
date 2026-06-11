import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Patient.
 * Extends Person (Inheritance).
 */
public class Patient extends Person {
    private String ailment;
    private List<String> medicalHistory;
    private Doctor assignedDoctor;

    public Patient(String id, String name, int age, String gender, String ailment) {
        super(id, name, age, gender);
        this.ailment = ailment;
        this.medicalHistory = new ArrayList<>();
    }

    // Encapsulation
    public String getAilment() { return ailment; }
    public void setAilment(String ailment) { this.ailment = ailment; }

    public List<String> getMedicalHistory() { return medicalHistory; }
    public void addHistory(String entry) { this.medicalHistory.add(entry); }

    public Doctor getAssignedDoctor() { return assignedDoctor; }
    public void setAssignedDoctor(Doctor assignedDoctor) { this.assignedDoctor = assignedDoctor; }

    @Override
    public void displayInfo() {
        System.out.println("----- Patient Details -----");
        System.out.println(this.toString());
        System.out.println("Ailment: " + ailment);
        System.out.println("Assigned Doctor: " + (assignedDoctor != null ? assignedDoctor.getName() : "None"));
    }

    @Override
    public String toString() {
        return super.toString() + ", Ailment: " + ailment;
    }
}
