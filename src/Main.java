import BaseDifficulty.Employee;

public class Main {
    public static void main(String[] args) {
        String[] surnames = {"Александров", "Алексеев", "Борисов", "Иванов", "Владимиров", "Дмитриев", "Егоров", "Константинов", "Михайлов", "Петров"};
        String[] names = {"Александр", "Алексей", "Борис", "Виктор", "Владимир", "Дмитрий", "Егор", "Константин", "Михаил", "Петр"};
        String[] midnames = {"Александрович", "Алексеевич", "Борисович", "Викторович", "Владимирович", "Дмитриевич", "Егорович", "Константинович",
                "Михайлович", "Петрович"};
        int l, n, m, d, s;
        Employee[] employee = new Employee[10];
        for (int i = 0; i < 10; i++) {
            l = (int) (Math.random() * 10);
            n = (int) (Math.random() * 10);
            m = (int) (Math.random() * 10);
            d = 1 + (int) (Math.random() * 5);
            s = 100_000 + (int) (Math.random() * 100_001);
            employee[i] = new Employee(surnames[l], names[n], midnames[m], d, s);
        }
        printLFullInfoEployee(employee);
        printListEmployee(employee);
    }
    public static void printLFullInfoEployee(Employee[] employee) {
        System.out.println("Полная информация о сотрудниках:");
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            System.out.println(employee[i]);
        }
    }
    public static void printListEmployee(Employee[] employee) {
        System.out.println("Список сотрудников:");
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            System.out.println(employee[i].getId() + ". " + employee[i].getName());
        }

    }
}
