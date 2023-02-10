package MiddleDifficulty;

import BaseDifficulty.Employee;

public class Main {
    public static void main(String[] args) {
        String[] surnames = {"Александров", "Алексеев", "Борисов", "Иванов", "Владимиров", "Дмитриев", "Егоров", "Константинов", "Михайлов", "Петров"};
        String[] names = {"Александр", "Алексей", "Борис", "Иван", "Владимир", "Дмитрий", "Егор", "Константин", "Михаил", "Петр"};
        String[] midnames = {"Александрович", "Алексеевич", "Борисович", "Иванович", "Владимирович", "Дмитриевич", "Егорович", "Константинович",
                "Михайлович", "Петрович"};
        int l, n, m, d, s, id;
        BaseDifficulty.Employee[] employee = new BaseDifficulty.Employee[30];       /* увеличим массив 30 */
        for (int i = 0; i < 30; i++) {                                              /* заполняем массив случайными значениями */
            l = (int) (Math.random() * 10);
            n = (int) (Math.random() * 10);
            m = (int) (Math.random() * 10);
            d = 1 + (int) (Math.random() * 5);
            s = 100_000 + (int) (Math.random() * 100_001);
            employee[i] = new BaseDifficulty.Employee(surnames[l], names[n], midnames[m], d, s);
        }
        printListEmployee(employee);
        printLFullInfoEployee(employee);
        s = calculationCost(employee);
        System.out.println("Затраты за месяц на выплату зарплат: " + s);
        System.out.println("Средний размер зарплаты:  " + s / employee[0].getSize());
        System.out.println("Сотрудник с минимальной зарплатой:");
        id = findMinSalary(employee);
        System.out.println(employee[id - 1]);
        s = employee[id - 1].getSalary();
        employee[id - 1].setSalary(s + 20_000);       /*   повышаем зарплату на 20 000 рублей  */
        System.out.println("После повышения зарплаты на 20 000 рублей:");
        System.out.println(employee[id - 1]);
        System.out.println("Сотрудник с максимальной зарплатой:");
        System.out.println(employee[findMaxSalary(employee) - 1]);
    }

    public static void printLFullInfoEployee(BaseDifficulty.Employee[] employee) {
        System.out.println("Полная информация о сотрудниках:");
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            System.out.println(employee[i]);
        }
    }

    public static int calculationCost(BaseDifficulty.Employee[] employee) {
        int s = employee[0].getSize();
        int sum = 0;
        for (int i = 0; i < s; i++) {
            sum += employee[i].getSalary();
        }
        return sum;
    }

    public static int findMinSalary(BaseDifficulty.Employee[] employee) {
        int s = employee[0].getSize();
        int min = 200_000;
        int id = 0;
        for (int i = 0; i < s; i++) {
            if (employee[i].getSalary() < min) {
                min = employee[i].getSalary();
                id = i + 1;
            }
        }
        return id;
    }

    public static int findMaxSalary(BaseDifficulty.Employee[] employee) {
        int s = employee[0].getSize();
        int max = 0;
        int id = 0;
        for (int i = 0; i < s; i++) {
            if (employee[i].getSalary() > max) {
                max = employee[i].getSalary();
                id = i + 1;
            }
        }
        return id;
    }

    public static void printListEmployee(Employee[] employee) {
        System.out.println("Список сотрудников:");
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            System.out.println(employee[i].getId() + ". " + employee[i].getName());
        }

    }
}
