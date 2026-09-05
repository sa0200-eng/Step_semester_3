public class TestProblem5 {

    public static void main(String[] args) {

        BookingReceipt booking =
            new BookingReceipt(
                "CH-1001",
                new String[]{"A1", "A2"}
            );

        // Test defensive copy from getter
        String[] seats = booking.getSeatNumbers();
        seats[0] = "X";

        System.out.println(
            "Original first seat: " +
            booking.getSeatNumbers()[0]
        );

        // Test withUpdatedSeat()
        BookingReceipt updated =
            booking.withUpdatedSeat(1, "A3");

        System.out.println(
            "Original receipt: " +
            java.util.Arrays.toString(
                booking.getSeatNumbers()
            )
        );

        System.out.println(
            "Updated receipt: " +
            java.util.Arrays.toString(
                updated.getSeatNumbers()
            )
        );

        // Test nightly settlement
        BookingReceipt[] receipts = {

            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2
            ),

            null,

            new BookingReceipt(
                "CH-3003",
                new String[]{"C1"}
            )
        };

        System.out.println(
            BookingReceipt.processNightlySettlement(receipts)
        );
    }
}