public class TestProblem1 {

    public static void main(String[] args) {

        System.out.println(
            AccessChecker.classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
            AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE")
        );

        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            AccessChecker.summarizeBatch(attempts)
        );

        MovieTicket ticket = new MovieTicket(
            "A1",
            "Screen-1",
            250.0,
            "Avengers"
        );

        System.out.println("Movie: " + ticket.movieTitle);
        System.out.println("Ticket created successfully.");
    }
}