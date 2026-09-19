class LibraryMemberBasic {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMemberBasic(String memberId, int borrowLimit) {

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
}


class StudentMemberBasic extends LibraryMemberBasic {

    private String course;

    public StudentMemberBasic(String memberId, int borrowLimit,
                              String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
}


public class LibraryMembershipBasic {

    public static String enrollBatch(
            String[] memberIds, int borrowLimit) {

        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMemberBasic(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled +
               " | Rejected: " + rejected;
    }


    public static void main(String[] args) {

        LibraryMemberBasic member =
                new LibraryMemberBasic("MEM1", 3);

        member.borrowBook();
        member.borrowBook();

        System.out.println(
            member.getBooksBorrowed()
        );


        String[] ids = {
            "STU1",
            "LB1",
            "STU2",
            " ",
            "STU3"
        };

        System.out.println(
            enrollBatch(ids, 3)
        );
    }
}