import java.util.Arrays;


class LibraryMemberFine {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    private int[] fineHistory = new int[10];
    private int fineCount = 0;


    public LibraryMemberFine(
            String memberId,
            int borrowLimit) {

        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("Invalid borrow limit");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }


    public void borrowBook() {
        booksBorrowed++;
    }


    public int getBooksBorrowed() {
        return booksBorrowed;
    }


    protected void chargeFine(int amount) {

        if (fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }


    public int[] getFineHistory() {

        return Arrays.copyOf(
            fineHistory,
            fineCount
        );
    }


    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }
}


class StudentMemberFine extends LibraryMemberFine {

    private String course;


    public StudentMemberFine(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }


    @Override
    protected void chargeFine(int amount) {

        super.chargeFine(amount / 2);
    }
}


public class LibraryFineLedger {

    public static void main(String[] args) {

        StudentMemberFine student =
                new StudentMemberFine(
                    "STU5",
                    3,
                    "CSE"
                );


        student.chargeFine(100);


        System.out.println(
            student.getTotalFine()
        );


        int[] history =
                student.getFineHistory();


        history[0] = 999;


        System.out.println(
            student.getFineHistory()[0]
        );
    }
}