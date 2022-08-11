public class Main {
    public static void main(String[] args) {

        Employee[] employeeList = new Employee[10];

        employeeList[0] = new Employee("Лев Николаевич Мышкин", 1, 12345.50);
        employeeList[1] = new Employee("Настасья Филипповна Барашкова ", 4, 6676.66);
        employeeList[2] = new Employee("Парфён Семёнович Рогожин", 2, 5555.55);
        employeeList[3] = new Employee("Гаврила Ардалионович Иволгин", 3, 4444.40);
        employeeList[4] = new Employee("Аглая Ивановна Епанчина", 4, 1234.50);
        employeeList[5] = new Employee("Афанасий Иванович Тоцкий", 3, 1000000.00);

        printEmployeesInfo(employeeList);
        increaseAllWagesByDepartment(employeeList,3,-10.0);
        printEmployeesInfo(employeeList);

        printDepartmentInfo(employeeList,4);

        System.out.println(findEmployeeMinWagesInDepartment(employeeList,3));
        System.out.println(findEmployeeMinWagesInDepartment(employeeList,4));
        System.out.println(findEmployeeMaxWagesInDepartment(employeeList,4));

        System.out.println(totalWagesByDepartment(employeeList,4));
        System.out.println(averageWagesByDepartment(employeeList,4));

        printWhoseWageIsLower(employeeList,5000.0);
        printWhoseWageIsHigher(employeeList,5555.55);

    }

    public static void printEmployeesInfo(Employee[] employeeList) {
        for (int i = 0; i < Employee.idCounter; i++) {
            System.out.println(employeeList[i]);
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

    public static void increaseAllWages(Employee[] employeeList, double increment) {
        for (int i = 0; i < Employee.idCounter; i++) {
            employeeList[i].setWages(employeeList[i].getWages() * (1 + increment / 100.0));
        }
    }

    public static void printDepartmentInfo(Employee[] employeeList, int department) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (employeeList[i].getDepartment() == department) {
                System.out.println(employeeList[i].toStringWODepartment());
            }
        }
    }

    public static String findEmployeeMinWagesInDepartment(Employee[] employeeList, int department) {

        int counter;
        String employeeMinWages = "";
        double minWages = 0;

        for (counter = 0; counter < Employee.idCounter; counter++) {
            if (employeeList[counter].getDepartment() == department) {
                employeeMinWages = employeeList[counter].getName();
                minWages = employeeList[counter].getWages();
                break;
            }
        }

        if (counter < Employee.idCounter) {
            for (int i = counter + 1; i < Employee.idCounter; i++) {
                if (employeeList[i].getDepartment() == department && employeeList[i].getWages() < minWages) {
                    employeeMinWages = employeeList[i].getName();
                    minWages = employeeList[i].getWages();
                }
            }
            return employeeMinWages;
        } else {
            throw new IllegalArgumentException("Выбранный отдел пуст");
        }
    }    
    
    public static String findEmployeeMaxWagesInDepartment(Employee[] employeeList, int department) {

        int counter;
        String employeeMaxWages = "";
        double maxWages = 0;

        for (counter = 0; counter < Employee.idCounter; counter++) {
            if (employeeList[counter].getDepartment() == department) {
                employeeMaxWages = employeeList[counter].getName();
                maxWages = employeeList[counter].getWages();
                break;
            }
        }

        if (counter < Employee.idCounter) {
            for (int i = counter + 1; i < Employee.idCounter; i++) {
                if (employeeList[i].getDepartment() == department && employeeList[i].getWages() > maxWages) {
                    employeeMaxWages = employeeList[i].getName();
                    maxWages = employeeList[i].getWages();
                }
            }
            return employeeMaxWages;
        } else {
            throw new IllegalArgumentException("Выбранный отдел пуст");
        }
    }

    public static double totalWagesByDepartment(Employee[] employeeList, int department) {

        double summ = 0.0;

        for (int i = 0; i < Employee.idCounter; i++) {
            if (employeeList[i].getDepartment() == department) {
                summ += employeeList[i].getWages();
            }
        }

        return summ;
    }

    public static double averageWagesByDepartment(Employee[] employeeList, int department) {

        double summ = 0.0;
        int counter = 0;

        for (int i = 0; i < Employee.idCounter; i++) {
            if (employeeList[i].getDepartment() == department) {
                counter++;
                summ += employeeList[i].getWages();
            }
        }

        if (counter > 0) {
            return summ / counter;
        } else {
            throw new IllegalArgumentException("Выбранный отдел пуст");
        }
    }

    public static void increaseAllWagesByDepartment(Employee[] employeeList, int department, double increment) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (employeeList[i].getDepartment() == department) {
                employeeList[i].setWages(employeeList[i].getWages() * (1 + increment / 100.0));
            }
        }
    }

    public static void printWhoseWageIsLower(Employee[] employeeList, double wageLevel) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (employeeList[i].getWages() < wageLevel) {
                System.out.println(employeeList[i].toStringWODepartment());
            }
        }
    }

    public static void printWhoseWageIsHigher(Employee[] employeeList, double wageLevel) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (employeeList[i].getWages() >= wageLevel) {
                System.out.println(employeeList[i].toStringWODepartment());
            }
        }
    }
    
}