public class Main {
    public static void main(String[] args) {

        int employeeListSize = 20;
        EmployeeBook employeeList = new EmployeeBook(employeeListSize);

        employeeList.addEmployeeToBook("Лев Николаевич Мышкин", 1, 12345.50);
        employeeList.addEmployeeToBook("Настасья Филипповна Барашкова ", 4, 6676.66);
        employeeList.addEmployeeToBook("Парфён Семёнович Рогожин", 2, 5555.55);
        employeeList.addEmployeeToBook("Гаврила Ардалионович Иволгин", 3, 4444.40);
        employeeList.addEmployeeToBook("Аглая Ивановна Епанчина", 4, 1234.50);
        employeeList.addEmployeeToBook("Афанасий Иванович Тоцкий", 3, 1000000.00);

        employeeList.removeEmployeeFromBook(5);

        employeeList.addEmployeeToBook("Фердыщенко",5,1000);

        employeeList.changeEmployeeWage("Фердыщенко", 2000);
        employeeList.changeEmployeeDepartment("Афанасий Иванович Тоцкий", 5);

        employeeList.printEmployeeBookByDepartments();

    }

}