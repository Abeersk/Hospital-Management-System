/**
 * Class representing a Nurse.
 * Extends Staff (Inheritance).
 */
public class Nurse extends Staff {
    private int shiftHours;

    public Nurse(String id, String name, int age, String gender, String department, double salary, int shiftHours) {
        super(id, name, age, gender, department, salary);
        this.shiftHours = shiftHours;
    }

    public int getShiftHours() { return shiftHours; }
    public void setShiftHours(int shiftHours) { this.shiftHours = shiftHours; }

    @Override
    public void displayInfo() {
        System.out.println("----- Nurse Details -----");
        System.out.println(this.toString());
        System.out.println("Shift Hours: " + shiftHours);
    }
}
