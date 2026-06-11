import java.util.Scanner;

/**
 * Entry point for the Hospital Management System.
 * Menu-driven interface demonstrating the complete workflow.
 */
public class Main {
    private static Hospital hospital = new Hospital("City General Hospital");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to " + hospital.getHospitalName());
        
        boolean exit = false;
        while (!exit) {
            showMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1": addPatient(); break;
                    case "2": addDoctor(); break;
                    case "3": addStaffOther(); break;
                    case "4": viewEntities(); break;
                    case "5": assignDoctor(); break;
                    case "6": createTreatment(); break;
                    case "7": updateTreatment(); break;
                    case "8": scheduleAppointment(); break;
                    case "9": searchPatient(); break;
                    case "10": FileManager.savePatients(hospital.getAllPatients()); break;
                    case "11": FileManager.loadPatients(hospital); break;
                    case "0": exit = true; break;
                    default: System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        System.out.println("Exiting system. Goodbye!");
    }

    private static void showMenu() {
        System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM MENU ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Add Nurse / Technician");
        System.out.println("4. View Patients / Doctors");
        System.out.println("5. Assign Doctor to Patient");
        System.out.println("6. Create Treatment");
        System.out.println("7. Start / Update / Complete Treatment");
        System.out.println("8. Schedule Appointment");
        System.out.println("9. Search Patient by ID");
        System.out.println("10. Save Patient Data to File");
        System.out.println("11. Load Patient Data from File");
        System.out.println("0. Exit");
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: "); String id = scanner.nextLine();
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Gender: "); String gender = scanner.nextLine();
        System.out.print("Enter Ailment: "); String ailment = scanner.nextLine();

        Patient p = new Patient(id, name, age, gender, ailment);
        hospital.addPatient(p);
        System.out.println("Patient added successfully!");
    }

    private static void addDoctor() {
        System.out.print("Enter Doctor ID: "); String id = scanner.nextLine();
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Gender: "); String gender = scanner.nextLine();
        System.out.print("Enter Dept: "); String dept = scanner.nextLine();
        System.out.print("Enter Salary: "); double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Specialization: "); String spec = scanner.nextLine();

        Doctor d = new Doctor(id, name, age, gender, dept, salary, spec);
        hospital.addStaff(d);
        System.out.println("Doctor added successfully!");
    }

    private static void addStaffOther() {
        System.out.println("1. Nurse | 2. Technician");
        String choice = scanner.nextLine();
        System.out.print("Enter ID: "); String id = scanner.nextLine();
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Age: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Gender: "); String gender = scanner.nextLine();
        System.out.print("Enter Dept: "); String dept = scanner.nextLine();
        System.out.print("Enter Salary: "); double salary = Double.parseDouble(scanner.nextLine());

        if (choice.equals("1")) {
            System.out.print("Enter Shift Hours: "); int hours = Integer.parseInt(scanner.nextLine());
            hospital.addStaff(new Nurse(id, name, age, gender, dept, salary, hours));
        } else {
            System.out.print("Enter Expertise: "); String exp = scanner.nextLine();
            hospital.addStaff(new Technician(id, name, age, gender, dept, salary, exp));
        }
        System.out.println("Staff added successfully!");
    }

    private static void viewEntities() {
        System.out.println("\n--- DOCTORS ---");
        for (Staff s : hospital.getAllStaff()) {
            if (s instanceof Doctor) s.displayInfo();
        }
        System.out.println("\n--- PATIENTS ---");
        for (Patient p : hospital.getAllPatients()) p.displayInfo();
    }

    private static void assignDoctor() {
        System.out.print("Enter Patient ID: "); String pId = scanner.nextLine();
        System.out.print("Enter Doctor ID: "); String dId = scanner.nextLine();

        Patient p = hospital.findPatient(pId);
        Staff s = hospital.findStaff(dId);

        if (p != null && s instanceof Doctor) {
            Doctor d = (Doctor) s;
            p.setAssignedDoctor(d);
            d.assignPatient(p);
            System.out.println("Doctor assigned successfully!");
        } else {
            System.out.println("Patient or Doctor not found!");
        }
    }

    private static void createTreatment() {
        System.out.print("Enter Treatment ID: "); String id = scanner.nextLine();
        System.out.print("Enter Description: "); String desc = scanner.nextLine();
        hospital.addTreatment(new Treatment(id, desc));
        System.out.println("Treatment created!");
    }

    private static void updateTreatment() {
        System.out.print("Enter Treatment ID: "); String id = scanner.nextLine();
        for (Treatment t : hospital.getTreatments()) {
            if (t.getTreatmentId().equals(id)) {
                System.out.println("Current Status: " + t.getStatus());
                System.out.print("Enter New Status (In Progress/Completed): ");
                t.setStatus(scanner.nextLine());
                System.out.println("Status updated!");
                return;
            }
        }
        System.out.println("Treatment not found!");
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Appt ID: "); String aId = scanner.nextLine();
        System.out.print("Enter Date (DD-MM-YYYY): "); String date = scanner.nextLine();
        System.out.print("Enter Patient ID: "); String pId = scanner.nextLine();
        System.out.print("Enter Doctor ID: "); String dId = scanner.nextLine();

        Patient p = hospital.findPatient(pId);
        Staff s = hospital.findStaff(dId);

        if (p != null && s instanceof Doctor) {
            hospital.scheduleAppointment(new Appointment(aId, date, p, (Doctor) s));
            System.out.println("Appointment scheduled!");
        } else {
            System.out.println("Patient or Doctor not found!");
        }
    }

    private static void searchPatient() {
        System.out.print("Enter Patient ID: "); String id = scanner.nextLine();
        Patient p = hospital.findPatient(id);
        if (p != null) p.displayInfo();
        else System.out.println("Patient not found!");
    }
}
