package BaseDifficulty;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private int department;
    private int salary;
    private final int id;

    public static int size = 0;

    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        size++;
        this.id = size;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public String toString() {
        return id + ". ФИО: " + lastName + " " + firstName + " " + middleName + "  Отдел: " + department + "  Зарплата: " + salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName);
    }
}
