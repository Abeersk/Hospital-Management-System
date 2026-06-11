/**
 * Class representing a Technician.
 * Extends Staff (Inheritance).
 */
public class Technician extends Staff {
    private String equipmentExpertise;

    public Technician(String id, String name, int age, String gender, String department, double salary, String equipmentExpertise) {
        super(id, name, age, gender, department, salary);
        this.equipmentExpertise = equipmentExpertise;
    }

    public String getEquipmentExpertise() { return equipmentExpertise; }
    public void setEquipmentExpertise(String equipmentExpertise) { this.equipmentExpertise = equipmentExpertise; }

    @Override
    public void displayInfo() {
        System.out.println("----- Technician Details -----");
        System.out.println(this.toString());
        System.out.println("Expertise: " + equipmentExpertise);
    }
}
