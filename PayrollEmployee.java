public class PayrollEmployee {

    String empId;
    double salary;

    public PayrollEmployee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public static void main(String[] args) {

        PayrollEmployee[] employees = {
            new PayrollEmployee("E-101", 40000),
            new PayrollEmployee("E-102", 55000),
            new PayrollEmployee("E-103", 62000),
            new PayrollEmployee("E-104", 48000)
        };

        for (PayrollEmployee employee : employees) {
            employee.raiseSalary(5000);

            System.out.println(
                employee.empId +
                " | Final Salary: Rs " +
                employee.salary
            );
        }
    }
}