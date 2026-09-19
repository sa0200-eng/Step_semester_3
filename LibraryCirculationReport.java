class LibraryMemberReport {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;


    public LibraryMemberReport(
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


    public String displayInfo() {

        return "General | Books: "
                + booksBorrowed;
    }
}


class StudentMemberReport
        extends LibraryMemberReport {

    private String course;


    public StudentMemberReport(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }


    public String getCourse() {
        return course;
    }


    @Override
    public String displayInfo() {

        return "Student | Course: "
                + course
                + " | Books: "
                + booksBorrowed;
    }
}


public class LibraryCirculationReport {


    public static String batchPrint(
            LibraryMemberReport[] members) {

        StringBuilder result =
                new StringBuilder();


        for (LibraryMemberReport member : members) {

            result.append(
                member.displayInfo()
            );


            if (member instanceof StudentMemberReport) {

                StudentMemberReport student =
                        (StudentMemberReport) member;


                result.append(
                    " [Course via downcast: "
                    + student.getCourse()
                    + "]"
                );
            }


            result.append(" | ");
        }


        return result.toString();
    }


    public static void main(String[] args) {

        LibraryMemberReport general =
                new LibraryMemberReport(
                    "LB5",
                    3
                );


        StudentMemberReport student =
                new StudentMemberReport(
                    "STU6",
                    3,
                    "ECE"
                );


        LibraryMemberReport[] members = {
            general,
            student
        };


        System.out.println(
            batchPrint(members)
        );
    }
}