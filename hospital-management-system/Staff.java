/**
 * Abstract class representing Hospital Staff.
 * Extends Person (Inheritance).
 */
public abstract class Staff extends Person {
    private String department;
    private double salary;

    public Staff(String id, String name, int age, String gender, String department, double salary) {
        super(id, name, age, gender);
        this.department = department;
        this.salary = salary;
    }

    // Encapsulation
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return super.toString() + ", Dept: " + department + ", Salary: " + salary;
    }
}
