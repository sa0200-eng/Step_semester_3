public class TestM2 {

    public static void main(String[] args) {

        PayrollAccount account =
            new PayrollAccount(50000);

        account.creditBonus(5000);

        account.deductTax(10);

        System.out.println(
            "Net salary: Rs " +
            account.getNetSalary()
        );
    }
}