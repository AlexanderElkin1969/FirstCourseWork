import BaseDifficulty.Employee;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] =new Employee("Иванов", "Иван", "Иванович", 1, 100_000);
        System.out.println(employee[0]);
    }
}