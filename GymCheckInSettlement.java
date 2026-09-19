class GymMemberSettlement {

    protected int monthlyFee;
    protected int sessionsAttended;

    private static int membersEnrolled = 0;

    public final String membershipNumber;

    private int feesPaid = 0;


    public GymMemberSettlement(int monthlyFee) {

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                "Invalid monthly fee"
            );
        }

        membersEnrolled++;

        membershipNumber =
                "GYM-" + (2000 + membersEnrolled);

        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }


    public void attendSession() {
        sessionsAttended++;
    }


    public void payFee(int amount) {
        feesPaid += amount;
    }


    public void payFee(int amount, String mode) {

        // Payment mode is accepted here.
        // Actual payment logic is reused.
        payFee(amount);
    }


    public int getFeesPaid() {
        return feesPaid;
    }


    public static int getMembersEnrolled() {
        return membersEnrolled;
    }


    public static boolean isValidReferralCode(
            String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }
}


class GroupClassMemberSettlement
        extends GymMemberSettlement {

    private String className;


    public GroupClassMemberSettlement(
            int monthlyFee,
            String className) {

        super(monthlyFee);
        this.className = className;
    }
}


public class GymCheckInSettlement {


    public static String processWeeklyCheckIn(
            GymMemberSettlement[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;


        for (GymMemberSettlement member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }


            processed++;


            if (member instanceof GroupClassMemberSettlement) {
                group++;
            } else {
                individual++;
            }
        }


        return processed
                + " processed | "
                + nullSkipped
                + " null skipped | "
                + group
                + " group | "
                + individual
                + " individual";
    }


    public static void main(String[] args) {

        GymMemberSettlement m1 =
                new GymMemberSettlement(1000);


        System.out.println(
            m1.membershipNumber
        );


        System.out.println(
            GymMemberSettlement.getMembersEnrolled()
        );


        System.out.println(
            GymMemberSettlement.isValidReferralCode(
                "G45B"
            )
        );


        System.out.println(
            GymMemberSettlement.isValidReferralCode(
                "G4B"
            )
        );


        System.out.println(
            GymMemberSettlement.isValidReferralCode(
                "X45B"
            )
        );


        m1.payFee(500);
        m1.payFee(500, "UPI");


        System.out.println(
            m1.getFeesPaid()
        );


        GymMemberSettlement[] members = {

            new GroupClassMemberSettlement(
                1500,
                "Zumba"
            ),

            null,

            new GymMemberSettlement(
                1000
            )
        };


        System.out.println(
            processWeeklyCheckIn(members)
        );
    }
}