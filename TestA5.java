public class TestA5 {

    public static void processTransaction(
            Payment payment,
            double amount) {

        if (payment instanceof CardPayment) {

            CardPayment cardPayment =
                (CardPayment) payment;

            cardPayment.payWithProcessingFee(amount);

        } else {

            payment.pay(amount);
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {
            100,
            50,
            200,
            75,
            120
        };

        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {

            processTransaction(
                payments[i],
                amounts[i]
            );

            if (payments[i] instanceof CardPayment) {
                totalCollected +=
                    amounts[i] +
                    (amounts[i] * 0.02);
            } else {
                totalCollected += amounts[i];
            }
        }

        System.out.println(
            "Total Collected: Rs " +
            totalCollected
        );
    }
}