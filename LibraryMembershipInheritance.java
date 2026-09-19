class LibraryMemberInheritance {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMemberInheritance(
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


    public void displayInfo() {

        System.out.println(
            "General Member | Books Borrowed: "
            + booksBorrowed
        );
    }
}


class StudentMemberInheritance
        extends LibraryMemberInheritance {

    protected String course;


    public StudentMemberInheritance(
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
    public void displayInfo() {

        System.out.println(
            "Student Member | Course: "
            + course
            + " | Books Borrowed: "
            + booksBorrowed
        );
    }
}


class HonorsStudentMemberInheritance
        extends StudentMemberInheritance {

    private int bonusLimit;


    public HonorsStudentMemberInheritance(
            String memberId,
            int borrowLimit,
            String course,
            int bonusLimit) {

        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }


    @Override
    public void displayInfo() {

        System.out.println(
            "Honors Student Member | Course: "
            + course
            + " | Bonus Limit: "
            + bonusLimit
            + " | Books Borrowed: "
            + booksBorrowed
        );
    }
}


class FacultyMemberInheritance
        extends LibraryMemberInheritance {

    private String department;


    public FacultyMemberInheritance(
            String memberId,
            int borrowLimit,
            String department) {

        super(memberId, borrowLimit);
        this.department = department;
    }


    @Override
    public void displayInfo() {

        System.out.println(
            "Faculty Member | Department: "
            + department
            + " | Books Borrowed: "
            + booksBorrowed
        );
    }
}


public class LibraryMembershipInheritance {


    public static String classifyGeneration(
            LibraryMemberInheritance member) {

        if (member instanceof HonorsStudentMemberInheritance) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMemberInheritance) {
            return "Hierarchical sibling (independent branch)";
        }

        return "General/Student branch";
    }


    public static int getTotalBooksBorrowed(
            LibraryMemberInheritance[] members) {

        int total = 0;

        for (LibraryMemberInheritance member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }


    public static void main(String[] args) {

        LibraryMemberInheritance general =
                new LibraryMemberInheritance(
                    "STU1", 3
                );

        StudentMemberInheritance student =
                new StudentMemberInheritance(
                    "STU2", 3, "CSE"
                );

        HonorsStudentMemberInheritance honors =
                new HonorsStudentMemberInheritance(
                    "STU3", 3, "ECE", 2
                );

        FacultyMemberInheritance faculty =
                new FacultyMemberInheritance(
                    "STU4", 5, "Physics"
                );


        general.displayInfo();
        student.displayInfo();
        honors.displayInfo();
        faculty.displayInfo();


        System.out.println(
            classifyGeneration(honors)
        );

        System.out.println(
            classifyGeneration(faculty)
        );


        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();


        LibraryMemberInheritance[] members = {
            student,
            honors,
            faculty
        };


        System.out.println(
            getTotalBooksBorrowed(members)
        );
    }
}