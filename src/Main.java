public class Main {
    public static void main(String[] args) {

        Employee[] employeeList = new Employee[10];

        employeeList[0] = new Employee("Лев Николаевич Мышкин", 1, 12345.50);
        employeeList[1] = new Employee("Настасья Филипповна Барашкова ", 4, 6676.66);
        employeeList[2] = new Employee("Парфён Семёнович Рогожин", 2, 5555.55);
        employeeList[3] = new Employee("Гаврила Ардалионович Иволгин", 5, 4444.40);
        employeeList[4] = new Employee("Аглая Ивановна Епанчина", 4, 1234.50);
        employeeList[5] = new Employee("Афанасий Иванович Тоцкий", 3, 1000000.00);

        printEmployeesInfo(employeeList);

        System.out.println("Суммарная зарплата: " + totalWages(employeeList));
        System.out.printf("Средняя зарплата: %.2f\n", averageWages(employeeList));

        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeMinWages(employeeList));
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeMaxWages(employeeList));

        printEmployeesNames(employeeList);

    }

    public static void printEmployeesInfo(Employee[] employeeList) {
        for (int i = 0; i < Employee.idCounter; i++) {
            System.out.println(employeeList[i].toString());
        }
    }

    public static void printEmployeesNames(Employee[] employeeList) {
        for (int i = 0; i < Employee.idCounter; i++) {
            System.out.println(employeeList[i].getName());
        }
    }

    public static double totalWages(Employee[] employeeList) {

        double summ = 0.0;

        for (int i = 0; i < Employee.idCounter; i++) {
            summ += employeeList[i].getWages();
        }

        return summ;
    }

    public static double averageWages(Employee[] employeeList) {

        return totalWages(employeeList) / (Employee.idCounter);

    }

    public static String findEmployeeMinWages(Employee[] employeeList) {

        String employeeMinWages = employeeList[0].getName();
        double minWages = employeeList[0].getWages();

        for (int i = 1; i < Employee.idCounter; i++) {
            if (employeeList[i].getWages() < minWages) {
                employeeMinWages = employeeList[i].getName();
                minWages = employeeList[i].getWages();
            }
        }

        return employeeMinWages;
    }    
    
    public static String findEmployeeMaxWages(Employee[] employeeList) {

        String employeeMaxWages = employeeList[0].getName();
        double MaxWages = employeeList[0].getWages();

        for (int i = 1; i < Employee.idCounter; i++) {
            if (employeeList[i].getWages() > MaxWages) {
                employeeMaxWages = employeeList[i].getName();
                MaxWages = employeeList[i].getWages();
            }
        }

        return employeeMaxWages;
    }

}