public class Employee {
    int id;
    String name;
    int department;
    double wages;
    static int idCounter = 0;

    public Employee(String name, int department, double wages) {
        this.id = 1 + idCounter++;
        this.name = name;
        if (department > 0 && department < 6) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Не корректный номер отдела (должен быть от 1 до 5)");
        }
        if (wages >= 0.0) {
            this.wages = wages;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

    @Override
    public String toString() {
        return id + ". " + name + ". Отдел №" + department + ". Зарплата " + wages + " р.";
    }

    public String toStringWODepartment() {
        return id + ". " + name + ". Зарплата " + wages + " р.";
    }
}
