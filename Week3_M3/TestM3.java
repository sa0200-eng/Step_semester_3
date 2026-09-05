public class TestM3 {

    public static void main(String[] args) {

        Employee permanent =
            new Employee(
                "E-101",
                "Divya",
                65000
            );

        Employee intern =
            new Employee(
                "E-102",
                "Arjun"
            );

        permanent.printProfile();
        intern.printProfile();
    }
}