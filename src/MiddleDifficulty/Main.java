package MiddleDifficulty;

public class Main {
    public static void main(String[] args) {
        String[] surnames = {"Александров", "Алексеев", "Борисов", "Иванов", "Владимиров", "Дмитриев", "Егоров", "Константинов", "Михайлов", "Петров"};
        String[] names = {"Александр", "Алексей", "Борис", "Иван", "Владимир", "Дмитрий", "Егор", "Константин", "Михаил", "Петр"};
        String[] midnames = {"Александрович", "Алексеевич", "Борисович", "Иванович", "Владимирович", "Дмитриевич", "Егорович", "Константинович",
                "Михайлович", "Петрович"};
        int l, n, m, d, s;
        Employee[] employee = new Employee[30];
        for (int i = 0; i < 30; i++) {                                              /* заполняем массив случайными значениями */
            l = (int) (Math.random() * 10);
            n = (int) (Math.random() * 10);
            m = (int) (Math.random() * 10);
            d = 1 + (int) (Math.random() * 5);
            s = 100_000 + (int) (Math.random() * 100_001);
            employee[i] = new Employee(surnames[l], names[n], midnames[m], d, s);
        }
        printListEmployee(employee);
        System.out.println();
        printLFullInfoEployee(employee, 3);
        System.out.println();
        indexingSalary(employee,-1, 3);                                    // всему 3 отделу понизили зарплату на 1%
        System.out.println();
        System.out.println("После индексации зарплаты:");
        printLFullInfoEployee(employee, 3);
        System.out.println();
        printLFullInfoEployee(employee);
        System.out.println();
        printCost(employee);
        System.out.println();
        printCost(employee, 3);
        System.out.println();
        System.out.println("Средний размер зарплаты:  " + calculationCost(employee) / employee[0].getSize());
        for (int i = 1; i < 6; i++) {
            printMiddleSalary(employee, i);
        }
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой в 3 отделе:");
        System.out.println(employee[findMinSalary(employee, 3) - 1]);
        System.out.println();
        System.out.println("Сотрудник с максимальной зарплатой в 5 отделе:");
        System.out.println(employee[findMaxSalary(employee, 5) - 1]);
        System.out.println();
        printLessFixedSalary(employee, 120_000);
        System.out.println();
        printLargerFixedSalary(employee, 180_000);
    }

    public static void printLFullInfoEployee(Employee[] employee) {
        System.out.println("Полная информация о сотрудниках:");
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            System.out.println(employee[i]);
        }
    }
    public static void printLFullInfoEployee(Employee[] employee, int dep) {
        int j = 1;
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            System.out.println("Полная информация о сотрудниках " + dep + " отдела:");
            int s = employee[0].getSize();
            for (int i = 0; i < s; i++) {
                if (employee[i].getDepartment() != dep) continue;
                System.out.print(j+". ФИО: "+employee[i].getName());
                System.out.println("    Зарплата:  " + employee[i].getSalary());
                j ++;
            }
        }
    }

    public static int calculationCost(Employee[] employee) {
        int s = employee[0].getSize();
        int sum = 0;
        for (int i = 0; i < s; i++) {
            sum += employee[i].getSalary();
        }
        return sum;
    }
    public static int calculationCost(Employee[] employee, int dep) {
        int s = employee[0].getSize();
        int sum = 0;
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            for (int i = 0; i < s; i++) {
                if (employee[i].getDepartment() != dep) continue;
                sum += employee[i].getSalary();
            }
        }
        return sum;
    }

    public static void printMiddleSalary(Employee[] employee, int dep) {
        int s = employee[0].getSize();
        int sum = 0;
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            for (int i = 0; i < s; i++) {
                if (employee[i].getDepartment() != dep) continue;
                sum++;
            }
            System.out.println("Средний размер зарплаты в "+dep+" отделе:  " + calculationCost(employee, dep) / sum);
        }
    }

    public static void  printCost(Employee[] employee) {
        System.out.println("Затраты за месяц на выплату зарплат: " + calculationCost(employee));
    }
    public static void  printCost(Employee[] employee, int dep) {
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            System.out.println("Затраты за месяц на выплату зарплат " + dep + " отделу: " + calculationCost(employee, dep));
        }
    }

    public static void indexingSalary(Employee[] employee, int percent) {
        int sal;
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            sal = employee[i].getSalary()*(100+percent)/100;
            employee[i].setSalary(sal);
        }
    }

    public static void indexingSalary(Employee[] employee, int percent, int dep) {
        int sal;
        int s = employee[0].getSize();
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            for (int i = 0; i < s; i++) {
                if (employee[i].getDepartment() != dep) continue;
                sal = employee[i].getSalary() * (100 + percent) / 100;
                employee[i].setSalary(sal);
            }
        }
    }

    public static int findMinSalary(Employee[] employee) {
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

    public static int findMinSalary(Employee[] employee, int dep) {
        int s = employee[0].getSize();
        int min = 200_000;
        int id = 0;
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            for (int i = 0; i < s; i++) {
                if (employee[i].getDepartment() != dep) continue;
                if (employee[i].getSalary() < min) {
                    min = employee[i].getSalary();
                    id = i + 1;
                }
            }
        }
        return id;
    }

    public static int findMaxSalary(Employee[] employee) {
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

    public static int findMaxSalary(Employee[] employee, int dep) {
        int s = employee[0].getSize();
        int max = 0;
        int id = 0;
        if (dep <= 0 || dep > 5) {
            System.out.println("Допустимые значения номера отдела 1, 2, 3, 4, 5. ОШИБОЧКА вышла.");
        } else {
            for (int i = 0; i < s; i++) {
                if (employee[i].getDepartment() != dep) continue;
                if (employee[i].getSalary() > max) {
                    max = employee[i].getSalary();
                    id = i + 1;
                }
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
    public static void printLessFixedSalary(Employee[] employee, int sal) {
        System.out.println("Список сотрудников с уровнем зарплаты меньше "+sal +" :");
        int j = 1;
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            if (employee[i].getSalary() >= sal) continue;
            System.out.println(j+". "+employee[i].getName()+" Отдел: "+employee[i].getDepartment() +" Зарплата; "+employee[i].getSalary());
            j++;
        }
    }
    public static void printLargerFixedSalary(Employee[] employee, int sal) {
        System.out.println("Список сотрудников с уровнем зарплаты более "+sal +" :");
        int j = 1;
        int s = employee[0].getSize();
        for (int i = 0; i < s; i++) {
            if (employee[i].getSalary() < sal) continue;
            System.out.println(j+". "+employee[i].getName()+" Отдел: "+employee[i].getDepartment() +" Зарплата; "+employee[i].getSalary());
            j++;
        }
    }

}
