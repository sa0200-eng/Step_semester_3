public class TestProblem3 {

    public static void main(String[] args) {

        CineScreen screen = new CineScreen(2);

        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat();

        System.out.println(
            "After 3 bookings: " +
            screen.getSeatsAvailable()
        );

        screen.cancelBooking();
        screen.cancelBooking();
        screen.cancelBooking();

        System.out.println(
            "After 3 cancellations: " +
            screen.getSeatsAvailable()
        );

        try {
            CineScreen invalidScreen = new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid screen rejected.");
        }
    }
}