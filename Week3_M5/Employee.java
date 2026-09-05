public class Employee {

    String empName;
    double salary;

    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    public Employee(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    public static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println(
            "Employees on record: " +
            employeeCount
        );
    }
}