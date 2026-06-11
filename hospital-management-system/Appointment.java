/**
 * Class representing an Appointment.
 * Demonstrates Composition (Appointment has a Patient and a Doctor).
 */
public class Appointment {
    private String appointmentId;
    private String date;
    private Patient patient;
    private Doctor doctor;

    public Appointment(String appointmentId, String date, Patient patient, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getAppointmentId() { return appointmentId; }
    public String getDate() { return date; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    @Override
    public String toString() {
        return "Appoint ID: " + appointmentId + " | Date: " + date + 
               " | Patient: " + patient.getName() + " | Doctor: " + doctor.getName();
    }
}
