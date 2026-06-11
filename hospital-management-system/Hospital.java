import java.util.*;

/**
 * Main management class for the Hospital.
 * Demonstrates Aggregation (Hospital HAS-A list of Patients/Staff).
 */
public class Hospital {
    private String hospitalName;
    private Map<String, Patient> patients;
    private Map<String, Staff> staff;
    private List<Appointment> appointments;
    private List<Treatment> treatments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.patients = new HashMap<>();
        this.staff = new HashMap<>();
        this.appointments = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    // Patient Management
    public void addPatient(Patient p) { patients.put(p.getId(), p); }
    public Patient findPatient(String id) { return patients.get(id); }
    public Collection<Patient> getAllPatients() { return patients.values(); }

    // Staff Management
    public void addStaff(Staff s) { staff.put(s.getId(), s); }
    public Staff findStaff(String id) { return staff.get(id); }
    public Collection<Staff> getAllStaff() { return staff.values(); }

    // Appointment Management
    public void scheduleAppointment(Appointment a) { appointments.add(a); }
    public List<Appointment> getAppointments() { return appointments; }

    // Treatment Management
    public void addTreatment(Treatment t) { treatments.add(t); }
    public List<Treatment> getTreatments() { return treatments; }

    public String getHospitalName() { return hospitalName; }
}
