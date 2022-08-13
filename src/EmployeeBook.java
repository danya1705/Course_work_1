public class EmployeeBook {

    private Employee[] employeeList;

    public EmployeeBook(int employeeListSize) {
        this.employeeList = new Employee[employeeListSize];
    }

    public void addEmployeeToBook(String name, int department, double wages) {

        for (int i = 0; i <= Employee.idCounter; i++) {
            if (this.employeeList[i] == null) {
                this.employeeList[i] = new Employee(name, department, wages);
                break;
            }
        }
    }

    public void printEmployeeBook() {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null) {
                System.out.println(this.employeeList[i]);
            }
        }
    }

    public void printEmployeeBookNames() {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null) {
                System.out.println(this.employeeList[i].getName());
            }
        }
    }

    public void printEmployeeBookByDepartments() {
        for (int dep = 1; dep < 6; dep++) {
            System.out.println("Отдел №" + dep);
            for (int i = 0; i < Employee.idCounter; i++) {
                if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == dep) {
                    System.out.println(this.employeeList[i].toStringWODepartment());
                }
            }
        }
    }

    public void printDepartmentInfo(int department) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department) {
                System.out.println(this.employeeList[i].toStringWODepartment());
            }
        }
    }

    public void removeEmployeeFromBook(int id) {

        int i;

        for (i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getId() == id) {
                this.employeeList[i] = null;
                break;
            }
        }

        if (i == Employee.idCounter) {
            System.out.println("Работник с id=" + id + " в компании не числится");
        }
    }

    public void changeEmployeeDepartment(String name, int department) {

        if (department > 0 && department < 6) {

            int i;

            for (i = 0; i < Employee.idCounter; i++) {
                if (this.employeeList[i] != null && this.employeeList[i].getName().equals(name)) {
                    this.employeeList[i].setDepartment(department);
                    break;
                }
            }

            if (i == Employee.idCounter) {
                System.out.println("Работник с именем " + name + " в компании не числится");
            }

        } else {
            throw new IllegalArgumentException("Не корректный номер отдела (должен быть от 1 до 5)");
        }
    }

    public void changeEmployeeWage(String name, double wage) {

        if (wage >= 0.0) {
            int i;

            for (i = 0; i < Employee.idCounter; i++) {
                if (this.employeeList[i] != null && this.employeeList[i].getName().equals(name)) {
                    this.employeeList[i].setWages(wage);
                    break;
                }
            }

            if (i == Employee.idCounter) {
                System.out.println("Работник с именем " + name + " в компании не числится");
            }
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
    }

    public double totalWages() {

        double summ = 0.0;

        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null) {
                summ += this.employeeList[i].getWages();
            }
        }

        return summ;
    }

    public double totalWagesByDepartment(int department) {

        double summ = 0.0;

        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department) {
                summ += this.employeeList[i].getWages();
            }
        }

        return summ;
    }

    public double averageWages() {

        double summ = 0.0;
        int counter = 0;

        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null) {
                counter++;
                summ += this.employeeList[i].getWages();
            }
        }

        if (counter > 0) {
            return summ / counter;
        } else {
            throw new IllegalArgumentException("Список работников пуст");
        }

    }

    public double averageWagesByDepartment(int department) {

        double summ = 0.0;
        int counter = 0;

        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department) {
                counter++;
                summ += this.employeeList[i].getWages();
            }
        }

        if (counter > 0) {
            return summ / counter;
        } else {
            throw new IllegalArgumentException("Выбранный отдел пуст");
        }
    }

    public String findEmployeeMinWages() {

        int startPoint = firstNonNullRecord();
        String employeeMinWages = this.employeeList[startPoint].getName();
        double minWages = this.employeeList[startPoint].getWages();

        for (int i = startPoint + 1; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getWages() < minWages) {
                employeeMinWages = this.employeeList[i].getName();
                minWages = this.employeeList[i].getWages();
            }
        }

        return employeeMinWages;
    }

    public String findEmployeeMaxWages() {

        int startPoint = firstNonNullRecord();
        String employeeMaxWages = this.employeeList[startPoint].getName();
        double maxWages = this.employeeList[startPoint].getWages();

        for (int i = startPoint + 1; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getWages() > maxWages) {
                employeeMaxWages = this.employeeList[i].getName();
                maxWages = this.employeeList[i].getWages();
            }
        }

        return employeeMaxWages;
    }

    public String findEmployeeMinWagesInDepartment(int department) {

        int startPoint = firstNonNullRecordInDepartment(department);
        String employeeMinWages = this.employeeList[startPoint].getName();
        double minWages = this.employeeList[startPoint].getWages();

        for (int i = startPoint + 1; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department && this.employeeList[i].getWages() < minWages) {
                employeeMinWages = this.employeeList[i].getName();
                minWages = this.employeeList[i].getWages();
            }
        }
        return employeeMinWages;
    }

    public String findEmployeeMaxWagesInDepartment(int department) {

        int startPoint = firstNonNullRecordInDepartment(department);
        String employeeMaxWages = this.employeeList[startPoint].getName();
        double maxWages = this.employeeList[startPoint].getWages();

        for (int i = startPoint + 1; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department && this.employeeList[i].getWages() > maxWages) {
                employeeMaxWages = this.employeeList[i].getName();
                maxWages = this.employeeList[i].getWages();
            }
        }
        return employeeMaxWages;
    }


    public void increaseAllWages(double increment) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null) {
                this.employeeList[i].setWages(this.employeeList[i].getWages() * (1 + increment / 100.0));
            }
        }
    }

    public void increaseAllWagesByDepartment(int department, double increment) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department) {
                this.employeeList[i].setWages(this.employeeList[i].getWages() * (1 + increment / 100.0));
            }
        }
    }

    public void printWhoseWageIsLower(double wageLevel) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getWages() < wageLevel) {
                System.out.println(this.employeeList[i].toStringWODepartment());
            }
        }
    }

    public void printWhoseWageIsHigher(double wageLevel) {
        for (int i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getWages() >= wageLevel) {
                System.out.println(this.employeeList[i].toStringWODepartment());
            }
        }
    }

    public int firstNonNullRecord() {

        int i;
        for (i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null) {
                break;
            }
        }

        if (i < Employee.idCounter) {
            return i;
        } else {
            throw new RuntimeException("Список работников пуст");
        }
    }

    public int firstNonNullRecordInDepartment(int department) {

        int i;
        for (i = 0; i < Employee.idCounter; i++) {
            if (this.employeeList[i] != null && this.employeeList[i].getDepartment() == department) {
                break;
            }
        }

        if (i < Employee.idCounter) {
            return i;
        } else {
            throw new RuntimeException("Выбранный отдел пуст");
        }
    }
}
