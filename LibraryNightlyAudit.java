class LibraryMemberAudit {

    protected int borrowLimit;
    protected int booksBorrowed;

    private static int membersEnrolled = 0;

    public final String memberNumber;

    private String lastGenre;


    public LibraryMemberAudit(int borrowLimit) {

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                "Invalid borrow limit"
            );
        }


        membersEnrolled++;


        memberNumber =
                "LIB-" + (100 + membersEnrolled);


        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }


    public void borrowBook() {

        booksBorrowed++;
    }


    public void borrowBook(String genre) {

        lastGenre = genre;

        borrowBook();
    }


    public int getBooksBorrowed() {

        return booksBorrowed;
    }


    public static boolean isValidRenewalCode(
            String code) {

        if (code == null || code.length() != 4) {
            return false;
        }


        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }


    public static int getMembersEnrolled() {

        return membersEnrolled;
    }
}


class FacultyMemberAudit
        extends LibraryMemberAudit {

    private String department;


    public FacultyMemberAudit(
            int borrowLimit,
            String department) {

        super(borrowLimit);
        this.department = department;
    }
}


public class LibraryNightlyAudit {


    public static String processNightlyAudit(
            LibraryMemberAudit[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;


        for (LibraryMemberAudit member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }


            processed++;


            if (member instanceof FacultyMemberAudit) {
                faculty++;
            } else {
                regular++;
            }
        }


        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + faculty
                + " faculty | "
                + regular
                + " regular";
    }


    public static void main(String[] args) {

        LibraryMemberAudit m1 =
                new LibraryMemberAudit(3);


        System.out.println(
            m1.memberNumber
        );


        System.out.println(
            LibraryMemberAudit.getMembersEnrolled()
        );


        System.out.println(
            LibraryMemberAudit.isValidRenewalCode(
                "R12A"
            )
        );


        System.out.println(
            LibraryMemberAudit.isValidRenewalCode(
                "R1A"
            )
        );


        System.out.println(
            LibraryMemberAudit.isValidRenewalCode(
                "X12A"
            )
        );


        m1.borrowBook();

        m1.borrowBook("Fiction");


        System.out.println(
            m1.getBooksBorrowed()
        );


        LibraryMemberAudit[] members = {

            new FacultyMemberAudit(
                5,
                "Physics"
            ),

            null,

            new LibraryMemberAudit(
                3
            )
        };


        System.out.println(
            processNightlyAudit(members)
        );
    }
}