public class TestProblem4 {

    public static void main(String[] args) {

        MovieBookingProfile profile =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(profile.getName());

        profile.setConfirmed(true);

        System.out.println(profile.isConfirmed());

        profile.setOtp("4471");

        System.out.println("OTP stored successfully.");
        System.out.println("OTP cannot be retrieved.");
    }
}