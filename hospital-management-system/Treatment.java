/**
 * Class representing a Medical Treatment.
 * Manages treatment lifecycle.
 */
public class Treatment {
    private String treatmentId;
    private String description;
    private String status; // Pending, In Progress, Completed

    public Treatment(String treatmentId, String description) {
        this.treatmentId = treatmentId;
        this.description = description;
        this.status = "Pending";
    }

    public String getTreatmentId() { return treatmentId; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId + " | Description: " + description + " | Status: " + status;
    }
}
