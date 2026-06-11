/**
 * Abstract class representing a generic Person.
 * Demonstrates Abstraction and Encapsulation.
 */
public abstract class Person implements Displayable {
    private String id;
    private String name;
    private int age;
    private String gender;

    public Person(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Encapsulation: Use of Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    @Override
    public abstract void displayInfo(); // Forced implementation in subclasses

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}
